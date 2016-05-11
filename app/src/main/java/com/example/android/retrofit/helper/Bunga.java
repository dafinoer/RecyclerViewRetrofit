package com.example.android.retrofit.helper;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by dafidzeko on 5/11/2016.
 */
public class Bunga implements Serializable {

    @Expose

    private int productId;

    @Expose
    private String category;

    @Expose
    private double price;

    @Expose
    private String instructions;

    @Expose
    private String photo;

    @Expose
    private String name;


    public int getProductId() {
        return productId;
    }

    public void setProductId(int id) {
        this.productId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nama) {
        this.name = nama;
    }

    public String getFoto() {
        return photo;
    }

    public void setFoto(String foto) {
        this.photo = foto;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String intruksi) {
        this.instructions = intruksi;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
