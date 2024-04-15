package org.wangjin.vvserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wangjin.vvserver.mapper.DepartmentMapper;
import org.wangjin.vvserver.model.Department;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> getAllDepartmentsWithOutChildren() {
        return departmentMapper.getAllDepartmentsWithOutChildren();
    }

    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }

    public void addDep(Department department) {
        department.setEnabled(true);
        departmentMapper.addDep(department);
    }

    public void deleteDepById(Department department) {
        departmentMapper.deleteDepById(department);
    }
}
