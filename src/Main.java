import enums.Fruit;
import shop.CartItem;
import shop.ShoppingCart;
import strategy.DiscountStrategy;
import strategy.impl.CompositeDiscountStrategy;
import strategy.impl.StrawberryDiscountStrategy;
import strategy.impl.ThresholdDiscountStrategy;

public class Main {
    public static void main(String[] args) {

        // 10 斤苹果
        CartItem apple = new CartItem(Fruit.APPLE, 10);

        CartItem strawberry = new CartItem(Fruit.STRAWBERRY, 10);

        CartItem mango = new CartItem(Fruit.MANGO, 10);

        //1、有一家超市，出售苹果和草莓。其中苹果 8 元/斤，草莓 13 元/斤。
        //现在顾客 A 在超市购买了若干斤苹果和草莓，需要计算一共多少钱？
        //请编写函数，对于 A 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。

        ShoppingCart cart = new ShoppingCart();
        // 添加购物车项
        cart.addItem(apple);      // 5 斤苹果
        cart.addItem(strawberry); // 5 斤草莓
        // 计算总价
        double total = cart.calculateTotalPrice();
        System.out.printf("总价为: %.2f 元%n", total);
        System.out.println("=========================");


        //2、超市增加了一种水果芒果，其定价为 20 元/斤。
        //现在顾客 B 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
        //请编写函数，对于 B 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
        cart.addItem(mango);
        total = cart.calculateTotalPrice();
        System.out.printf("总价为: %.2f 元%n", total);
        System.out.println("=========================");

        //3、超市做促销活动，草莓限时打 8 折。
        //现在顾客 C 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
        //请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。

        // 创建组合折扣策略
        CompositeDiscountStrategy compositeDiscountStrategy = new CompositeDiscountStrategy();
        //使用草莓打折
        compositeDiscountStrategy.addStrategy(new StrawberryDiscountStrategy());
        cart.setDiscountStrategy(compositeDiscountStrategy);
        total = cart.calculateTotalPrice();
        System.out.printf("总价为: %.2f 元%n", total);
        System.out.println("=========================");

        //4、促销活动效果明显，超市继续加大促销力度，购物满 100 减 10 块。
        //现在顾客 D 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
        //请编写函数，对于 D 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。

        // 使用草莓打折和满减策略
        compositeDiscountStrategy.addStrategy(new ThresholdDiscountStrategy());
        cart.setDiscountStrategy(compositeDiscountStrategy);
        total = cart.calculateTotalPrice();
        System.out.printf("总价为: %.2f 元%n", total);


    }
}