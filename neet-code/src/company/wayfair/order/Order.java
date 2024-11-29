package company.wayfair.order;

import java.util.Objects;

public class Order implements IOrder {
    private String name;
    private int price;

    @Override
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("name cannot be empty");
            return;
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setPrice(int price) {
        if (price < 0) {
            System.out.println("price cannot be negative");
            return;
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return price == order.price && Objects.equals(name, order.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
