package org.wangjin.vvserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wangjin.vvserver.mapper.SalaryMapper;
import org.wangjin.vvserver.model.Salary;

import java.util.Date;
import java.util.List;

@Service
public class SalaryService {

    @Autowired
    SalaryMapper salaryMapper;

    public List<Salary> getAllSalaries() {
        return getAllSalaries();
    }

    public Integer addSalary(Salary salary) {
        salary.setCreatedate(new Date());
        return salaryMapper.insertSelective(salary);
    }

    public Integer updateSalary(Salary salary) {
        return salaryMapper.updateByPrimaryKeySelective(salary);
    }

    public Integer deleteSalary(Integer id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }
}
