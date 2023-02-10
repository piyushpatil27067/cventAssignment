package com.piyush.api;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Product {

//    @NotNull
//    @Valid
//    private DataSourceFactory dataSourceFactory = new DataSourceFactory();
//
//    @JsonProperty("database")
//    public DataSourceFactory getDataSourceFactory() {
//        return dataSourceFactory;
//    }

    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    public Product() {
    }

    public Product(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
