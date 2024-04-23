package org.wangjin.vvserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.wangjin.vvserver.model.Menu;
import org.wangjin.vvserver.model.Role;
import org.wangjin.vvserver.service.MenuService;
import org.springframework.security.access.SecurityConfig;

import java.util.Collection;
import java.util.List;

// 根据用户传来的请求地址来分析出请求所需的角色
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource { // 获取指定请求所需的访问控制元数据,返回一个ConfigAttribute对象的集合

    @Autowired
    MenuService menuService;

//    ? 匹配1个字符
//    * 匹配0个或多个字符
//    ** 匹配路径中的0个或多个目录
//    {spring:[a-z]+} 将正则表达式[a-z]+匹配到的值,赋值给名为 spring 的路径变量.(PS:必须是完全匹配才行,在SpringMVC中只有完全匹配才会进入controller层的方法)
    AntPathMatcher antPathMatcher = new AntPathMatcher(); // 路径匹配规则
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<Menu> menus = menuService.getAllMenusWithRole();
        for (Menu menu : menus) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl)) {
                List<Role> roles = menu.getRoles();
                String[] str = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    str[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(str);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
