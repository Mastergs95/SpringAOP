package org.example.pointcuts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Item itemOne = (Item) context.getBean("itemBeanOne");
        Item itemTwo = (Item) context.getBean("itemBeanTwo");

        ItemList myList = (ItemList) context.getBean("listBean");


        myList.printNumDetails();
        myList.displayItemList();

        System.out.println("\n==============================");
        System.out.println("\nDisplaying the items one at a time");
        itemOne.printItemDetails();
        itemTwo.printItemDetails();

//        System.out.println("\n+++++++++++++++++++++++++++++");
//        System.out.println("\nCalling a setter");
//        itemOne.setAvailableQuantity(2);

    }
}
