package com.nocode.controller;

import com.nocode.pojo.Comment;
import com.nocode.service.RemoteServiceImpl;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.jcabi.aspects.Loggable;

@RestController
@ToString
@Loggable(prepend = true, logThis = true)
@RequestMapping("/api/v1/remoteservice")
public class RemoteController {

    @Autowired
    RemoteServiceImpl remoteService;

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable("postId") Long postId) {
        return new ResponseEntity<>(remoteService.getComments(postId), HttpStatus.OK);
    }
}
