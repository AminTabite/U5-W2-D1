package amin.tabite.U5_W2_D1.controllers;

import amin.tabite.U5_W2_D1.entities.BlogPost;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/blogpost")
public class BlogpostController {

    @GetMapping
    public List<BlogPost> getBlogs(){

        return ;

    }








}
