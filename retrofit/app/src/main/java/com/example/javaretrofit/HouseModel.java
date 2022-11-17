package com.example.javaretrofit;

public class HouseModel {

    private int id;
    private String tittle;
    private String price;
    private Double lat;
    private Double lng;
    private String imgUrl;


    public HouseModel(int id, String tittle, String price, Double lat, Double lng, String imgUrl) {
        this.id = id;
        this.tittle = tittle;
        this.price = price;
        this.lat = lat;
        this.lng = lng;
        this.imgUrl = imgUrl;
    }

    public int getId() { return id; }

    public String getTittle() { return tittle; }

    public String getPrice() { return price; }

    public Double getLat() { return lat; }

    public Double getLng() { return lng; }

    public String getImgUrl() { return imgUrl; }
}
