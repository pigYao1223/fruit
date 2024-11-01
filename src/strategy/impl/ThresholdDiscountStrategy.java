package strategy.impl;

import shop.CartItem;
import strategy.DiscountStrategy;

import java.util.List;

/**
 * @author zhuxiyao
 * @Description: 满减折扣策略
 * @date 2024/11/1 11:07
 */
public class ThresholdDiscountStrategy implements DiscountStrategy {

    /**
     * 阈值 （100.00 元 = 10000 分）
     */
    private static final long THRESHOLD = 10000;

    /**
     * 优惠金额 （10.00 元 = 1000 分）
     */
    private static final long DISCOUNT_AMOUNT = 1000;

    @Override
    public long applyDiscount(long totalPrice, List<CartItem> items) {
        if (totalPrice >= THRESHOLD) {
            totalPrice -= DISCOUNT_AMOUNT; // 满100减10
        }
        return totalPrice;
    }
}
