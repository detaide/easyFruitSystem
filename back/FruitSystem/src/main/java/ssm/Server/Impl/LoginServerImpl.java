package ssm.Server.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.Mapper.LoginMapper;
import ssm.Server.LoginServer;
import ssm.pojo.Address;
import ssm.pojo.Login;
import ssm.pojo.LoginInfo;
import ssm.pojo.Order;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServerImpl implements LoginServer {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Integer userInsert(String username, String password) {
        Integer integer = loginMapper.userInsert(username, password);
        return integer;
    }

    @Override
    public Login checkUser(String username) {
        return loginMapper.checkUser(username);
    }

    @Override
    public Login checkLogin(String username, String password) {
        return loginMapper.checkLogin(username,password);
    }



}
