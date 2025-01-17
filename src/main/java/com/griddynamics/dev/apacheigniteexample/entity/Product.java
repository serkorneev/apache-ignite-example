package com.griddynamics.dev.apacheigniteexample.entity;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.util.Objects;

public class Product {

    @QuerySqlField(name = "uniq_id", index = true)
    private String id;

    @QuerySqlField(name = "sku")
    private String sku;

    @QuerySqlField(name = "name_title")
    private String title;

    @QuerySqlField(name = "description")
    private String description;

    @QuerySqlField(name = "list_price")
    private String listPrice;

    @QuerySqlField(name = "sale_price")
    private String salePrice;

    @QuerySqlField(name = "category")
    private String category;

    @QuerySqlField(name = "category_tree")
    private String categoryTree;

    @QuerySqlField(name = "average_product_rating")
    private String averageProductRating;

    @QuerySqlField(name = "product_url")
    private String productUrl;

    @QuerySqlField(name = "product_image_urls")
    private String productImageUrls;

    @QuerySqlField(name = "brand")
    private String brand;

    @QuerySqlField(name = "total_number_reviews")
    private String totalNumberReviews;

    @QuerySqlField(name = "reviews")
    private String reviews;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getListPrice() {
        return listPrice;
    }

    public void setListPrice(String listPrice) {
        this.listPrice = listPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryTree() {
        return categoryTree;
    }

    public void setCategoryTree(String categoryTree) {
        this.categoryTree = categoryTree;
    }

    public String getAverageProductRating() {
        return averageProductRating;
    }

    public void setAverageProductRating(String averageProductRating) {
        this.averageProductRating = averageProductRating;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getProductImageUrls() {
        return productImageUrls;
    }

    public void setProductImageUrls(String productImageUrls) {
        this.productImageUrls = productImageUrls;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTotalNumberReviews() {
        return totalNumberReviews;
    }

    public void setTotalNumberReviews(String totalNumberReviews) {
        this.totalNumberReviews = totalNumberReviews;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
