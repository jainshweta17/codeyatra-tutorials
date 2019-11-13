package com.codeyatra.hexagonal.port;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.codeyatra.hexagonal.domain.Employee;

public interface EmployeeUIPort {
    @PostMapping("create")
    public void create(@RequestBody Employee request);

    @GetMapping("view/{id}")
    public Employee view(@PathVariable Integer userId);
}