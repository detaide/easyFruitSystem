package ssm.Mapper;

import org.apache.ibatis.annotations.Param;
import ssm.pojo.Address;
import ssm.pojo.Login;
import ssm.pojo.LoginInfo;
import ssm.pojo.Order;

import java.util.List;
import java.util.Map;

public interface LoginMapper {
   Integer userInsert(@Param("username") String username , @Param("password") String password);

   Login checkUser(@Param("username") String username);

   Login checkLogin(@Param("username") String username , @Param("password") String password);


}
