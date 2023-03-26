package com.myblognew7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myblognew7.payload.PostDto;
import com.myblognew7.payload.PostResponse;
import com.myblognew7.services.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping
	public ResponseEntity<PostDto> savePosts(@RequestBody PostDto postDto) {
		PostDto dto = postService.savePost(postDto);
		return new ResponseEntity<> (dto, HttpStatus.CREATED);
	}
	
	@GetMapping
	public PostResponse getPosts(
			@RequestParam(value = "pageNo", defaultValue="0", required=false) Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue="3", required=false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue="id", required=false) String sortBy,
			@RequestParam(value="sortDir", defaultValue="ASC", required=false) String sortDir
			) {
		PostResponse postResponse = postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
		return postResponse;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getPostsById(@PathVariable("id") Long id) {
		PostDto dto = postService.getPostById(id);
		return new ResponseEntity<> (dto, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updatePosts(@PathVariable("id") Long id, @RequestBody PostDto postDto) {
		PostDto dto = postService.updatePostById(id, postDto);
		return new ResponseEntity<> (dto, HttpStatus.ACCEPTED);
	}

}
