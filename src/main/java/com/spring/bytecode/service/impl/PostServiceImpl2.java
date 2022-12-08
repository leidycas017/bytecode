package com.spring.bytecode.service.impl;

import com.spring.bytecode.model.Post;
import com.spring.bytecode.service.PostService;
import javafx.geometry.Pos;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("serviceDos")
public class PostServiceImpl2 implements PostService {
    private Log log = LogFactory.getLog(getClass());

    @Override
    public List<Post> validation(List<Post> posts) {
        log.info("segundo servicio");
        //System.out.println("segundo servicio");
        for(Post post : posts){
            if (post.getId() == 0){
                throw new NullPointerException("Id 0");
            }
        }
        return posts;
    }
}
