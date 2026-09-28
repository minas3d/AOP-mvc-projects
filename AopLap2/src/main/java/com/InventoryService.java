package com;

public interface InventoryService
{ public int checkStock(String sku);
    public String reserveStock(String sku, int qty);
}
