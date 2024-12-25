package com.javatechie.spring_boot_crud_example.service;

import com.javatechie.spring_boot_crud_example.entity.Product;
import com.javatechie.spring_boot_crud_example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService{
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){//post method based on product
        return repository.save(product);
    }
    public List<Product> saveProducts(List<Product> products){//post  method that posts all products
        return repository.saveAll(products);
    }
    public List<Product> getProducts(){//get method that fetches all products
        return repository.findAll();
    }
    public Product getProductById(int id){//get method that fetches based on product id
        return repository.findById(id).orElse(null );
    }
    public Product getProductByName(String name){//get method fetches based on product name
        return repository.findByName(name);
    }
    public String deleteProduct(int id){//delete method for delete based on the id
      repository.deleteById(id);
      return "product removed !! "+id;
    }
    public Product updateProduct(Product product){/*
         method for update product
        based on the incoming id wll fetch the existing product id svsilbslr in id
        */
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);

    }
}

