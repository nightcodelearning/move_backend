package com.leinaro.move.move.repository;

import com.leinaro.move.move.entity.Box;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoxRepository extends JpaRepository<Box, UUID> {
}
