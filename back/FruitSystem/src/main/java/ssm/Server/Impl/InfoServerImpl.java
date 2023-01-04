package ssm.Server.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.Mapper.InfoMapper;
import ssm.Server.InfoServer;
import ssm.pojo.*;

import java.util.List;
import java.util.Map;

@Service
public class InfoServerImpl implements InfoServer {

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public LoginInfo getUserMsg(String username) {
        return infoMapper.getUserMsg(username);
    }


    @Override
    public List<Address> getAddress(String username) {
        return infoMapper.getAddress(username);
    }

    @Override
    public List<Order> getOrder(String username, String terms,String keys) {
        return infoMapper.getOrder(username,terms,keys);
    }

    @Override
    public List<Order> getAllOrders(String terms, String keys) {
        return infoMapper.getAllOrders(terms,keys);
    }

    @Override
    public List<Login> getAllUser() {
        return infoMapper.getAllUser();
    }

    @Override
    public List<Order> getAllOrder() {
        return infoMapper.gerAllOrder();
    }

    @Override
    public List<goodsInfo> getGoodsInfo(String keys) {
        return infoMapper.getGoodsInfo(keys);
    }

    @Override
    public List<Stock> getStock(String keys) {
        return infoMapper.getStock(keys);
    }

    @Override
    public List<ShopCar> getShopCar(String username) {
        return infoMapper.getShopCar(username);
    }

    @Override
    public void changPwd(String username, String password) {
        infoMapper.changePwd(username,password);
    }

    @Override
    public void deleteUser(String username) {
        infoMapper.deleteUser(username);
    }

    @Override
    public void deleteOrder(String id) {
        infoMapper.deleteOrder(id);
    }

    @Override
    public void goodsChange(goodsInfo goodsmsg) {
        infoMapper.goodsChange(goodsmsg);
    }

    @Override
    public void goodDelete(String id) {
        infoMapper.goodDelete(id);
    }

    @Override
    public void userSubmit(LoginInfo loginInfo) {
        infoMapper.userSubmit(loginInfo);
    }

    @Override
    public void addStock(String name, String count) {
        infoMapper.addStock(name,count);
    }

    @Override
    public void addFruitCount(String name, String count) {
        infoMapper.addFruitCount(name,count);
    }

    @Override
    public goodsInfo fruitIsExist(String name) {
        return infoMapper.fruitIsExist(name);

    }

    @Override
    public void createFruit(String name, String count) {
        infoMapper.createFruit(name,count);
    }

    @Override
    public void addAddress(String username, String address) {
        infoMapper.addAddress(username,address);
    }

    @Override
    public void selectAddress(String id,String username) {
        infoMapper.selectAddress(id,username);
    }

    @Override
    public void deleteAddress(String id) {
        infoMapper.deleteAddress(id);
    }

    @Override
    public void deleteShopOne(String name, String username) {
        infoMapper.deleteShopOne(name,username);
    }

    @Override
    public void addOrders(Order order) {
        infoMapper.addOrders(order);
    }

    @Override
    public ShopCar searchShop(String name, String username) {
        return infoMapper.searchShop(name,username);
    }

    @Override
    public void insertShop(String name, String username) {
        infoMapper.insertShop(name,username);
    }

    @Override
    public void addShop(String name, String username) {
        infoMapper.addShop(name,username);
    }
}
