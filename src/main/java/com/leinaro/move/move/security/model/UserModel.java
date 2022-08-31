package com.leinaro.move.move.security.model;

import com.google.firebase.auth.UserRecord;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserModel implements Authentication {

    private UserRecord userRecord;

    public UserModel(UserRecord userRecord) {
        this.userRecord = userRecord;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        Map<String, String> details = new HashMap<>();
        details.put("name", userRecord.getDisplayName());
        details.put("email", userRecord.getEmail());
        details.put("uid", userRecord.getUid());
        details.put("photoUrl", userRecord.getPhotoUrl());
        return details;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return userRecord.getDisplayName();
    }

    public String getEmail(){
        return userRecord.getEmail();
    }

    public String getUid(){
        return userRecord.getUid();
    }

    public String getPhotoUrl(){
        return userRecord.getPhotoUrl();
    }





}
