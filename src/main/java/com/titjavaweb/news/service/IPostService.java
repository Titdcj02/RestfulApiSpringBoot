package com.titjavaweb.news.service;

import java.util.List;

import com.titjavaweb.news.DTO.PostDto;

import org.springframework.data.domain.Pageable;

public interface IPostService {
    
    public PostDto save(PostDto postDto);
    public void delete(Long[] ids);
    public List<PostDto> findAll(Pageable pageable);
    public int totalPost();
}
