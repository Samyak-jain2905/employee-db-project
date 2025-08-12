package com.os.em_project;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
   serviceLayer sevicefunc;
    //serviceLayer sevicefunc=new serviceimpement();

    @GetMapping("/api")
    public List<employees> empdetails(){
          return sevicefunc.read_employ();
    }
 
    @PostMapping("/api")
    public String createemploy(@RequestBody employees emp){
       return sevicefunc.create_employ(emp);
      }
    
    @DeleteMapping("/api/{id}")
    public String deleteemp(@PathVariable Long id){
        return sevicefunc.delete_employ(id);
    }

@PutMapping("/a/{id}")
public String updateemp(@PathVariable Long id,@RequestBody employees employee){
        return sevicefunc.update_employ(id,employee);
    }
    
}
