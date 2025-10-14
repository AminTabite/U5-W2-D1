package amin.tabite.U5_W2_D1.services;


import amin.tabite.U5_W2_D1.entities.Autori;
import amin.tabite.U5_W2_D1.payloads.NewAutore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j




public class BlogsService {


    public List<Autori> blogslist = new ArrayList<>();


    public List<Autori> findAll() {return this.blogslist;} // vedi tutti user


   public Autori savesudb(NewAutore payload){
        Autori newBlog = new Autori( payload.getCategoria() , payload.getTitolo(), payload.getContenuto(), payload.getTempolettura());
       this.blogslist.add(newBlog);
       log.info("Blog" + newBlog.getTitolo() + "salvato correttamento");
                return newBlog;
   }


   public Autori findById(long blogid){

        Autori found = null;
        for (Autori autori : this.blogslist){

            if (autori.getBlogid() == blogid)
                autori = found;
        }

        if (found == null) throw new Error(" blog non trovato");


        return found;


   }


   public Autori findByIdAndUpdate(long blogid, NewAutore payload){

        Autori found = null;
        for(Autori autori : blogslist) {

            if (autori.getBlogid() == blogid) {

                found= autori;
                found.setCategoria(payload.getCategoria());
                found.setTitolo(payload.getTitolo());
                found.setContenuto(payload.getContenuto());
                found.setTempolettura(payload.getTempolettura());

            }



        }

        if (found == null) throw new Error("modifica fallita");

       return found;
   }


   public void findByIdAndDelete(long blogid) {

        Autori found = null;


        for (Autori autori : this.blogslist) {

            if(autori.getBlogid() == blogid) found= autori;

        }
        if (found == null) throw new Error("cancellazione fallita");
        this.blogslist.remove(found);




   }



}
