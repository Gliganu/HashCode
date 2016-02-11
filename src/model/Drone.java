package model;

import java.util.HashMap;

/**
 * Created by GligaBogdan on 11-Feb-16.
 */
public class Drone extends Piece {


    private HashMap<Integer,Integer> carriedProductsMap;

    public Drone(int x, int y) {
        super(x, y);
        this.carriedProductsMap = new HashMap<>();
    }

    public HashMap<Integer, Integer> getCarriedProductsMap() {
        return carriedProductsMap;
    }

    public void setCarriedProductsMap(HashMap<Integer, Integer> carriedProductsMap) {
        this.carriedProductsMap = carriedProductsMap;
    }
}
