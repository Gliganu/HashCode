package controller;

import model.Order;
import model.Warehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Andreea Stan on 2/11/2016.
 */
public class WarehouseAssignmentController {

    private ArrayList<Warehouse> _Warehouses;

    public WarehouseAssignmentController(ArrayList<Warehouse> warehouses) {
        _Warehouses = new ArrayList<>();
        _Warehouses = warehouses;
    }

    public void AssignOrdersToWarehouses(ArrayList<Order> orders) {
        for (int i = 0; i < orders.size(); i++) {
            Warehouse returnedWarehouse = CalculateDistance(orders.get(i));
            int pos = _Warehouses.indexOf(returnedWarehouse);
             _Warehouses.get(pos).addOrderToWarehouse(orders.get(i));
        }
    }

    private Warehouse CalculateDistance(Order order) {
        HashMap<Integer, Warehouse> distances = new HashMap<>();
        for (int j = 0; j < _Warehouses.size(); j++) {
            int distanceX = order.getX() - _Warehouses.get(j).getX();
            int distanceY = order.getY() - _Warehouses.get(j).getY();
            int distance = (int) Math.sqrt(distanceX * distanceX + distanceY * distanceY);
            distances.put(distance, _Warehouses.get(j));
        }
        List keys = new ArrayList(distances.keySet());
        Collections.sort(keys);
        return distances.get(keys.get(0));
    }
}
