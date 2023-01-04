package ssm.pojo;

public class Stock {
     private Integer stockId;

     private String goodsName;

     private String stockTime;

     private Integer stockCount;

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", goodsName='" + goodsName + '\'' +
                ", stockTime='" + stockTime + '\'' +
                ", stockCount=" + stockCount +
                '}';
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getStockTime() {
        return stockTime;
    }

    public void setStockTime(String stockTime) {
        this.stockTime = stockTime;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Stock(Integer stockId, String goodsName, String stockTime, Integer stockCount) {
        this.stockId = stockId;
        this.goodsName = goodsName;
        this.stockTime = stockTime;
        this.stockCount = stockCount;
    }

    public Stock() {
    }
}
