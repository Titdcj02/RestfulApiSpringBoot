package com.titjavaweb.news.repository;

import com.titjavaweb.news.entity.PostEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    
}
