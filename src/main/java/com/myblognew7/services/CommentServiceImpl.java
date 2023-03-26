package com.myblognew7.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblognew7.entities.Comment;
import com.myblognew7.entities.Post;
import com.myblognew7.exception.ResourceNotFoundException;
import com.myblognew7.payload.CommentDto;
import com.myblognew7.repositories.CommentRepository;
import com.myblognew7.repositories.PostRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto saveComment(Long postId, CommentDto commentDto) {
		Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));
		
	   Comment comment = mapToComment(commentDto);
	   comment.setPost(post);
	   Comment newComment = commentRepo.save(comment);
	   CommentDto dto = mapToCommentDto(newComment);
		return dto;
	}

	public CommentDto mapToCommentDto(Comment newComment) {
		CommentDto dto = modelMapper.map(newComment, CommentDto.class);
		return dto;
	}

	public Comment mapToComment(CommentDto commentDto) {
		Comment comment = modelMapper.map(commentDto, Comment.class);
		return comment;
	}

	@Override
	public List<CommentDto> getAllComments(Long postId) {
	
		List<Comment> comments = commentRepo.findByPostId(postId);
		List<CommentDto> commentDto = comments.stream().map(c->mapToCommentDto(c)).collect(Collectors.toList());
		return commentDto;
	}

}
