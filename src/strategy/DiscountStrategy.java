package strategy;

import shop.CartItem;

import java.util.List;

/**
 * @author zhuxiyao
 * @Description: 折扣策略类
 * @date 2024/11/1 11:05
 */
public interface DiscountStrategy {

    long applyDiscount(long totalPrice, List<CartItem> items);
}
