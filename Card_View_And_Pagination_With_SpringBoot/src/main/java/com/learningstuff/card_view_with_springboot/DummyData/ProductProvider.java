package com.learningstuff.card_view_with_springboot.DummyData;

import com.learningstuff.card_view_with_springboot.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductProvider {

    private static List<Product> products = new ArrayList<>();


    static {
        products.add(new Product(1,"name1","desc1"));
        products.add(new Product(2,"name2","desc2"));
        products.add(new Product(3,"name3","desc3"));
        products.add(new Product(4,"name4","desc4"));
        products.add(new Product(6,"name6","desc6"));
        products.add(new Product(7,"name7","desc7"));
        products.add(new Product(8,"name8","desc8"));
        products.add(new Product(9,"name9","desc9"));
        products.add(new Product(10,"name10","desc10"));
        products.add(new Product(11,"name11","desc11"));
    }

    public List<Product> getAllProduct()
    {
        return products;
    }


}
