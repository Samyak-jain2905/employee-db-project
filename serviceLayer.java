package com.os.em_project;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface serviceLayer {
    List<employees> read_employ();
    String create_employ(employees employee);
    String delete_employ(Long id);
    String update_employ(Long id,employees employee);
}
