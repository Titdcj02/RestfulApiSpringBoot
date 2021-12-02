package com.titjavaweb.news.repository;

import com.titjavaweb.news.entity.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    
    CategoryEntity findOneByCode(String code);
}
