package net.xdclass.online.xdclass.controller;

import net.xdclass.online.xdclass.utils.JsonData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {
    @PostMapping("register")
    public JsonData register(@RequestBody Map<String, String> userInfo) {
        return JsonData.bulidSucccess();
    }
}
