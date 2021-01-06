package net.xdclass.online.xdclass.service;

import net.xdclass.online.xdclass.model.entity.User;

import java.util.Map;


public interface UserService {
    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    int save(Map<String,String> userInfo);

    /**
     *
     * @param phone
     * @return
     */
    User findUserByPhone( String phone);

    /**
     *
     * @param phone
     * @param pwd
     * @return
     */
    String findByPhoneAndPwd(String phone, String pwd);
}
