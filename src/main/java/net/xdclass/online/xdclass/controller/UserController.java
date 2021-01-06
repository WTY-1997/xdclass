package net.xdclass.online.xdclass.controller;

import net.xdclass.online.xdclass.service.UserService;
import net.xdclass.online.xdclass.utils.JsonData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("register")
    public JsonData register(@RequestBody Map<String, String> userInfo) {
        int rows = userService.save(userInfo);
        return rows == 1 ? JsonData.bulidSucccess() : JsonData.bulidError("注册失败");
    }
}
