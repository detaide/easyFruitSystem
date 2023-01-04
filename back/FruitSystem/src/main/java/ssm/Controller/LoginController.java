package ssm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.Server.LoginServer;
import ssm.pojo.Address;
import ssm.pojo.Login;
import ssm.pojo.LoginInfo;
import ssm.pojo.Order;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private LoginServer loginServer;


    @PostMapping("/register")
    @CrossOrigin
    @ResponseBody
    public Boolean userRegister(@RequestBody Login msg, HttpServletResponse response) throws IOException {
        Login login = loginServer.checkUser(msg.getUsername());
        if(login != null){
            return false;
        }
        Integer integer = loginServer.userInsert(msg.getUsername(), msg.getPassword());
//        System.out.println(integer);
        return  true;
    }

    @PostMapping("/login")
    @CrossOrigin
    @ResponseBody
    public Boolean userLogin(@RequestBody Login msg, HttpServletResponse response) throws IOException {
        Login login = loginServer.checkLogin(msg.getUsername(),msg.getPassword());
        return login==null?false:true;
    }












}
