package com.myblognew7.repositories;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myblognew7.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {


}
