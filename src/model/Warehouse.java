package model;

import java.util.HashMap;

/**
 * Created by GligaBogdan on 11-Feb-16.
 */
public class Warehouse extends Piece {

    private HashMap<Integer,Integer> availableProductsMap;

    public Warehouse(int x, int y) {
        super(x, y);
        this.availableProductsMap = new HashMap<>();
    }

    public HashMap<Integer, Integer> getAvailableProductsMap() {
        return availableProductsMap;
    }

    public void setAvailableProductsMap(HashMap<Integer, Integer> availableProductsMap) {
        this.availableProductsMap = availableProductsMap;
    }
}
