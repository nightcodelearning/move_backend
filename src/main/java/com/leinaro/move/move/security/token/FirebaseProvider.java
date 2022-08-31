package com.leinaro.move.move.security.token;

import com.google.firebase.auth.*;
import com.leinaro.move.move.security.model.TokenModel;
import com.leinaro.move.move.security.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class FirebaseProvider implements AuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(FirebaseProvider.class);

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        TokenModel token = (TokenModel) authentication;
        try {
            FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdToken(token.getToken(),true);
            String uid = firebaseToken.getUid();
            UserRecord userRecord = FirebaseAuth.getInstance().getUser(uid);
            return new UserModel(userRecord);

        } catch (FirebaseAuthException e) {
            logger.error("Fail: {}", getErrorCode(e.getAuthErrorCode()));


        }
        return null;
    }

    private String getErrorCode(AuthErrorCode errorCode){
        String error;
        switch(errorCode.toString()){
            case "EXPIRED_ID_TOKEN":
                error = "token expired";
                break;
            case "INVALID_ID_TOKEN":
                error = "token invalid";
                break;
            case "REVOKED_ID_TOKEN":
                error = "token revoked";
                break;
            case "CONFIGURATION_NOT_FOUND":
                error = "configuration not found";
                break;
            default:
                error = "Authentication Failed";
        }
        return error;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(TokenModel.class);
    }
}
