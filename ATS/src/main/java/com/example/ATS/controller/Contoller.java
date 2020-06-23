package com.example.ATS.controller;
import com.example.ATS.consummer.ATSConsumer;
import com.example.ATS.model.Products;
import com.example.ATS.model.Reviews;
import com.example.ATS.repository.ProductRepository;
import com.example.ATS.repository.ReviewRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class Contoller {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ReviewRepository reviewRepository;

    private static final ATSConsumer atsConsumer =new ATSConsumer();
    @GetMapping("/getfromATS")
    public void GetFromATS() throws IOException {
        JSONObject jsonObject= atsConsumer.getProductsFromATS();

        List<LinkedHashMap<String,String>> prducts= (List<LinkedHashMap<String, String>>) jsonObject.get("products");
        for(int i=0;i<prducts.size();i++){

            Products products=new Products();
            products.setColor(prducts.get(i).get("color"));
            products.setCategory(prducts.get(i).get("category"));
            products.setDescription(prducts.get(i).get("description"));
            products.setCreatedAt(prducts.get(i).get("createdAt"));
            products.setPrice(prducts.get(i).get("price"));
            products.setTag(prducts.get(i).get("tag"));
            products.setImageUrl(prducts.get(i).get("imageUrl"));
            products.setProductName(prducts.get(i).get("productName"));
            products.setProductMaterial(prducts.get(i).get("productMaterial"));
            ObjectMapper objectMapper = new ObjectMapper();
            Object list = prducts.get(i).get("reviews");
            List<LinkedHashMap<String,String>> reviews=(List<LinkedHashMap<String, String>>)list;
            for(int j=0;j<reviews.size();j++) {
                Reviews review = new Reviews();
                review.setContent(reviews.get(j).get("content"));
                Object o=reviews.get(j).get("rating");
                review.setRating((int)o);
                products.setReviewsSet(review);
                //reviewRepository.save(review);
            }
            productRepository.save(products);

        }

    }
    @GetMapping("/products")
    Page<Products> getProducts(@RequestParam int pagenumber){
        Pageable PageWith20Elements = PageRequest.of(pagenumber, 20);
        return productRepository.findAll(PageWith20Elements);

    }
    @GetMapping("/products/{id}")
    Products getProductsByID(@PathVariable("id") int productId){
        return productRepository.findById(productId);

    }

}
