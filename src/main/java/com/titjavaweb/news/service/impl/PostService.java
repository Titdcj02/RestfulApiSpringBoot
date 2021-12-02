package com.titjavaweb.news.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.titjavaweb.news.DTO.PostDto;
import com.titjavaweb.news.converter.PostConverter;
import com.titjavaweb.news.entity.CategoryEntity;
import com.titjavaweb.news.entity.PostEntity;
import com.titjavaweb.news.repository.CategoryRepository;
import com.titjavaweb.news.repository.PostRepository;
import com.titjavaweb.news.service.IPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService{
    
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PostConverter postConverter;

    @Override
    public PostDto save(PostDto postDto) {
        PostEntity postEntity = new PostEntity();
        if(postDto.getId() != null){
            PostEntity oldPostEntity = postRepository.getById(postDto.getId());
            postEntity = postConverter.toEntity(postDto, oldPostEntity);
        } else {
            postEntity = postConverter.toEntity(postDto);
        }
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(postDto.getCategoryCode());
        postEntity.setCategory(categoryEntity);
        postEntity = postRepository.save(postEntity);
        return postConverter.toDto(postEntity);
    } 

    @Override
    public void delete(Long[] ids) {
        for(Long id : ids){
            postRepository.deleteById(id);
        }
    }

    @Override
    public List<PostDto> findAll(Pageable pageable) {
        List<PostDto> results = new ArrayList<>();
        List<PostEntity> resultEntitys = postRepository.findAll(pageable).getContent();
        for(PostEntity postEntity : resultEntitys){
            results.add(postConverter.toDto(postEntity));
        }
        return results;
    }

    @Override
    public int totalPost() {
        return (int) postRepository.count();
    }
}
