package model;

import java.util.HashMap;

public class Order extends Piece {

<<<<<<< HEAD
    private HashMap<Product,Integer> neededProductsMap;
=======
    private HashMap<Product, Integer> neededProductsMap;
>>>>>>> Parsed input

    public Order(int x, int y) {
        super(x, y);
        this.neededProductsMap = new HashMap<>();
    }

    public HashMap<Product, Integer> getNeededProductsMap() {
        return neededProductsMap;
    }

    public void setNeededProductsMap(HashMap<Product, Integer> neededProductsMap) {
        this.neededProductsMap = neededProductsMap;
    }


}
