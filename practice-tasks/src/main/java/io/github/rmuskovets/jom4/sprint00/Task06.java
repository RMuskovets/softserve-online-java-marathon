package io.github.rmuskovets.jom4.sprint00;

class Product_06 {
    private String name;
    private double price;

    private static int COUNT = 0;

    public Product_06() { this("", 0.0); }
    public Product_06(String name, double price) {
        this.name = name; this.price = price;
        COUNT++;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String x) {
        name = x;
    }

    public void setPrice(double x) {
        price = x;
    }

    public static int count() {
        return COUNT;
    }
}