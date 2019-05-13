package com.javaproject.rest.example.restfulwebservices.user.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaproject.rest.example.restfulwebservices.user.post.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
