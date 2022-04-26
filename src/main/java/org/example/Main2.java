package org.example;

import org.example.aopadvices.Order;
import org.springframework.context.ApplicationContext;

public class Main2 {
    public static void main(String[] args) {

        ApplicationContext context = AppContextWrapper.getContext();

        Order myOrder = (Order) context.getBean("orderBean");

        myOrder.displayOrderItems();
    }
}
