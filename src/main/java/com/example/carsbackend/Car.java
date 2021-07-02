package com.example.carsbackend;

public class Car {
    private String name;
    private String brand;
    private int doors;
    private String price;

    public Car(String name, String brand, int doors, String price) {
        this.name = name;
        this.brand = brand;
        this.doors = doors;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", doors=" + doors +
                ", price='" + price + '\'' +
                '}';
    }
}
