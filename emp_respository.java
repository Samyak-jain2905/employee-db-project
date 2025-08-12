package com.os.em_project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface emp_respository extends JpaRepository<emp_entity,Long>{
    
}
