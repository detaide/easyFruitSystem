package ssm.pojo;

public class goodsInfo {
    private Integer goodsId;

    private String goodsName;

    private String goodsClass;

    private String goodsContext;

    private Integer goodsCount;

    private String goodsMonovelent;

    private String goodsLocation;

    @Override
    public String toString() {
        return "goodsInfo{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsClass='" + goodsClass + '\'' +
                ", goodsContext='" + goodsContext + '\'' +
                ", goodsCount=" + goodsCount +
                ", goodsMonovelent='" + goodsMonovelent + '\'' +
                ", goodsLocation='" + goodsLocation + '\'' +
                '}';
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsClass() {
        return goodsClass;
    }

    public void setGoodsClass(String goodsClass) {
        this.goodsClass = goodsClass;
    }

    public String getGoodsContext() {
        return goodsContext;
    }

    public void setGoodsContext(String goodsContext) {
        this.goodsContext = goodsContext;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getGoodsMonovelent() {
        return goodsMonovelent;
    }

    public void setGoodsMonovelent(String goodsMonovelent) {
        this.goodsMonovelent = goodsMonovelent;
    }

    public String getGoodsLocation() {
        return goodsLocation;
    }

    public void setGoodsLocation(String goodsLocation) {
        this.goodsLocation = goodsLocation;
    }

    public goodsInfo(Integer goodsId, String goodsName, String goodsClass, String goodsContext, Integer goodsCount, String goodsMonovelent, String goodsLocation) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsClass = goodsClass;
        this.goodsContext = goodsContext;
        this.goodsCount = goodsCount;
        this.goodsMonovelent = goodsMonovelent;
        this.goodsLocation = goodsLocation;
    }

    public goodsInfo() {
    }
}
