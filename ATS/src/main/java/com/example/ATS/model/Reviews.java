package com.example.ATS.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "reviews")
public class Reviews {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private  int rating;
    @Column(name="content", length=10000)
    private  String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Products products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "id=" + id +
                ", rating=" + rating +
                ", content='" + content + '\'' +
                ", products=" + products +
                '}';
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public void setProducts(Products products) {
        this.products = products;
        products.getReviewsSet().add(this);
    }
}
