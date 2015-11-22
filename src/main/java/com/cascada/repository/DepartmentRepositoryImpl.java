package com.cascada.repository;

import com.cascada.domain.Department;

/**
 * Created by jeanbernard on 11/20/15.
 */
public class DepartmentRepositoryImpl implements DepartmentRepository {


    @Override
    public Department saveDepartment() {

        Department department = new Department();
        department.setNombre("Factoria");
        department.setDescripcion("Factoria de Software");

        return department;
    }
}
