package strategy.impl;

import enums.Fruit;
import shop.CartItem;
import strategy.DiscountStrategy;

import java.util.List;

/**
 * @author zhuxiyao
 * @Description: 草莓折扣策略
 * @date 2024/11/1 11:06
 */
public class StrawberryDiscountStrategy implements DiscountStrategy {

    // 折扣率
    private static final double DISCOUNT_RATE = 0.8;

    @Override
    public long applyDiscount(long totalPrice, List<CartItem> items) {
        for (CartItem item : items) {
            if (item.getFruit() == Fruit.STRAWBERRY) {
                long strawberryPrice = item.getPrice();
                totalPrice -= strawberryPrice; // 减去原价
                totalPrice += Math.round(strawberryPrice * DISCOUNT_RATE); // 加上打折后的价格
            }
        }
        return totalPrice;
    }
}
