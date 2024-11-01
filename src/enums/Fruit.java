package enums;

/**
 * @author zhuxiyao
 * @Description: 水果枚举
 * @date 2024/11/1 11:02
 */
public enum Fruit {

    APPLE("苹果", 800),      // 8.00 元 = 800 分
    STRAWBERRY("草莓", 1300),
    MANGO("芒果", 2000);      

    /**
     * 水果名称
     */
    private String name;

    /**
     * 单价(分/斤)
     */
    private long pricePerWeight;

    Fruit(String name, long pricePerWeight) {
        this.name = name;
        this.pricePerWeight = pricePerWeight;
    }

    /**
     * 返回总价 (分)
     * @param weight 重量
     * @return
     */
    public long getPrice(int weight) {
        return pricePerWeight * weight;
    }

    public String getName() {
        return name;
    }
}
