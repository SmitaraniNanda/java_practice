package com.questk2.Ecommerce;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class handles order processing by maintaining a list of orders.
 * It processes unprocessed orders and removes them from the list.
 */
public class OrderProcessing {
    public static void main(String[] args) {
        List<Order> list = new LinkedList<>();
        list.add(new Order("O_123", "Smita", true));
        list.add(new Order("O_456", "Khusi", false));
        list.add(new Order("O_789", "Puja", true));
        list.add(new Order("O_012", "Gita", false));

        processOrders(list);

        System.out.println("Processed Orders : ");
        for (Order order : list) {
            System.out.println(order);
        }
    }

    /**
     * Processes unprocessed orders and removes them from the list.
     * 
     * @param orders The list of orders to be processed.
     */
    public static void processOrders(List<Order> orders) {
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (!order.getProcessed()) {
                order.orderProcessed();
                iterator.remove();
            }
        }
    }
}
