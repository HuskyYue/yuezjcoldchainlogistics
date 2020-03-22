package pers.yuezejian.coldchainlogistics.project.monitor.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pers.yuezejian.coldchainlogistics.framework.web.controller.BaseController;
import pers.yuezejian.coldchainlogistics.framework.web.domain.AjaxResult;
import pers.yuezejian.coldchainlogistics.framework.web.domain.Server;

/**
 * 服务器监控
 * 
 * @Author: Yuezejian
 */
@RestController
@RequestMapping("/monitor/server")
public class ServerController extends BaseController
{
    @PreAuthorize("@ss.hasPermi('monitor:server:list')")
    @GetMapping()
    public AjaxResult getInfo() throws Exception
    {
        Server server = new Server();
        server.copyTo();
        return AjaxResult.success(server);
    }
}
