package com.blog.blog_app.controllers;

import com.blog.blog_app.entities.Post;
import com.blog.blog_app.payloads.ApiResponse;
import com.blog.blog_app.payloads.CommentDto;
import com.blog.blog_app.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto
    ,@PathVariable Integer postId){

       CommentDto createdComment =  this.commentService.createComment(commentDto,postId);

       return new ResponseEntity<CommentDto>(createdComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
        this.commentService.deleteComment(commentId);

        return  new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Comment Successfully !!!",true),HttpStatus.OK);
    }
}
