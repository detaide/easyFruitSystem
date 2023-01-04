package ssm.pojo;

public class ShopCar {

    private String goodsName;

    private Integer goodsCount;

    private String goodsContext;

    private String goodsMonovelent;

    @Override
    public String toString() {
        return "ShopCar{" +
                "goodsName='" + goodsName + '\'' +
                ", goodsCount=" + goodsCount +
                ", goodsContext='" + goodsContext + '\'' +
                ", goodsMonovelent='" + goodsMonovelent + '\'' +
                '}';
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getGoodsContext() {
        return goodsContext;
    }

    public void setGoodsContext(String goodsContext) {
        this.goodsContext = goodsContext;
    }

    public String getGoodsMonovelent() {
        return goodsMonovelent;
    }

    public void setGoodsMonovelent(String goodsMonovelent) {
        this.goodsMonovelent = goodsMonovelent;
    }

    public ShopCar(String goodsName, Integer goodsCount, String goodsContext, String goodsMonovelent) {
        this.goodsName = goodsName;
        this.goodsCount = goodsCount;
        this.goodsContext = goodsContext;
        this.goodsMonovelent = goodsMonovelent;
    }

    public ShopCar() {
    }
}
