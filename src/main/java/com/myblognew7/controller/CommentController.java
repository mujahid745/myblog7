package com.myblognew7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myblognew7.payload.CommentDto;
import com.myblognew7.services.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDto> saveComments(@PathVariable("postId") Long postId, @RequestBody CommentDto commentDto) {
		CommentDto dto = commentService.saveComment(postId, commentDto);
		return new ResponseEntity<> (dto, HttpStatus.CREATED);
	}
	
	@GetMapping("/post/{postId}/comments")
	public List<CommentDto> getComments(@PathVariable("postId") long postId) {
		List<CommentDto> commentDto = commentService.getAllComments(postId);
		return commentDto;
	}

}
