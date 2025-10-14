package amin.tabite.U5_W2_D1.controllers;

import amin.tabite.U5_W2_D1.entities.Autore;
import amin.tabite.U5_W2_D1.payloads.NewAutore;
import amin.tabite.U5_W2_D1.payloads.NewAutorePayload;
import amin.tabite.U5_W2_D1.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogpost")

public class AutoreController {

    @Autowired
    private AutoreService autoreService;




    // 1 get http://localhost:8080/blogpost
    @GetMapping
    public List<Autore> getAutori(){

        return this.autoreService.findAll();

    }


    // 2 post http://localhost:8080/b   logpost
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autore createAutore(@RequestBody NewAutorePayload body) {
        return autoreService.saveautore(body);
    }


    //3 get http://localhost:8080/autore/{blogid}

    @GetMapping("/{autoreid}")
    public Autore getautoreId(@PathVariable long autoreid){
        return autoreService.findById(autoreid);

    }


    //4 put http://localhost:8080/blogpost/{blogid}

    @PutMapping("/blogid")
    public Autore getBlogByIdAndUpdate(@PathVariable long autoreid, @RequestBody NewAutorePayload body){
        return this.autoreService.findByIdAndUpdate(autoreid, body);
    }


    //5 delete  public void findByIdAndDelete(long blogid)

    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getBlogByIdAndDelete(@PathVariable long blogid) {
        this.autoreService.findByIdAndDelete(blogid);
    }

}
