package com.spring.bytecode.service.impl;

import com.spring.bytecode.model.Post;
import com.spring.bytecode.service.PostService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ServiceUno")
public class PostServiceImpl  implements PostService {
    private Log log = LogFactory.getLog(getClass());

    @Override
    public List<Post> validation(List<Post> posts) {
        log.info("primer servicio");
        //System.out.println("primer servicio");
        for (Post post : posts){
            if(post.getTitulo() == null){
               throw new NullPointerException("No tiene el titulo");
            }
        }
        return posts;
    }
}
