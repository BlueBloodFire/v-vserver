package org.wangjin.vvserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wangjin.vvserver.model.Menu;
import org.wangjin.vvserver.model.RespBean;
import org.wangjin.vvserver.service.MenuService;

import java.util.List;

@RestController
@RequestMapping("/system/config")
public class SystemConfigController {

    @Autowired
    MenuService menuService;

    @GetMapping("/menu")
    public List<Menu> getMenuByHrId() {
        return menuService.getMenusByHrId();
    }
}
