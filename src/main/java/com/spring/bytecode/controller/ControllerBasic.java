package com.spring.bytecode.controller;

import com.spring.bytecode.beans.PostComponent;
import com.spring.bytecode.configuration.Paginas;
import com.spring.bytecode.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home")
public class ControllerBasic {

    @Autowired
    private PostComponent _postComponent;

    @GetMapping(path = {"/"})
    public String saludar(Model model){
        model.addAttribute("posts", this._postComponent.getPost());
        return "index";
    }
/**  Alternativo cumple la misma función
    @GetMapping(path = "/public")
    public ModelAndView post(){
    ModelAndView modelAndView = new ModelAndView(Paginas.HOME);
    modelAndView.addObject("posts", this.getPost());
    return modelAndView;
    }
    **/

    @GetMapping(path = {"/post","/p/{post}"})
    public ModelAndView getPostIndividual(
            @RequestParam(defaultValue = "1", name="id", required=false) int id

            //forma alternativa
            //@PathVariable(required = true, name = "post") int id
    ){
       ModelAndView modelAndView = new ModelAndView(Paginas.POST);
       List<Post> postFiltrado = this._postComponent.getPost().stream()
               .filter((p)->{
                   return p.getId() == id;
               }).collect(Collectors.toList());
       modelAndView.addObject("post", postFiltrado.get(0));
       return modelAndView;
    }

    @GetMapping("/postNew")
    public ModelAndView getForm(){
        return new ModelAndView("form").addObject("post", new Post());
    }

    @PostMapping("/addNewPost")
    public String addNewPost(Post post, Model model){
        List<Post> posts = this._postComponent.getPost();
        posts.add(post);
        model.addAttribute("posts", posts);
        return "index";
    }
}
