package model;

import java.util.HashMap;

public class Order extends Piece {

    private HashMap<Product,Integer> neededProductsMap;

    public Order(int x,int y) {
        super(x,y);
        this.neededProductsMap = new HashMap<>();
    }

    public HashMap<Product, Integer> getNeededProductsMap() {
        return neededProductsMap;
    }

    public void setNeededProductsMap(HashMap<Product, Integer> neededProductsMap) {
        this.neededProductsMap = neededProductsMap;
    }


}
