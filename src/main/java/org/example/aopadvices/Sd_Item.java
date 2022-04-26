package org.example.aopadvices;

import org.example.pointcuts.Item;

public class Sd_Item {

        int itemId;
        String itemName;
        float itemPrice;
        int availableQuantity;

        public Sd_Item(){}

    public Sd_Item(int itemId, String itemName, float itemPrice, int availableQuantity){
            this.itemId=itemId;
            this.itemName=itemName;
            this.itemPrice=itemPrice;
            this.availableQuantity=availableQuantity;
    }

        public int getItemId() {
            return itemId;
        }

        public float getItemPrice() {
            return itemPrice;
        }

        public int getAvailableQuantity() {
            return availableQuantity;
        }

        public String getItemName() {
            return itemName;
        }

        public void setAvailableQuantity(int availableQuantity) {
            this.availableQuantity = availableQuantity;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public void setItemPrice(float itemPrice) {
            this.itemPrice = itemPrice;

        }

        @Override
        public String toString() {
            return "Item{" +
                    "itemId=" + itemId +
                    ", itemName='" + itemName + '\'' +
                    ", itemPrice=" + itemPrice +
                    ", availableQuantity=" + availableQuantity +
                    '}';
        }
}
