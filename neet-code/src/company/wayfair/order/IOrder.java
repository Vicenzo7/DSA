package company.wayfair.order;

interface IOrder {
    void setName(String name);

    String getName();

    void setPrice(int price);

    int getPrice();
}