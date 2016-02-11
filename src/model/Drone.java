package model;

import java.util.HashMap;
import java.util.Map;

public class Drone extends Piece {

    private HashMap<Integer,Integer> carriedProductsMap;
    private Warehouse warehouse;
    private Map commandsList;
    private Map loadedProducts;
    private int currentLoad;

    public Drone(int x, int y) {
        super(x, y);
        this.currentLoad = 0;
        this.carriedProductsMap = new HashMap<>();
    }

    public HashMap<Integer, Integer> getCarriedProductsMap() {
        return carriedProductsMap;
    }

    public void setCarriedProductsMap(HashMap<Integer, Integer> carriedProductsMap) {
        this.carriedProductsMap = carriedProductsMap;
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
}
