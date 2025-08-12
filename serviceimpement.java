package com.os.em_project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class serviceimpement implements serviceLayer{
   // List<employees> em=new ArrayList<>();
    @Autowired
    private emp_respository emprespository;


     public List<employees> read_employ(){
        List<employees> em=new ArrayList<>();
        List<emp_entity> emplist=emprespository.findAll();
        for (emp_entity entity : emplist) {
            employees emp=new employees();
            emp.setName(entity.getName());
            emp.setGmail(entity.getGmail());
            em.add(emp);
        }
        return em;
     }
    public String create_employ(employees employee){
        emp_entity entity=new emp_entity();
        BeanUtils.copyProperties(employee,entity);
        emprespository.save(entity);
        // em.add(employee);
        return "saved sucessfullly";

    }
    public String delete_employ(Long id){
        emp_entity entity=emprespository.findById(id).get();
        emprespository.delete(entity);
       // em.removeIf(e -> e.getId()==id);
        return "delete successfully";
    }
    @Override
    public String update_employ(Long id, employees employee) {
        emp_entity existingemp=emprespository.findById(id).get();
        
        existingemp.setGmail(employee.getGmail());
        existingemp.setName(employee.getName());

        emprespository.save(existingemp);
        return "update successfull";
    }
}

