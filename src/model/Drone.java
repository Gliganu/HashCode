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

    public Drone(int x, int y) {
        super(x, y);
        this.currentLoad = 0;
        this.carriedProductsMap = new HashMap<>();
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
