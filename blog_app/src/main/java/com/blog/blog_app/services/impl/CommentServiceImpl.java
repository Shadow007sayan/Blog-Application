package com.blog.blog_app.services.impl;

import com.blog.blog_app.entities.Comment;
import com.blog.blog_app.entities.Post;
import com.blog.blog_app.exceptions.ResourceNotFoundException;
import com.blog.blog_app.payloads.CommentDto;
import com.blog.blog_app.repositories.CommentRepo;
import com.blog.blog_app.repositories.PostRepo;
import com.blog.blog_app.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId){
        Post  post =  this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post","post id",postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);

        comment.setPost(post);

        Comment savedComment = this.commentRepo.save(comment);

        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId){
        Comment com = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "commentId",commentId));

        this.commentRepo.delete(com);
    }
}
