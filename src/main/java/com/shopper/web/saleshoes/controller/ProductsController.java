package com.shopper.web.saleshoes.controller;

import com.shopper.web.saleshoes.domain.Products;
import com.shopper.web.saleshoes.repository.ProductRepository;
import com.shopper.web.saleshoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductsController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository repository;

//    @RequestMapping(value = "/men")
//    public String getList(ModelMap mm, Pageable pageable ) {
//        mm.addAttribute("men", productService.show(1));
//        return "men";
//    }

    @RequestMapping(value = "/shop")
    public String getAllProducts(Model model, Pageable pageable) {
        List<Products> list = productService.getAllProducts();
        PagedListHolder<Products> page = new PagedListHolder<>(list);
        page.setPage(pageable.getPageNumber());
        page.setPageSize(pageable.getPageSize());
        model.addAttribute("shop", page.getPageList());
        model.addAttribute("page", page.getPage());
        model.addAttribute("hasPre", !page.isFirstPage());
        model.addAttribute("hasNext", !page.isLastPage());
        return "shop";
    }

    @RequestMapping(value = "/shop-single")
    public String getDetailProduct(@RequestParam("id") Long id, Model model){
        Optional<Products> products = repository.findById(id);
        if(products != null){
            model.addAttribute("product",products.get());
        }
        return "shop-single";
    }
}
