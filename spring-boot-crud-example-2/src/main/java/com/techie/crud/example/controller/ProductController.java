package com.techie.crud.example.controller;

import com.techie.crud.example.entity.Product;
import com.techie.crud.example.service.ProductService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static java.util.Objects.isNull;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts(){
       return productService.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @GetMapping("/productByName/{name}")
    public Product findProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

    @PutMapping("/update")
    public String updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable  int id){
        if(isNull(productService.getProductById(id))){
            return "product "+id+" does not exist";
        }
        return productService.deleteProduct(id);
    }

    @DeleteMapping("deleteAllProducts")
    public String deleteAllProducts(){
        return productService.deleteAll();
    }

}
