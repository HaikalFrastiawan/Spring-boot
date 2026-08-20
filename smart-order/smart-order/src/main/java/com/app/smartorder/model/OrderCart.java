package com.app.smartorder.model;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class OrderCart {
    private final List<Product> items = new ArrayList<>();

    public void addItems(Product product){
        items.add(product);
    }

    public List<Product> getItems(){
        return items;
    }

    public BigDecimal calculateTotal(){
        return items.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
