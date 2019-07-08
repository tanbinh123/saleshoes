package com.shopper.web.saleshoes.service.Impl;

import com.shopper.web.saleshoes.domain.Category;
import com.shopper.web.saleshoes.domain.Description;
import com.shopper.web.saleshoes.domain.Products;
import com.shopper.web.saleshoes.dto.ProductsDTO;
import com.shopper.web.saleshoes.repository.CategoryRepository;
import com.shopper.web.saleshoes.repository.DescriptionRepository;
import com.shopper.web.saleshoes.repository.ProductRepository;
import com.shopper.web.saleshoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private CategoryRepository repos;

    private ProductsDTO product;

    @Autowired
    private ProductRepository repository;

    @Autowired
    private DescriptionRepository reposDes;

    @Override
    public List<Products> show(int categoryId){
        List<Category> list = repos.findAll();
        List<Products> products = list.get(categoryId).getProductsList();
        return products;
    }
    @Override
    public  List<Products> getAllProducts(){
        List<Products> products = repository.findAll();
        return products;
    }


}
