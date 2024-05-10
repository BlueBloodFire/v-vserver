package org.wangjin.vvserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wangjin.vvserver.mapper.EmployeeMapper;
import org.wangjin.vvserver.model.Employee;
import org.wangjin.vvserver.model.RespBean;
import org.wangjin.vvserver.model.RespPageBean;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    SimpleDateFormat yearFormatter = new SimpleDateFormat("yyyy");

    SimpleDateFormat monthFormatter = new SimpleDateFormat("MM");

    DecimalFormat decimalFormatter = new DecimalFormat("##.00");

    public RespPageBean getEmployeeByPage(Integer page, Integer size) {
        if (page != null && size != null) {
            page = (page - 1)* size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPage(page, size);
        Long total = employeeMapper.getTotal();
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addEmp(Employee employee) {
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        double month = (Double.parseDouble(yearFormatter.format(endContract)) - Double.parseDouble(yearFormatter.format(beginContract))) * 12 + (Double.parseDouble(monthFormatter.format(endContract)) - Double.parseDouble(monthFormatter.format(beginContract)));
        employee.setContractTerm(Double.parseDouble(decimalFormatter.format(month / 12)));
        return employeeMapper.insertSelective(employee);
    }

    public Integer maxWorkID() {
        return employeeMapper.maxWorkID();
    }

    public Integer deleteEmpByEid(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer updateEmp(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }
}
