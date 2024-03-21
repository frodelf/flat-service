package com.example.flatservice.repository;

import com.example.flatservice.entity.Flat;
import com.example.flatservice.entity.enums.StatusState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FlatRepository extends JpaRepository<Flat, Long>, JpaSpecificationExecutor<Flat> {
    Page<Flat> findAllByCorps(Long corpsId, Pageable pageable);
    Page<Flat> findAllByStatusState(StatusState statusState, Pageable pageable);
}