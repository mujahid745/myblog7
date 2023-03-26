package com.myblognew7.services;

import java.util.List;

import com.myblognew7.payload.PostDto;
import com.myblognew7.payload.PostResponse;

public interface PostService {

	PostDto savePost(PostDto postDto);

	PostResponse getAllPosts(Integer pageNo, Integer pageSize, String sortBy, String sortDir);

	PostDto getPostById(Long id);

	PostDto updatePostById(Long id, PostDto postDto);

}
