package ssm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ssm.Server.InfoServer;
import ssm.pojo.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class InfoContoller {
    @Autowired
    private InfoServer infoServer;

    @GetMapping(value = "/getUserMsg/{username}")
    @CrossOrigin
    @ResponseBody
    public LoginInfo getUserMsg(@PathVariable("username") String username , HttpServletResponse response){
        System.out.println(username);
        LoginInfo loginInfo = infoServer.getUserMsg(username);
        return loginInfo;
    }

    @GetMapping(value = "/getAddress/{username}")
    @CrossOrigin
    @ResponseBody
    public List<Address> getAddress(@PathVariable("username") String username , HttpServletResponse response){
        List<Address> address_list = infoServer.getAddress(username);
        return address_list;
    }

//    @GetMapping(value = "/getOrder/{username}")
//    @CrossOrigin
//    @ResponseBody
//    public List<Order> getOrder(@PathVariable("username") String username , HttpServletResponse response){
//        List<Order> order_list = infoServer.getOrder(username);
//        return order_list;
//    }


    /*
    *  terms:选择模式，已支付未支付，搜索模式
    *  keys：搜索关键字
    * */
    @GetMapping(value = "/getOrder/{username}/{terms}/{keys}")
    @CrossOrigin
    @ResponseBody
    public List<Order> getOrder(@PathVariable("username") String username , @PathVariable("terms") String terms, @PathVariable("keys") String keys ,HttpServletResponse response){
        List<Order> order_list = infoServer.getOrder(username,terms,keys);
        System.out.println(username + "," + terms + "," + keys);
        return order_list;
    }

    @GetMapping(value = "/getAllOrders/{terms}/{keys}")
    @CrossOrigin
    @ResponseBody
    public List<Order> getAllOrders( @PathVariable("terms") String terms, @PathVariable("keys") String keys ,HttpServletResponse response){
        List<Order> order_list = infoServer.getAllOrders(terms,keys);
//        System.out.println(username + "," + terms + "," + keys);
        return order_list;
    }


    @GetMapping(value = "/getAllUser")
    @CrossOrigin
    @ResponseBody
    public List<Login> getAllUser( HttpServletResponse response){
        List<Login> allUser = infoServer.getAllUser();
        return allUser;

    }

    @GetMapping(value = "/getAllOrders")
    @CrossOrigin
    @ResponseBody
    public List<Order> getAllOrders( HttpServletResponse response){
        List<Order> allOrder = infoServer.getAllOrder();
        return allOrder;

    }

    @GetMapping(value = "/getGoodsInfo/{keys}")
    @CrossOrigin
    @ResponseBody
    public List<goodsInfo> getGoodsInfo(@PathVariable("keys") String keys, HttpServletResponse response){
        List<goodsInfo> goodsInfo = infoServer.getGoodsInfo(keys);
        return goodsInfo;
    }

    @GetMapping(value = "/getStock/{keys}")
    @CrossOrigin
    @ResponseBody
    public List<Stock> getStock(@PathVariable("keys") String keys, HttpServletResponse response){
        List<Stock> stock = infoServer.getStock(keys);
        return stock;
    }

    @GetMapping(value = "/getShopCar/{username}")
    @CrossOrigin
    @ResponseBody
    public List<ShopCar> getShopCar(@PathVariable("username") String username, HttpServletResponse response){
        List<ShopCar> shopCar = infoServer.getShopCar(username);
        return shopCar;
    }

    @GetMapping(value = "/changePwd/{username}/{password}")
    @CrossOrigin
    @ResponseBody
    public boolean changePwd(@PathVariable("username") String username , @PathVariable("password") String password,  HttpServletResponse response){
        infoServer.changPwd(username,password);
        return true;
    }

    @GetMapping(value = "/deleteUser/{username}")
    @CrossOrigin
    @ResponseBody
    public boolean deleteUser(@PathVariable("username") String username ,HttpServletResponse response){
        infoServer.deleteUser(username);
        return true;
    }

    @GetMapping(value = "/deleteOrder/{id}")
    @CrossOrigin
    @ResponseBody
    public boolean deleteOrder(@PathVariable("id") String id ,HttpServletResponse response){
        infoServer.deleteOrder(id);
        return true;
    }

    @PostMapping("/goodsChange")
    @CrossOrigin
    @ResponseBody
    public Boolean goodsChange(@RequestBody goodsInfo goodsmsg, HttpServletResponse response) throws IOException {
        infoServer.goodsChange(goodsmsg);
//        System.out.println(goodsmsg);
        return true;
    }

    @GetMapping(value = "/goodDelete/{id}")
    @CrossOrigin
    @ResponseBody
    public boolean goodDelete(@PathVariable("id") String id ,HttpServletResponse response){
        infoServer.goodDelete(id);
        return true;
    }

    @PostMapping("/userSubmit")
    @CrossOrigin
    @ResponseBody
    public Boolean userSubmit(@RequestBody LoginInfo loginInfo, HttpServletResponse response) throws IOException {
        infoServer.userSubmit(loginInfo);
//        System.out.println(goodsmsg);
        return true;
    }


    @GetMapping(value = "/addStock/{name}/{count}")
    @CrossOrigin
    @ResponseBody
    public boolean addStock(@PathVariable("name") String name , @PathVariable("count") String count,HttpServletResponse response){
        infoServer.addStock(name,count);
        if(infoServer.fruitIsExist(name) != null)
            infoServer.addFruitCount(name,count);
        else
            infoServer.createFruit(name,count);

        return true;
    }

    @GetMapping(value = "/addAddress/{username}/{address}")
    @CrossOrigin
    @ResponseBody
    public boolean addAddress(@PathVariable("username") String username , @PathVariable("address") String address, HttpServletResponse response){
        infoServer.addAddress(username,address);
        return true;
    }

    @GetMapping(value = "/selectAddress/{id}/{username}")
    @CrossOrigin
    @ResponseBody
    public boolean selectAddress(@PathVariable("id") String id ,@PathVariable("username") String username,HttpServletResponse response){
        infoServer.selectAddress(id,username);
        return true;
    }

    @GetMapping(value = "/deleteAddress/{id}")
    @CrossOrigin
    @ResponseBody
    public boolean deleteAddress(@PathVariable("id") String id , HttpServletResponse response){
        infoServer.deleteAddress(id);
        return true;
    }


    @GetMapping(value = "/deleteShopOne/{name}/{username}")
    @CrossOrigin
    @ResponseBody
    public boolean deleteShopOne(@PathVariable("name") String name ,@PathVariable("username") String username, HttpServletResponse response){
        infoServer.deleteShopOne(name,username);
        return true;
    }

    @PostMapping("/addOrders")
    @CrossOrigin
    @ResponseBody
    public Boolean addOrders(@RequestBody Order order, HttpServletResponse response) throws IOException {

        System.out.println(order);
        infoServer.addOrders(order);

        return true;
    }

    public static String getOrderNo () {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        LocalDateTime localDateTime = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        return df.format(localDateTime);
    }

    @GetMapping(value = "/addShop/{name}/{username}")
    @CrossOrigin
    @ResponseBody
    public boolean addShop(@PathVariable("name") String name ,@PathVariable("username") String username, HttpServletResponse response){
        infoServer.addShop(name,username);
        if(infoServer.searchShop(name,username) == null)
            infoServer.insertShop(name,username);

        return true;
    }

    @PostMapping("/fileUpload/{type}/{username}")
    @CrossOrigin
    @ResponseBody
    public Boolean fileUpload(@RequestParam("file") MultipartFile file, @PathVariable("username") String username, @PathVariable("type") String type,HttpServletResponse response) throws IOException {

        System.out.println(file);
        String headpath = type.equals("head")?"D:\\vscode\\水果店\\forward\\System\\src\\assets\\Image\\headImg":"D:\\vscode\\水果店\\forward\\System\\src\\assets\\Image\\goods_img";
        File file1 = new File(headpath,username + ".jpg");
        System.out.println(type);
        if(!file1.exists())
            file1.mkdirs();
        System.out.println(file1);
        file.transferTo(file1);

        return true;
    }









}
