package com.leinaro.move.move.service;

import com.leinaro.move.move.entity.Box;
import com.leinaro.move.move.repository.BoxRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoxService {

    private BoxRepository boxRepository;

    public Box saveBox(Box box, Map<String, String> data) {

        return boxRepository.save(box);
    }

//    public ResponseEntity<List<Box>> findAll() {
//        return boxRepository.findAll();
//    }
}
