package amin.tabite.U5_W2_D1.services;


import amin.tabite.U5_W2_D1.entities.BlogPost;
import amin.tabite.U5_W2_D1.payloads.NewBlogPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j




public class BlogsService {


    public List<BlogPost> blogslist = new ArrayList<>();


    public List<BlogPost> findAll() {return this.blogslist;} // vedi tutti user


   public BlogPost savesudb(NewBlogPayload payload){
        BlogPost newBlog = new BlogPost( payload.getCategoria() , payload.getTitolo(), payload.getContenuto(), payload.getTempolettura());
       this.blogslist.add(newBlog);
       log.info("Blog" + newBlog.getTitolo() + "salvato correttamento");
                return newBlog;
   }


   public BlogPost findById(long blogid){

        BlogPost found = null;
        for (BlogPost blogPost: this.blogslist){

            if (blogPost.getBlogid() == blogid)
                blogPost= found;
        }

        if (found == null) throw new Error(" blog non trovato");


        return found;


   }




}
