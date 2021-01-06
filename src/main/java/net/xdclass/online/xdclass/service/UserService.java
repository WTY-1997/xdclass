package net.xdclass.online.xdclass.service;

import net.xdclass.online.xdclass.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

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
}
