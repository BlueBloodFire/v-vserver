package org.wangjin.vvserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wangjin.vvserver.model.Menu;
import org.wangjin.vvserver.model.RespBean;
import org.wangjin.vvserver.model.Role;
import org.wangjin.vvserver.service.MenuService;
import org.wangjin.vvserver.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/mids/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid) {
        return menuService.getMidsByRid(rid);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        if (menuService.updateMenuRole(rid, mids)) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @PostMapping("/role")
    public RespBean addRole(@RequestBody  Role role) {
        if (roleService.addRole(role) == 1) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @DeleteMapping("/role/{rid}")
    public RespBean deleteRoleById(@PathVariable Integer rid) {
        if (roleService.deleteRoleById(rid) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
