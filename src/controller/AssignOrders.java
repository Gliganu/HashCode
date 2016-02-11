package controller;

import model.Drone;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class AssignOrders {

    private List ordersList;
    private int dronesNumber;
    private List dronesList;
    private int defaultDroneX, defaultDroneY;

    public AssignOrders(List ordersList, int nrDrones, int defaultDroneLocX, int defaultDroneLocY) {
        this.ordersList = ordersList;
        this.dronesNumber = nrDrones;
        this.defaultDroneX = defaultDroneLocX;
        this.defaultDroneY = defaultDroneLocY;
        dronesList = new ArrayList<Drone>();
        for (int i = 0; i < dronesNumber; i++) {
            dronesList.add(new Drone(defaultDroneLocX, defaultDroneLocY));
        }
    }

    public void assign() {
        sortOrdersBasedOnLocation();
        assignDronesToOrders();
    }

    private void sortOrdersBasedOnLocation() {
        ordersList.sort((order1, order2) -> {

            double distanceFromOrder1 = Utils.calculateCellsDistance(defaultDroneX, defaultDroneY,
                    ((Order) order1).getX(), ((Order) order1).getY());
            double distanceFromOrder2 = Utils.calculateCellsDistance(defaultDroneX, defaultDroneY,
                    ((Order) order2).getX(), ((Order) order2).getY());

            if (distanceFromOrder1 < distanceFromOrder2) {
                return -1;
            } else if (distanceFromOrder1 > distanceFromOrder2) {
                return 1;
            }
            return 0;
        });
    }

    private void assignDronesToOrders() {
        List smallOrders = Utils.chop(ordersList, dronesNumber);
        for (int i = 0; i < dronesNumber; i++) {
            ((Drone) dronesList.get(i)).setOrdersList((List) smallOrders.get(i));
        }
    }
}
