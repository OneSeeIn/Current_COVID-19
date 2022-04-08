package com.example.COVID19.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface C_CovidRepository extends PagingAndSortingRepository<C_Covid, Integer>,JpaRepository<C_Covid,Integer> {
    Page<C_Covid> findAll(Pageable pageable);
}
