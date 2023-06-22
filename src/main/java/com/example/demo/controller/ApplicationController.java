package com.example.demo.controller;


import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search/*")
public class ApplicationController {
    @Autowired
    public ProductRepository productRepository;
    @GetMapping("list")
    public List<Product> list(@RequestParam(value = "msn",required = false) String msn,
                              @RequestParam(value = "id",required = false) String od,
                              @RequestParam(value = "Title",required = false) String Title){
        Specification<Product> spec = service.getSpec(msn, od, Title);
        System.out.println(spec);
        return productRepository.findAll(spec);


    }

}
