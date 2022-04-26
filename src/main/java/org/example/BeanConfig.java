package org.example;


import org.example.aopadvices.Order;
import org.example.aopadvices.Sd_Item;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.HashMap;
import java.util.Map;

@ComponentScan(basePackages = "org.example")
@Configuration
@EnableAspectJAutoProxy
public class BeanConfig {

    @Bean(name = "orderBean")
    public Order mainOrderBean(){

        Order order = new Order();
        order.setOrderId(1101);
        order.setOrderBy("Bob Brenner");
        order.setOrderAddress("3077B Oak Ave, Seattle, WA");

        Sd_Item itemOne = new Sd_Item(101, "Milk",3.25f,5);
        Sd_Item itemTwo = new Sd_Item(102, "Bread",8.25f,10);

        Map<Sd_Item, Integer> cart = new HashMap<>();
        cart.put(itemOne,2);
        cart.put(itemTwo,5);

        order.setOrderItems(cart);

        return order;
    }
}
