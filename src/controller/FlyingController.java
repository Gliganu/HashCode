package controller;

import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FlyingController {

    private Piece[][] moveMap;
    private Drone[] drones;
    private int nrOfTurns;
    private Product[] products;

    public FlyingController() {
        parseInput("busy_day.in");
    }

    private void parseInput(String s) {
        try {
            FileReader fs = new FileReader(s);
            BufferedReader bs = new BufferedReader(fs);

            //first section
            String first = bs.readLine();
            String[] tokens = first.split(" ");
            this.moveMap = new Piece[Integer.parseInt(tokens[0])][Integer.parseInt(tokens[1])];
            this.drones = new Drone[Integer.parseInt(tokens[2])];
            this.nrOfTurns = Integer.parseInt(tokens[3]);
            int maxDroneLoad = Integer.parseInt(tokens[4]);

            //product section
            int nrProducts = Integer.parseInt(bs.readLine());
            this.products = new Product[nrProducts];
            String productWeights = bs.readLine();
            String[] weights = productWeights.split(" ");
            for (int i = 0; i < weights.length; i++)
                this.products[i] = new Product(i, Integer.parseInt(weights[i]));

            //warehouse section
            int nrWarehouses = Integer.parseInt(bs.readLine());
            for (int i = 0; i < nrWarehouses; i++) {
                String position = bs.readLine();
                String[] positions = position.split(" ");
                //y position
                int row = Integer.parseInt(positions[0]);
                //x position
                int column = Integer.parseInt(positions[1]);
                moveMap[row][column] = new Warehouse(column, row);
                String warehouseStocks = bs.readLine();
                String[] productStockList = warehouseStocks.split(" ");
                HashMap<Product, Integer> availableProducts = new HashMap<>();
                for (int j = 0; j < productStockList.length; j++)
                    availableProducts.put(this.products[j], Integer.parseInt(productStockList[j]));
                ((Warehouse) moveMap[row][column]).setAvailableProductsMap(availableProducts);

                //put drones at location of warehouse 0
                if (i == 0)
                    for (int j = 0; j < this.drones.length; j++)
                        drones[j] = new Drone(column, row, maxDroneLoad);
            }

            //orders section
            int nrOrders = Integer.parseInt(bs.readLine());
            for (int i = 0; i < nrOrders; i++) {
                String position = bs.readLine();
                String[] positions = position.split(" ");
                //y position
                int row = Integer.parseInt(positions[0]);
                //x position
                int column = Integer.parseInt(positions[1]);
                moveMap[row][column] = new Order(column, row);
                int orderLength = Integer.parseInt(bs.readLine());
                HashMap<Product, Integer> neededProducts = new HashMap<>();
                String allOrders = bs.readLine();
                String[] ordersArray = allOrders.split(" ");
                for (int j = 0; j < orderLength; j++) {
                    int prodId = Integer.parseInt(ordersArray[j]);
                    if (neededProducts.get(this.products[prodId]) == null)
                        neededProducts.put(this.products[prodId], 1);
                    else neededProducts.put(this.products[prodId], neededProducts.get(this.products[prodId]) + 1);
                }
                ((Order) moveMap[row][column]).setNeededProductsMap(neededProducts);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
