package amin.tabite.U5_W2_D1.controllers;

import amin.tabite.U5_W2_D1.entities.Autori;
import amin.tabite.U5_W2_D1.payloads.NewAutore;
import amin.tabite.U5_W2_D1.services.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogpost")

public class BlogpostController {

    @Autowired
    private BlogsService blogsService;




    // 1 get http://localhost:8080/blogpost
    @GetMapping
    public List<Autori> getBlogs(){

        return this.blogsService.findAll();

    }


    // 2 post http://localhost:8080/b   logpost
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autori createBlogpost(@RequestBody NewAutore body) {
        return blogsService.savesudb(body);
    }


    //3 get http://localhost:8080/blogpost/{blogid}

    @GetMapping("/{blogid}")
    public Autori getBlogId(@PathVariable long blogid){
        return blogsService.findById(blogid);

    }


    //4 put http://localhost:8080/blogpost/{blogid}

    @PutMapping("/blogid")
    public Autori getBlogByIdAndUpdate(@PathVariable long blogid, @RequestBody NewAutore body){
        return this.blogsService.findByIdAndUpdate(blogid, body);
    }


    //5 delete  public void findByIdAndDelete(long blogid)

    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getBlogByIdAndDelete(@PathVariable long blogid) {
        this.blogsService.findByIdAndDelete(blogid);
    }

}
