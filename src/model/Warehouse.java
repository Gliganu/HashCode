package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by GligaBogdan on 11-Feb-16.
 */
public class Warehouse extends Piece {

    private HashMap<Integer,Integer> availableProductsMap;
    private List<Order> orderList;

    public Warehouse(int x, int y) {
        super(x, y);
        this.availableProductsMap = new HashMap<>();
        this.setOrderList(new ArrayList<>());
    }

    public HashMap<Integer, Integer> getAvailableProductsMap() {
        return availableProductsMap;
    }

    public void setAvailableProductsMap(HashMap<Integer, Integer> availableProductsMap) {
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
