package com.codeyatra.hexagonal.port;

import com.codeyatra.hexagonal.domain.Employee;

public interface EmployeeRepositoryPort {

    void create(String name, String role, long salary);

    Employee getEmployee(Integer userId);
}