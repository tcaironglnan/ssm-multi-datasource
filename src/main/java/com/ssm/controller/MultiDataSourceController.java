package com.ssm.controller;
import com.ssm.service.MultiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

/**
 * 测试多数据源的使用类
 * @author FaceFeel
 * @Created 2018-01-29 13:48
 */
@Controller
@RequestMapping("/multi")
public class MultiDataSourceController {

    @Autowired
    private MultiService multiService;

    /**
     * 同时查看mysql数据库和oracle数据库的数据
     * @param request http请求
     * @return jsp页面名称
     */
    @RequestMapping("/showMulti")
    public String showMulti(HttpServletRequest request){
        //查看oracle数据库的数据
        request.setAttribute("listOracle",multiService.showOracle());
        //查看mysql数据库的数据
        request.setAttribute("listMysql",multiService.showMysql());
        return "showList";
    }
}
