package ssm.pojo;

public class ShopList {
    public String goodsName;

    public String count;

    @Override
    public String toString() {
        return "ShopList{" +
                "goodsName='" + goodsName + '\'' +
                ", count='" + count + '\'' +
                '}';
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public ShopList(String goodsName, String count) {
        this.goodsName = goodsName;
        this.count = count;
    }

    public ShopList() {
    }
}
