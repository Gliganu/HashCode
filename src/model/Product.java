package model;

/**
 * Created by Andrei on 11/02/2016.
 */
public class Product {
    int id;
    int weight;

    public Product(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
