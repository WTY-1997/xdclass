package net.xdclass.online.xdclass.service.impl;

import net.xdclass.online.xdclass.model.entity.User;
import net.xdclass.online.xdclass.mapper.UserMapper;
import net.xdclass.online.xdclass.service.UserService;
import net.xdclass.online.xdclass.utils.CommentUtils;
import net.xdclass.online.xdclass.utils.JWTUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 注册
     * @param userInfo
     * @return
     */
    @Override
    public int save(Map<String, String> userInfo) {
        User user = parseToUser(userInfo);//解析Map userInfo中的user对象
        if (user != null) {
            return userMapper.save(user);
        } else {
            return -1;
        }

    }

    /**
     * 解析user对象 并密码加密
     * @param userInfo
     * @return
     */
    private User parseToUser(Map<String, String> userInfo) {
        if (userInfo.containsKey("phone") && userInfo.containsKey("pwd") && userInfo.containsKey("name")) {
            User user = new User();
            user.setCreateTime(new Date());
            user.setHeadImg(getRandomImg());//随机头像
            user.setName(userInfo.get("name"));
            user.setPhone(userInfo.get("phone"));
            String pwd = userInfo.get("pwd");
            //密码需要MD5加密 不能明文存入数据库
            user.setPwd(CommentUtils.MD5(pwd));
            return user;
        } else {
            return null;
        }
    }

    /**
     * 放在CDN上的随机头像
     */
    private static final String [] headImg = {
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    private String getRandomImg(){
        int size =  headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }


    /**
     * 通过电话号码查询用户
     * @param phone
     * @return
     */
    @Override
    public User findUserByPhone(String phone) {
        return null;
    }

    /**
     * 通过电话号码和密码查询是否一致
     * @param phone
     * @param pwd
     * @return
     */
    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {
      User user =  userMapper.findByPhoneAndPwd(phone,CommentUtils.MD5(pwd));
      if(user==null){
          return null;
      }else{
          String token = JWTUtils.geneJsonWebToken(user);
          return token;
      }
    }
}
