package com.learningstuff.card_view_with_springboot.Controller;

import com.learningstuff.card_view_with_springboot.Model.Product;
import com.learningstuff.card_view_with_springboot.Repository.ProductRepository;
import com.learningstuff.card_view_with_springboot.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "")
public class CardViewController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "cardView")
    private String cardView(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String name)
    {
        model.addAttribute("title", "Card View");
//        model.addAttribute("products", productRepository.findAll(new PageRequest(page, 6)));

        List<Product> products = new ArrayList<>();
        products.addAll(productService.findByName(name));
        int sizeOfProduct = products.size();
        int totalItem = 6;

        /*for (int i = page * totalItem; i < (page * totalItem) + totalItem ; i++) {
            products.add(productService.findByName(name).get(i));
        }*/

        int from = page * totalItem;
        int to = (page * totalItem) + totalItem;

        if(sizeOfProduct <=  to)
        {
            model.addAttribute("products", products.subList(from, sizeOfProduct));
        }
        else
        {
            model.addAttribute("products", products.subList(from, to));
        }

        model.addAttribute("totalPage", sizeOfProduct / totalItem);

        return "templates/CardView";
    }

}
