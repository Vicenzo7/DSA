package company.wayfair.order;

import java.util.Map;

interface IOrderSystem {
    void addToCart(IOrder order);

    void removeFromCart(IOrder order);

    int calculateTotalAmount();

    Map<String, Integer> categoryDiscounts();

    Map<String, Integer> cartItems();
}