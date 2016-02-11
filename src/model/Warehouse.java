package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Warehouse extends Piece {

    private HashMap<Product,Integer> availableProductsMap;
    private List<Order> orderList;

    public Warehouse(int x, int y) {
        super(x, y);
        this.availableProductsMap = new HashMap<>();
    }

    public HashMap<Product, Integer> getAvailableProductsMap() {
        return availableProductsMap;
    }

    public void setAvailableProductsMap(HashMap<Product, Integer> availableProductsMap) {
        this.availableProductsMap = availableProductsMap;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void addOrderToWarehouse(Order order){
        orderList.add(order);
    }
}
