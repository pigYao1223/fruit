package shop;

import enums.Fruit;

/**
 * @author zhuxiyao
 * @Description: 购物车项类
 * @date 2024/11/1 11:12
 */
public class CartItem {

    /**
     * 水果
     */
    private Fruit fruit;

    /**
     * 购买斤数
     */
    private int weight;

    public CartItem(Fruit fruit, int weight) {
        this.fruit = fruit;
        this.weight = weight;
    }

    // 获取总价 (分)
    public long getPrice() {
        return fruit.getPrice(weight);
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getWeight() {
        return weight;
    }
}
