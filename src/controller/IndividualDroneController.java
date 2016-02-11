package controller;

import model.Warehouse;

import java.util.HashMap;
import java.util.Map;

public class IndividualDroneController {

    private Integer currentLocationX, currentLocationY;
    private Warehouse warehouse;
    private Map commandsList;
    private Map loadedProducts;

    /**
     * The drone only knows about the warehouse and commands assigned to it.
     * Consider for now that the warehouse has enough products to fulfill all the commands.
     * Initially it has no loaded products.
     */
    public IndividualDroneController(int x, int y, Map commandsForMe, Warehouse warehouse) {
        currentLocationX = x;
        currentLocationY = y;
        this.warehouse = warehouse;
        commandsList = commandsForMe;
        loadedProducts = new HashMap<Integer, Integer>();
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

    }

    public boolean isJobDone() {
        return commandsList.isEmpty();
    }

    public Integer getCurrentLocationX() {
        return currentLocationX;
    }

    public void setCurrentLocationX(Integer currentLocationX) {
        this.currentLocationX = currentLocationX;
    }

    public Integer getCurrentLocationY() {
        return currentLocationY;
    }

    public void setCurrentLocationY(Integer currentLocationY) {
        this.currentLocationY = currentLocationY;
    }
}
