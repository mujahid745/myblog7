package com.myblognew7.services;

import java.util.List;

import com.myblognew7.payload.CommentDto;

public interface CommentService {

	CommentDto saveComment(Long postId, CommentDto commentDto);

	List<CommentDto> getAllComments(Long postId);

}
