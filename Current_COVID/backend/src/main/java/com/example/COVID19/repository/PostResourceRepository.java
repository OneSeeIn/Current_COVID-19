package com.example.COVID19.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//make  postResource repository

@Repository
public interface PostResourceRepository extends PagingAndSortingRepository<PostResource, Long>, JpaRepository<PostResource, Long> {

        List<PostResource> findByPostId(Post post);
}