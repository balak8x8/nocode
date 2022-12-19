package com.nocode.service;

import com.nocode.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import com.jcabi.aspects.Loggable;

@Service
/*Loggable is the aspect that logs function exit, prepend will log the entry aldo
logThis will log the toString function. since the default aspect logging is not
logging the target class name we have to use this for now
if we want to log the whole result or request we can use trim=false
https://aspects.jcabi.com/annotation-loggable.html
*/
@Loggable(prepend = true, logThis = true)
public class RemoteServiceImpl {
    @Autowired
    RestTemplate restTemplate;

    public List<Comment> getComments(Long postId) {
        //log.info("getPost Called");
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/{postId}/comments",
                List.class, postId);
    }
}
