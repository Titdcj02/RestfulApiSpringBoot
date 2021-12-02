package com.titjavaweb.news.ApiController.Output;

import java.util.ArrayList;
import java.util.List;

import com.titjavaweb.news.DTO.PostDto;

public class PostOutput {
    private int page;
    private int totalPages;
    private List<PostDto> listPostDto = new ArrayList<>();
    
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public List<PostDto> getListPostDto() {
        return listPostDto;
    }
    public void setListPostDto(List<PostDto> listPostDto) {
        this.listPostDto = listPostDto;
    }
    
}
