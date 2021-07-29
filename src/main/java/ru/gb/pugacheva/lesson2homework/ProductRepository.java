package ru.gb.pugacheva.lesson2homework;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> productList;

    @PostConstruct
    public void init (){
        productList = new ArrayList<>(Arrays.asList(
                new Product(1, "Milk", 100),
                new Product(2, "Water", 200),
                new Product(3, "Juice", 300),
                new Product(4, "Tee", 400),
                new Product(5, "Coffee", 500)
                ));
    }

    public List<Product> showAllProducts (){
        return productList;
    }

    public Product findProductById (int id){
        return productList.stream().filter(i-> i.getId()==id).findFirst().get();
    }
}
