package com.example.COVID19.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//create memeberRepository

@Repository
public interface MemberRepository extends PagingAndSortingRepository<Member, String>, JpaRepository<Member, String> {

    Optional<Member> findByIdAndPwd(String id, String pwd);
    

}