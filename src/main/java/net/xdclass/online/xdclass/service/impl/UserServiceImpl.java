package net.xdclass.online.xdclass.service.impl;

import net.xdclass.online.xdclass.domain.User;
import net.xdclass.online.xdclass.mapper.UserMapper;
import net.xdclass.online.xdclass.service.UserService;
import net.xdclass.online.xdclass.utils.CommentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public int save(Map<String, String> userInfo) {
        User user = parseToUser(userInfo);
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
            user.setHeadImg(getRandomImg());
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


    @Override
    public User findUserByPhone(String phone) {
        return null;
    }
}
