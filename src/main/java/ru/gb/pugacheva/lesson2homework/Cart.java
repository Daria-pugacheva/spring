package ru.gb.pugacheva.lesson2homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private ProductRepository productRepository;
    //@Value("new ArrayList<>()") // в методичке написано, что Value только для примитивов подходит. Но, вроде, на уроке для String использовали...засомневалась
    private List<Product> productsInCart;

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init (){
        productsInCart = new ArrayList<>();
    }

    public void addProduct(int id){
        productsInCart.add(productRepository.findProductById(id));
    }

    public void deleteProduct (int id){
        productsInCart.remove(productsInCart.stream().filter(i->i.getId()==id).findFirst().get());
    }


}
