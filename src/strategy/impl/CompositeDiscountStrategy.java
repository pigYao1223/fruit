package strategy.impl;

import shop.CartItem;
import strategy.DiscountStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuxiyao
 * @Description: 组合折扣策略
 * @date 2024/11/1 11:22
 */
public class CompositeDiscountStrategy implements DiscountStrategy {

    private List<DiscountStrategy> strategies;

    public CompositeDiscountStrategy() {
        this.strategies = new ArrayList<>();
    }

    public void addStrategy(DiscountStrategy strategy) {
        strategies.add(strategy);
    }

    @Override
    public long applyDiscount(long totalPrice, List<CartItem> items) {
        for (DiscountStrategy strategy : strategies) {
            totalPrice = strategy.applyDiscount(totalPrice, items);
        }
        return totalPrice;
    }
}
