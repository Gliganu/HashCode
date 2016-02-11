package controller;

import model.Drone;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AssignCommands {

    private List ordersList;
    private int dronesNumber;
    private List dronesList;
    private int defaultDroneX, defaultDroneY;

    public AssignCommands(List ordersList, int nrDrones, int defaultDroneLocX, int defaultDroneLocY) {
        this.ordersList = ordersList;
        this.dronesNumber = nrDrones;
        this.defaultDroneX = defaultDroneLocX;
        this.defaultDroneY = defaultDroneLocY;
        dronesList = new ArrayList<Drone>();
        for(int i=0; i<dronesNumber; i++) {
            dronesList.add(new Drone(defaultDroneLocX, defaultDroneLocY));
        }
    }

    public void assign() {
        sortOrdersBasedOnLocation();
        assignDronesToOrders();
    }

    private void sortOrdersBasedOnLocation() {
       /* ordersList.sort(new Comparator() {
            @Override
            public int compare(Object order1, Object order2) {

                if(Utils.calculateCellsDistance())

                return 0;
            }
        });*/
    }

    private void assignDronesToOrders() {

    }
}
