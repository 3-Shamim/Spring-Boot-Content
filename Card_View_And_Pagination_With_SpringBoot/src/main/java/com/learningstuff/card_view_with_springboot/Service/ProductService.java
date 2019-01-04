package com.learningstuff.card_view_with_springboot.Service;

import com.learningstuff.card_view_with_springboot.Model.Product;
import com.learningstuff.card_view_with_springboot.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findByName(String name)
    {
        return productRepository.findByNameLike("%"+name+"%");
    }
}
