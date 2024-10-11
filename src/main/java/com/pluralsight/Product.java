package com.pluralsight;

public class Product {

    private String Department;
    private String name;
    private String SKU;
    private float price;

    public Product(String SKU, String name, float price, String Department) {
        this.SKU = SKU;
        this.Department = Department;
        this.name = name;
        this.price = price;
    }

    public String getSKU() {
        return this.SKU;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }
    public String getDepartment(){
        return this.Department;
    }

}



