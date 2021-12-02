package com.titjavaweb.news.ApiController;

import com.titjavaweb.news.ApiController.Output.PostOutput;
import com.titjavaweb.news.DTO.PostDto;
import com.titjavaweb.news.service.IPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostApi {

    @Autowired
    private IPostService postService;

    @GetMapping("/post")
    public PostOutput getPost(@RequestParam("page") int page, @RequestParam("limit") int limit){
        PostOutput results = new PostOutput();
        results.setPage(page);
        Pageable pageable = PageRequest.of(page - 1, limit);
        results.setListPostDto(postService.findAll(pageable));
        results.setTotalPages((int) Math.ceil((double) (postService.totalPost()) / limit ));
        return results;
    }

    @PostMapping("/post")
    public PostDto creatPost(@RequestBody PostDto newPost) {
        return postService.save(newPost);
    }

    @PutMapping("/post/{id}")
    public PostDto updatePost(@RequestBody PostDto post, @PathVariable("id") Long id) {
        post.setId(id);
        return postService.save(post);
    }

    @DeleteMapping("/post")
    public void DeletePost(@RequestBody Long[] ids){
         postService.delete(ids);
    }
}
