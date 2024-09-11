package com.blog.blog_app.services;

import com.blog.blog_app.payloads.CommentDto;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    CommentDto createComment(CommentDto commentDto,Integer postId);

    void deleteComment(Integer commentId);

    // Rest function for update ,.. implement later
}
