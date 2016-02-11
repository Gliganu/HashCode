package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drone extends Piece {

    private HashMap<Integer,Integer> carriedProductsMap;
    private Warehouse warehouse;

    private List commandsList;
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
        Map availableProducts = warehouse.getAvailableProductsMap();
    }

    public boolean isJobDone() {
        return commandsList.isEmpty();
    }

    public void setOrdersList(List commandsList) {
        this.commandsList = commandsList;
    }

}
