package com.myblognew7.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myblognew7.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	List<Comment> findByPostId(long postId);

}
