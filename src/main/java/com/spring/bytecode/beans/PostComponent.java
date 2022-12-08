package com.spring.bytecode.beans;

import com.spring.bytecode.model.Post;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("com.spring.bytecode.beans.PostComponent")
@Scope("singleton")
public class PostComponent {

    public List<Post> getPost(){
        ArrayList<Post> post = new ArrayList<>();

        post.add(new Post(1,
                "Es una película épica del género péplum y acción del año 2000 dirigida por Ridley Scott y " +
                        "protagonizada por Russell Crowe, Joaquin Phoenix y Connie Nielsen.",
                "http://localhost:9898/img/post.jpg", new Date(),"Gladiator 1"));
        post.add(new Post(2,
                "Es una película épica del género péplum y acción del año 2000 dirigida por Ridley Scott y " +
                        "protagonizada por Russell Crowe, Joaquin Phoenix y Connie Nielsen.",
                "http://localhost:9898/img/post.jpg", new Date(),"Gladiator 2"));
        post.add(new Post(3,
                "Es una película épica del género péplum y acción del año 2000 dirigida por Ridley Scott y " +
                        "protagonizada por Russell Crowe, Joaquin Phoenix y Connie Nielsen.",
                "http://localhost:9898/img/post.jpg", new Date(),"Gladiator 3"));
        post.add(new Post(4,
                "Es una película épica del género péplum y acción del año 2000 dirigida por Ridley Scott y " +
                        "protagonizada por Russell Crowe, Joaquin Phoenix y Connie Nielsen.",
                "http://localhost:9898/img/post.jpg", new Date(),"Gladiator 4"));
        return post;
    }
}
