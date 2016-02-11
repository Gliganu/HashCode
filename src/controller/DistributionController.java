package controller;

import model.Order;
import model.Product;
import model.ProductTransfer;
import model.Warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by GligaBogdan on 11-Feb-16.
 */
public class DistributionController {

    public static List<ProductTransfer> manageProductDistributions(List<Warehouse> warehouseList) {

        HashMap<Warehouse, HashMap<Product, Integer>> warehouseToNeededProductsMap = new HashMap<>();

        //get all the warehouses
        for (Warehouse warehouse : warehouseToNeededProductsMap.keySet()) {

            //all the products needed at this warehouses
            HashMap<Product, Integer> allProductsNeeded = new HashMap<>();

            //get all the orders from that warehouse
            for (Order order : warehouse.getOrderList()) {

                //all the needed products from this order
                HashMap<Product, Integer> neededProductsMap = order.getNeededProductsMap();

                for (Product product : neededProductsMap.keySet()) {

                    int quantity = neededProductsMap.get(product);

                    //this product wasn't encountered before
                    if (allProductsNeeded.get(product) == null) {
                        allProductsNeeded.put(product, quantity);
                    } else {
                        //add to existing quantity

                        int previousQuantity = allProductsNeeded.get(product);
                        allProductsNeeded.put(product, previousQuantity + quantity);
                    }

                }

            }

            warehouseToNeededProductsMap.put(warehouse, allProductsNeeded);

        }


        return constructTransferList(warehouseToNeededProductsMap);

    }


    private static List<ProductTransfer> constructTransferList(HashMap<Warehouse, HashMap<Product, Integer>> warehouseToNeededProductsMap) {

        List<ProductTransfer> productTransferList = new ArrayList<>();

        HashMap<Warehouse, HashMap<Product, Integer>> warehouseToExcessMap = new HashMap<>();
        HashMap<Warehouse, HashMap<Product, Integer>> warehouseToNeedMap = new HashMap<>();

        for (Warehouse warehouse : warehouseToNeededProductsMap.keySet()) {

            HashMap<Product, Integer> availableProductsMap = warehouse.getAvailableProductsMap();
            HashMap<Product, Integer> neededProductsMap = warehouseToNeededProductsMap.get(warehouse);

            HashMap<Product, Integer> excessProductsMap = new HashMap<>();
            HashMap<Product, Integer> minusesProductsMap = new HashMap<>();

            HashMap<Product, Integer> neededProductsMapCopy = new HashMap<>(neededProductsMap);

            for (Product product : availableProductsMap.keySet()) {

                int neededProductQuantity = neededProductsMapCopy.get(product);
                int availableProductQuantity = availableProductsMap.get(product);

                neededProductsMapCopy.remove(product);

                int result = availableProductQuantity - neededProductQuantity;

                if (result < 0) {
                    minusesProductsMap.put(product, result);
                } else {
                    excessProductsMap.put(product, result);
                }

            }

            //add all the products which weren't at all in the warehouse
            minusesProductsMap.putAll(neededProductsMapCopy);

            warehouseToExcessMap.put(warehouse, excessProductsMap);
            warehouseToNeedMap.put(warehouse, minusesProductsMap);
        }


        for(Warehouse minusWarehouse: warehouseToNeedMap.keySet()){

            HashMap<Product, Integer> neededProductsMap = warehouseToNeedMap.get(minusWarehouse);

            HashMap<Product, Integer> transferProductMap = new HashMap<>();

            //the product we need to seek in other warehouses
            for(Product neededProduct: neededProductsMap.keySet()){

                int neededQuantity= neededProductsMap.get(neededProduct);

                //search in all the plus warehouses
                for(Warehouse plusWarehouse: warehouseToExcessMap.keySet()){

                    HashMap<Product, Integer> excessProducts = warehouseToExcessMap.get(plusWarehouse);

                    //no excess products of the needed product
                    if( excessProducts.get(neededProduct) == null){
                        continue;
                    }

                    int excessQuantity = excessProducts.get(neededProduct);

                    if(excessQuantity > neededQuantity){

                        //update the product quantity
                        excessProducts.put(neededProduct,excessQuantity-neededQuantity);

                        transferProductMap.put(neededProduct,neededQuantity);


                    }



                }

            }

        }


        return productTransferList;


    }

}
