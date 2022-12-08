package com.spring.bytecode.service.impl;

import com.spring.bytecode.model.Post;
import com.spring.bytecode.service.PostService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("serviceDecorado")
@Scope("singleton")
public class PostServiceDecoradoImpl implements PostService {
    private final Log log = LogFactory.getLog(getClass());

    @Autowired
    private PostServiceImpl postServiceImpl;

    @Autowired
    private PostServiceImpl2 postServiceImpl2;

    @Override
    public List<Post> validation(List<Post> posts) {
        log.debug(posts);
        posts = postServiceImpl.validation(posts);
        posts = postServiceImpl2.validation(posts);
        for(Post post : posts){
            if (post.getDescripcion() == null){
                throw new NullPointerException("Descripción nula");
            }
            if (post.getFecha() == null){
                throw new NullPointerException("Fecha nulla");
            }
        }

        //System.out.println("Esta es la clase decorada");

        return posts;
    }
}
