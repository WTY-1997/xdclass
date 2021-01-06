package net.xdclass.online.xdclass;

import io.jsonwebtoken.Claims;
import net.xdclass.online.xdclass.model.entity.User;
import net.xdclass.online.xdclass.utils.JWTUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Test
    public void testToken(){
        User user =new User();
        user.setId(66);
        user.setName("张三");
        user.setHeadImg("png");

        String s = JWTUtils.geneJsonWebToken(user);
        System.out.println(s);

        Claims claims = JWTUtils.checkJWT(s);
        System.out.println(claims.get("name"));

    }
}
