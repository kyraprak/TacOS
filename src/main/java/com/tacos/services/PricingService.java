// service layer responsible for order pricing operations
package com.tacos.services;

import com.tacos.models.Order;

public class PricingService {

    public double calculateOrderTotal(Order order) {

        return order.calculateTotal();
    }
}

//order class knows how to total itself
//PricingService becomes a thin service layer
//duplicated loops removed
//easier to maintain later
//pricing logic now lives inside Order class
