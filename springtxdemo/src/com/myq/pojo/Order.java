package com.myq.pojo;

public class Order {
    private int orderid;
    private double orderprice;

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", orderprice=" + orderprice +
                '}';
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public double getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(double orderprice) {
        this.orderprice = orderprice;
    }
}
