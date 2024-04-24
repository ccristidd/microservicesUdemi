package com.techie.crud.example.service;

import com.techie.crud.example.entity.Product;
import com.techie.crud.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    public List<Product> getProducts(){
        return repository.findAll();
    }

    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    public String deleteProduct(int id){
        repository.deleteById(id);
        return "product removed || " + id;
    }

    public String deleteAll(){
        repository.deleteAll();
        return "All products were deleted";
    }

    public String updateProduct(Product product){
        if(!((repository.findById(product.getId())).isPresent())){
            return "product " + product.getId() + " does not exist";
        }else{
            Product existingProduct = repository.findById(product.getId()).orElse(null);
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQuantity(product.getQuantity());
            repository.save(existingProduct);
        }
        return "product " + + product.getId() + " was updated";
    }
}
