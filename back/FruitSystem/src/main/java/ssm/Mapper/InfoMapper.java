package ssm.Mapper;

import org.apache.ibatis.annotations.Param;
import ssm.pojo.*;

import java.util.List;
import java.util.Map;

public interface InfoMapper {

    LoginInfo getUserMsg(@Param("username") String username);

    List<Address> getAddress(@Param("username") String username);

    List<Order> getOrder(@Param("username") String username,@Param("terms") String terms, @Param("keys") String keys );

    List<Order> getAllOrders(@Param("terms") String terms, @Param("keys") String keys );

    List<Login> getAllUser();

    List<Order> gerAllOrder();

    List<goodsInfo> getGoodsInfo(@Param("keys") String keys);

    List<Stock> getStock(@Param("keys") String keys);

    List<ShopCar> getShopCar(@Param("username") String username);

    void changePwd(@Param("username") String username, @Param("password") String password);

    void deleteUser(@Param("username") String username);

    void deleteOrder(@Param("id") String id);

    void goodsChange(@Param("goodsmsg") goodsInfo goodsmsg);

    void goodDelete(@Param("id") String id);

    void userSubmit(@Param("loginInfo") LoginInfo loginInfo);

    void addStock(@Param("name") String name,@Param("count") String count);

    void addFruitCount(@Param("name") String name,@Param("count") String count);

    goodsInfo fruitIsExist(@Param("name") String name);

    void createFruit(@Param("name") String name,@Param("count") String count);

    void addAddress(@Param("username") String username, @Param("address") String address);

    void selectAddress(@Param("id") String id, @Param("username") String username);

    void deleteAddress(@Param("id") String id);

    void deleteShopOne(@Param("name") String name,@Param("username") String username);

    void addOrders(@Param("order") Order order);

    ShopCar searchShop(@Param("name") String name, @Param("username") String username);

    void insertShop(@Param("name") String name, @Param("username") String username);

    void addShop(@Param("name") String name, @Param("username") String username);

}
