package com.spot4sport.app.repository;

import com.spot4sport.app.model.Court;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtRepository extends JpaRepository<Court, Long> {
}
