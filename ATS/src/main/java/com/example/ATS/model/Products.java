package com.example.ATS.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private  String color;
    private  String category;
    private  String productName;
    private  String price;

    public Products() {
        reviewsSet=new HashSet<>();
    }

    private  String description;
    private  String tag;
    private String productMaterial;
    private String imageUrl;
    private String createdAt;
    @OneToMany(
            mappedBy = "products",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private Set<Reviews> reviewsSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getProductMaterial() {
        return productMaterial;
    }

    public void setProductMaterial(String productMaterial) {
        this.productMaterial = productMaterial;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", category='" + category + '\'' +
                ", productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", tag='" + tag + '\'' +
                ", productMaterial='" + productMaterial + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", reviewsSet=" + reviewsSet +
                '}';
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Reviews> getReviewsSet() {
        return reviewsSet;
    }

    public void setReviewsSet(Reviews review) {
        this.reviewsSet.add(review);
        review.setProducts(this);
    }
}
