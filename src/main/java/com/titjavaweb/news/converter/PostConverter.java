package com.titjavaweb.news.converter;

import com.titjavaweb.news.DTO.PostDto;
import com.titjavaweb.news.entity.PostEntity;
import org.springframework.stereotype.Component;


@Component
public class PostConverter {
    
    public PostEntity toEntity(PostDto dto) {
       PostEntity postEntity = new PostEntity();
       postEntity.setTitle(dto.getTitle());
       postEntity.setContent(dto.getContent());
       postEntity.setShortDescription(dto.getShortDescription());
       postEntity.setThumbnail(dto.getThumbnail());
        return postEntity;
    }

    public PostDto toDto(PostEntity postEntity) {
        PostDto postDto = new PostDto();
        if(postEntity.getId() != null){
            postDto.setId(postEntity.getId());
        }
        postDto.setTitle(postEntity.getTitle());
        postDto.setContent(postEntity.getContent());
        postDto.setThumbnail(postEntity.getThumbnail());
        postDto.setShortDescription(postEntity.getShortDescription());
        postDto.setModifiedDate(postEntity.getModifiedDate());
        postDto.setModifiedBy(postEntity.getModifiedBy());
        postDto.setCreatedBy(postEntity.getCreatedBy());
        postDto.setCreatedDate(postEntity.getCreatedDate());
        return postDto;
    }

    public PostEntity toEntity(PostDto dto, PostEntity postEntity) {
        postEntity.setTitle(dto.getTitle());
        postEntity.setContent(dto.getContent());
        postEntity.setShortDescription(dto.getShortDescription());
        postEntity.setThumbnail(dto.getThumbnail());
        return postEntity;
    }
}
