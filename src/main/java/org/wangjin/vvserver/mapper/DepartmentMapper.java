package org.wangjin.vvserver.mapper;

import org.wangjin.vvserver.model.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAllDepartmentsByParentId(Integer pid);

    void addDep(Department department);

    void deleteDepById(Department dep);

    List<Department> getAllDepartmentsWithOutChildren();
}
