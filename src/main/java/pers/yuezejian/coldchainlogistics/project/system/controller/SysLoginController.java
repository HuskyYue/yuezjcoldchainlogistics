package pers.yuezejian.coldchainlogistics.project.system.controller;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import pers.yuezejian.coldchainlogistics.common.constant.Constants;
import pers.yuezejian.coldchainlogistics.common.utils.ServletUtils;
import pers.yuezejian.coldchainlogistics.framework.security.LoginUser;
import pers.yuezejian.coldchainlogistics.framework.security.service.SysLoginService;
import pers.yuezejian.coldchainlogistics.framework.security.service.SysPermissionService;
import pers.yuezejian.coldchainlogistics.framework.security.service.TokenService;
import pers.yuezejian.coldchainlogistics.framework.web.domain.AjaxResult;
import pers.yuezejian.coldchainlogistics.project.system.domain.SysMenu;
import pers.yuezejian.coldchainlogistics.project.system.domain.SysUser;
import pers.yuezejian.coldchainlogistics.project.system.service.ISysMenuService;

/**
 * 登录验证
 * 
 * @Author: Yuezejian
 */
@RestController
public class SysLoginController
{
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private TokenService tokenService;

    /**
     * 登录方法
     * 
     * @param username 用户名
     * @param password 密码
     * @param captcha 验证码
     * @param uuid 唯一标识
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(String username, String password, String code, String uuid)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(username, password, code, uuid);
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     * 
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo()
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     * 
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters()
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        // 用户信息
        SysUser user = loginUser.getUser();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(user.getUserId());
        return AjaxResult.success(menuService.buildMenus(menus));
    }
}
