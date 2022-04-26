package org.example.aopadvices;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Order {

    private int orderId;
    private String orderBy;
    private String orderAddress;
    private Map<Sd_Item, Integer> orderItems;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public Map<Sd_Item, Integer> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Map<Sd_Item, Integer> orderItems) {
        this.orderItems = orderItems;
    }

    public void displayOrderItems(){

        if(orderItems.isEmpty()){
            throw new IllegalStateException("There are no orders in the cart");
        }

        String format="|%1$-24s|%2$-8s|%3$-8s|\n";

        System.out.println("\n--------------ORDER--------------");
        System.out.println("OrderId: " + orderId + "\nOrderBy: " + orderBy);
        System.out.println("------------------------------------------------");
        System.out.format(format, "ITEM NAME", "PRICE","QUANTITY");
        System.out.println("------------------------------------------------");

        for (Map.Entry<Sd_Item, Integer> entry : orderItems.entrySet()){

            System.out.format(format, entry.getKey().itemName,
                    entry.getKey().itemPrice, entry.getValue());
        }

        System.out.println("\nOrder Address: " + orderAddress);
        System.out.println("-----------------------------------------------");
    }

    public float getOrderValue(){
        float totalPrice=0f;

        if(!orderItems.isEmpty()){

            for(Map.Entry<Sd_Item, Integer> entry : orderItems.entrySet()){
                totalPrice+= entry.getKey().itemPrice * entry.getValue();
            }
        }
        return totalPrice;

    }

}
