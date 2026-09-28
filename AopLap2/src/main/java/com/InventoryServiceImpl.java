package com;

public class InventoryServiceImpl implements InventoryService{
    @Override
    public int checkStock(String sku){
return sku.length();
    }
    @Override
    public String reserveStock(String sku, int qty){
        return    "msg is " + sku +" and number is " +qty ;

    }
}
