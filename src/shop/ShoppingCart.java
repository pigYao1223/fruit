package shop;

import strategy.DiscountStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuxiyao
 * @Description: 购物车
 * @date 2024/11/1 11:08
 */
public class ShoppingCart {

    // 使用 List 存储购物车项
    private List<CartItem> items;

    // 折扣策略
    private DiscountStrategy discountStrategy;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.discountStrategy = null; // 默认不使用折扣
    }

    // 添加购物车项
    public void addItem(CartItem item) {
        items.add(item);
    }

    // 设置折扣策略
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    // 计算最终总价
    public double calculateTotalPrice() {
        long totalPrice = 0;

        // 计算总价
        for (CartItem item : items) {
            totalPrice += item.getPrice();
        }

        // 应用折扣策略（如果有）
        if (discountStrategy != null) {
            totalPrice = discountStrategy.applyDiscount(totalPrice, items);
        }

        // 将总价从分转换为元
        return totalPrice / 100.0;
    }

}
