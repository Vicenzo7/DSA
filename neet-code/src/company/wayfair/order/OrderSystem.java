package company.wayfair.order;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class OrderSystem implements IOrderSystem {

    private Map<IOrder, Integer> cart;
    private Map<String, Integer> categoryDiscount;
    private Map<String, Integer> cartItems;


    public OrderSystem() {
        categoryDiscount = new HashMap<>();
        categoryDiscount.put("Cheap", 10);
        categoryDiscount.put("Moderate", 20);
        categoryDiscount.put("Expensive", 30);
        cart = new HashMap<>();
        cartItems = new TreeMap<>();
    }

    @Override
    public void addToCart(IOrder order) {
        if (order == null) {
            System.out.println("Invalid Order");
            return;
        }

        cart.put(order, cart.getOrDefault(order, 0) + 1);
        cartItems.put(order.getName(), cartItems.getOrDefault(order.getName(), 0) + 1);
    }

    @Override
    public void removeFromCart(IOrder order) {

        if (order == null) {
            System.out.println("Invalid Order");
            return;
        }

        if (!cart.containsKey(order)) {
            System.out.println("Given order item does not exist in the cart");
            return;
        }

        Integer quantity = cart.get(order);
        if (quantity == 1) {
            cart.remove(order);
            cartItems.remove(order.getName());
        } else {
            cart.put(order, quantity - 1);
            cartItems.put(order.getName(), quantity - 1);
        }
    }

    @Override
    public int calculateTotalAmount() {
        int total = 0;
        for (Map.Entry<IOrder, Integer> entry : cart.entrySet()) {
            IOrder order = entry.getKey();
            int price = order.getPrice();
            Integer quantity = entry.getValue();
            int discountedPrice = 0;
            if (price <= 10) {
                discountedPrice = (int) (price * (1 - (categoryDiscount.get("Cheap") / 100.0)));
            } else if (price <= 20) {
                discountedPrice = (int) (price * (1 - (categoryDiscount.get("Moderate") / 100.0)));
            } else {
                discountedPrice = (int) (price * (1 - (categoryDiscount.get("Expensive") / 100.0)));
            }
            total += quantity * (price - discountedPrice);
        }
        return total;
    }

    @Override
    public Map<String, Integer> categoryDiscounts() {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<IOrder, Integer> entry : cart.entrySet()) {
            IOrder order = entry.getKey();
            int price = order.getPrice();
            Integer quantity = entry.getValue();
            int discountedPrice = 0;
            if (price <= 10) {
                discountedPrice = (int) (price * (1 - (categoryDiscount.get("Cheap") / 100.0)));
                int totalDiscountedPrice = quantity * (price - discountedPrice);
                result.put("Cheap", result.getOrDefault("Cheap", 0) + totalDiscountedPrice);
            } else if (price <= 20) {
                discountedPrice = (int) (price * (1 - (categoryDiscount.get("Moderate") / 100.0)));
                int totalDiscountedPrice = quantity * (price - discountedPrice);
                result.put("Moderate", result.getOrDefault("Moderate", 0) + totalDiscountedPrice);
            } else {
                discountedPrice = (int) (price * (1 - (categoryDiscount.get("Expensive") / 100.0)));
                int totalDiscountedPrice = quantity * (price - discountedPrice);
                result.put("Expensive", result.getOrDefault("Expensive", 0) + totalDiscountedPrice);
            }
        }
        return result;
    }

    @Override
    public Map<String, Integer> cartItems() {
        return cartItems;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter textWriter = new PrintWriter(System.out);
        IOrderSystem orderSystem = new OrderSystem();
        int oCount = Integer.parseInt(br.readLine().trim());
        for (int i = 1; i <= oCount; i++) {
            String[] a = br.readLine().trim().split(" ");
            IOrder e = new Order();
            e.setName(a[0]);
            e.setPrice(Integer.parseInt(a[1]));
            orderSystem.addToCart(e);
        }
        int totalAmount = orderSystem.calculateTotalAmount();
        textWriter.println("Total Amount: " + totalAmount);
        Map<String, Integer> categoryDiscounts = orderSystem.categoryDiscounts();
        for (Map.Entry<String, Integer> entry : categoryDiscounts.entrySet()) {
            if (entry.getValue() > 0) {
                textWriter.println(entry.getKey() + " Category Discount: " + entry.getValue());
            }
        }
        Map<String, Integer> cartItems = orderSystem.cartItems();
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            textWriter.println(entry.getKey() + " (" + entry.getValue() + " items)");
        }
        textWriter.flush();
        textWriter.close();
    }
}
