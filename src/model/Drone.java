package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drone extends Piece {

    private HashMap<Integer,Integer> carriedProductsMap;
    private Warehouse warehouse;

    private ArrayList<Order> commandsList;
    private List loadedProducts;

    private int currentLoad;
    private int maxLoad;

    public Drone(int x, int y, int maxLoad) {
        super(x, y);
        this.currentLoad = 0;
        this.carriedProductsMap = new HashMap<>();
        this.maxLoad = maxLoad;
    }

    private void doTheJob() {
        while (!isJobDone()) {
            fulfillCommandsWithCurrentLoad();
            loadProductsFromWarehouse();
        }
    }

    private void fulfillCommandsWithCurrentLoad() {

    }

    private void loadProductsFromWarehouse() {
        for (int i = 0; i < commandsList.size(); i++) {
            loadSingleProductFromWarehouse(commandsList.get(i));
        }
    }

    private void loadSingleProductFromWarehouse(Order order) {
        Map neededProducts = order.getNeededProductsMap();
        List neededProductsList = new ArrayList(neededProducts.keySet());
        Map availableProducts = warehouse.getAvailableProductsMap();
        for (int i = 0; i < neededProductsList.size(); i++) {
            //if the item is in warehouse
            Object quantity = availableProducts.get(neededProducts.get(neededProductsList.get(i)));
            Object neededQuantity = neededProducts.get(neededProducts.get(i));
            if(quantity != null){
                availableProducts.put(neededProductsList.get(i),(int)quantity - (int)neededQuantity);
                currentLoad += (int)quantity;
            }
        }
    }

    public boolean isJobDone() {
        return commandsList.isEmpty();
    }

    public void setCommandsList(ArrayList<Order> commandsList) {
        this.commandsList = commandsList;
    }

}
