package org.wangjin.vvserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wangjin.vvserver.mapper.RoleMapper;
import org.wangjin.vvserver.model.Role;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;

    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public Integer addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        return roleMapper.insert(role);
    }

    public Integer deleteRoleById(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }
}
