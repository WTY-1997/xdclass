package net.xdclass.online.xdclass.controller;

import net.xdclass.online.xdclass.model.request.LoginRequest;
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

    /**
     * 注册接口
     *
     * @param userInfo
     * @return
     */
    @PostMapping("register")
    public JsonData register(@RequestBody Map<String, String> userInfo) {
        int rows = userService.save(userInfo);
        return rows == 1 ? JsonData.bulidSucccess() : JsonData.bulidError("注册失败");
    }

    /**
     * 登录接口
     *
     * @param loginRequest
     * @return
     */
    @PostMapping("login")
    public JsonData Login(@RequestBody LoginRequest loginRequest) {
        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(), loginRequest.getPwd());
        System.out.println(token);
        return token == null ? JsonData.bulidError("登陆失败，账号或密码错误") : JsonData.bulidSucccess(token);
    }
}
