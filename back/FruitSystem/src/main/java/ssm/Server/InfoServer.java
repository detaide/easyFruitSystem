package ssm.Server;


import ssm.pojo.*;

import java.util.List;
import java.util.Map;

public interface InfoServer {

    LoginInfo getUserMsg(String username);

    List<Address> getAddress(String username);

    List<Order> getOrder(String username,String terms,String keys);

    List<Order> getAllOrders(String terms,String keys);

    List<Login> getAllUser();

    List<Order> getAllOrder();

    List<goodsInfo> getGoodsInfo(String keys);

    List<Stock> getStock(String keys);

    List<ShopCar> getShopCar(String username);

    void changPwd(String username, String password);

    void  deleteUser(String username);

    void deleteOrder(String id);

    void goodsChange(goodsInfo goodsmsg);

    void goodDelete(String id);

    void userSubmit(LoginInfo loginInfo);

    void addStock(String name, String count);

    void addFruitCount(String name, String count);

    goodsInfo fruitIsExist(String name);

    void createFruit(String name, String count);

    void addAddress(String username, String address);

    void selectAddress(String id,String username);

    void deleteAddress(String id);

    void deleteShopOne(String name,String username);

    void addOrders(Order order);

    ShopCar searchShop(String name, String username);

    void insertShop(String name, String username);

    void addShop(String name, String username);

}
