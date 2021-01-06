package net.xdclass.online.xdclass.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.xdclass.online.xdclass.model.entity.User;

import java.util.Date;

/**
 * JWT工具类
 */
public class JWTUtils {
    /**
     * 过期时间
     */
    private static final long EXPIRE = 6000 * 60 * 24 * 7;

    /**
     * 加密密钥
     */
    private static final String SECRET = "xdclass.net168";

    /**
     * 令牌前缀
     */
    private static final String TOKEN_PREFIX = "xdclass";

    /**
     * subject主题
     */
    private static final String SUBJECT = "xdclass";

    /**
     * 根据用户信息生成令牌
     *
     * @param user 用户对象
     * @return
     */
    public static String geneJsonWebToken(User user) {
        String token = Jwts.builder()
                .setSubject(SUBJECT)
                .claim("head_img", user.getHeadImg())
                .claim("id", user.getId())
                .claim("name", user.getName())
                .setIssuedAt(new Date()) //下发时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE)) //过期时间 获取当前毫秒值+过期毫秒值
                .signWith(SignatureAlgorithm.HS256, SECRET)//签名 密码格式和密钥
                .compact();//返回字符串
        token = token + TOKEN_PREFIX;
        return token;
    }

    /**
     * 解析token令牌
     * @param token
     * @return
     */
    public static Claims checkJWT(String token){
        try {
            final Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            return claims;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
