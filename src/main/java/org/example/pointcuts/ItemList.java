package org.example.pointcuts;

import java.util.List;

public class ItemList {

    List<Item> items;

    public List<Item> getItems(){
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void printNumDetails() {

        System.out.println("\n*--- Method: ItemList.printNumDetails() has been called ---*");
        System.out.println("There are " + items.size() + " item in total.");
    }

    @DetailPublisher
    public void displayItemList(){
        System.out.println("\n*--- Method: ItemList.displayItemList() is called ---*");

        String format = "|%1$-8s|%2$-16s|%3$-16s|%4$-16s|\n";
        System.out.println("--------------------------------------------");
        System.out.format(format, "ITEM ID", "ITEM NAME", "ITEM PRICE","QUANTITY");
        System.out.println("--------------------------------------------");

        for(Item item : items){
            System.out.format(format,
                    item.getItemId(), item.getItemName(),
                    item.getItemPrice(), item.getAvailableQuantity());
        }
        System.out.println("--------------------------------------------");
    }

    public void addItemList(Item item){
        this.items.add(item);
    }

    public void addItemToListAtIndex(int index, Item item){
        this.items.add(index,item);
    }
}
