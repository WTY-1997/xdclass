package net.xdclass.online.xdclass.mapper;

import net.xdclass.online.xdclass.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int save(User user);
    User findUserByPhone(@Param("phone") String phone);//@Param() 对应sql查询语句条件
}
