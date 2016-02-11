package model;

import java.util.HashMap;

/**
 * Created by GligaBogdan on 11-Feb-16.
 */
public class ProductTransfer {

    private Warehouse source;
    private Warehouse destination;
    private HashMap<Integer,Integer> transferProductMap;

    public ProductTransfer(Warehouse source, Warehouse destination, HashMap<Integer, Integer> transferProductMap) {
        this.source = source;
        this.destination = destination;
        this.transferProductMap = transferProductMap;
    }

    public Warehouse getSource() {
        return source;
    }

    public void setSource(Warehouse source) {
        this.source = source;
    }

    public Warehouse getDestination() {
        return destination;
    }

    public void setDestination(Warehouse destination) {
        this.destination = destination;
    }

    public HashMap<Integer, Integer> getTransferProductMap() {
        return transferProductMap;
    }

    public void setTransferProductMap(HashMap<Integer, Integer> transferProductMap) {
        this.transferProductMap = transferProductMap;
    }
}
