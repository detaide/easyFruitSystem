package ssm.Server;


import ssm.pojo.Address;
import ssm.pojo.Login;
import ssm.pojo.LoginInfo;
import ssm.pojo.Order;

import java.util.List;
import java.util.Map;

public interface LoginServer {

    Integer userInsert(String username, String password);

    Login checkUser(String username);

    Login checkLogin(String username,String password);





}
