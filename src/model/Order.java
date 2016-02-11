package model;

import java.util.HashMap;

public class Order extends Piece {

    private HashMap<Integer,Integer> neededProductsMap;

    public Order(int x,int y) {
        super(x,y);
        this.neededProductsMap = new HashMap<>();
    }

    public HashMap<Integer, Integer> getNeededProductsMap() {
        return neededProductsMap;
    }

    public void setNeededProductsMap(HashMap<Integer, Integer> neededProductsMap) {
        this.neededProductsMap = neededProductsMap;
    }


}
