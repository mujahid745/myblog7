package com.myblognew7.services;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myblognew7.entities.Post;
import com.myblognew7.exception.ResourceNotFoundException;
import com.myblognew7.payload.PostDto;
import com.myblognew7.payload.PostResponse;
import com.myblognew7.repositories.PostRepository;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PostDto savePost(PostDto postDto) {
		Post post = mapToEntity(postDto);
		Post newPost = postRepo.save(post);
		PostDto dto = mapToDto(newPost);
		return dto;
	}

	public PostDto mapToDto(Post newPost) {
		PostDto dto = modelMapper.map(newPost, PostDto.class);
		return dto;
	}

	public Post mapToEntity(PostDto postDto) {
		Post post = modelMapper.map(postDto, Post.class);
		return post;
		
	}

	@Override
	public PostResponse getAllPosts(Integer pageNo, Integer pageSize, String sortBy, String sortDir) {
		// Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
         if(sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())) {
        	 Sort sort = Sort.by(sortBy).ascending();
        	 Pageable pageable= PageRequest.of(pageNo, pageSize, sort);
	       	 Page<Post> page = postRepo.findAll(pageable);
	       	 List<Post> posts = page.getContent();
		     List<PostDto> contents = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
		     
		     PostResponse postResponse = new PostResponse();
		     postResponse.setContent(contents);
		     postResponse.setPageNo(page.getNumber());
		     postResponse.setPageSize(page.getSize());
		     postResponse.setTotalElements(page.getTotalElements());
		     postResponse.setTotalPages(page.getTotalPages());
		     postResponse.setLast(page.isLast());
		     
		     return postResponse;
	       	 
         } else {
        	 Sort sort = Sort.by(sortBy).descending();
        	 Pageable pageable= PageRequest.of(pageNo, pageSize, sort);
	       	 Page<Post> page = postRepo.findAll(pageable);
	       	 List<Post> posts = page.getContent();
             List<PostDto> contents = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
		     
		     PostResponse postResponse = new PostResponse();
		     postResponse.setContent(contents);
		     postResponse.setPageNo(page.getNumber());
		     postResponse.setPageSize(page.getSize());
		     postResponse.setTotalElements(page.getTotalElements());
		     postResponse.setTotalPages(page.getTotalPages());
		     postResponse.setLast(page.isLast());
		     
		     return postResponse;
         }
		 
		
	}

	@Override
	public PostDto getPostById(Long id) {
	 Post post = postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
	 PostDto dto = mapToDto(post);
	 return dto;
	}

	@Override
	public PostDto updatePostById(Long id, PostDto postDto) {
		Post post = postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		
		Post postNew = postRepo.save(post);
		PostDto dto = mapToDto(postNew);
		return dto;
	}

}
