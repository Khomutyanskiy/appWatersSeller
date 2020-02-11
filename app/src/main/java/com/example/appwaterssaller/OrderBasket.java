package com.example.appwaterssaller;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

public class OrderBasket {

    ArrayList<Order> orderlist = new ArrayList<>();

    Double amounts= 0.0;
    Context context;

    public OrderBasket() {

    }

    public ArrayList<Order> getOrderlist() {
        return orderlist;
    }

    public void addOrder(Product product, int number) {

        Order order = new Order(product, number);
        orderlist.add(order);
    }

    public void changeOrderPlus(Product product) {
        int n = 0;
        for (int i = 0; i < orderlist.size(); i++) {
            if (orderlist.get(i).getProduct() == product) {
                n = orderlist.get(i).getNumber();
                Log.d ("N", String.valueOf(n));
                orderlist.remove(i);
            }
        }
        n++;
        addOrder(product, n);
        changeOrderPrice();
    }

    public void changeOrderMinus(Product product) {
        int n = 0;
        for (int i = 0; i < orderlist.size(); i++) {
            if (orderlist.get(i).getProduct() == product) {
                n = orderlist.get(i).getNumber();
                orderlist.remove(i);
            }
        }
        n--;
        if (n>0) {
            addOrder(product, n);
        }


        changeOrderPrice();
    }

    public Double getOrderPrice (Product product){
        Double price = 0.0;
        for (int i = 0; i < orderlist.size(); i++) {
            if (orderlist.get(i).getProduct() == product) {
                price = orderlist.get(i).getProduct().getPrice();
            }
        }
        return price;
    }

    // Возвращает произведение стоимости на количество товара
    public Double getOrderAmountProduct (Product product) {
          Double amounts = 0.0;
        for (int i = 0; i < orderlist.size(); i++) {
            if (orderlist.get(i).getProduct() == product) {
                amounts = orderlist.get(i).getNumber()*orderlist.get(i).getProduct().getPrice();

            }
        }
          return amounts;
    }

    public void changeOrderPrice() {

        amounts = 0.0;

        for (int i = 0; i < orderlist.size(); i++) {

            amounts = amounts + (orderlist.get(i).getNumber()*orderlist.get(i).getProduct().getPrice());
        }


    }

    public Double getAmounts() {
        return amounts;
    }

    public void removOrder(int id) {

    }

    public int getNumber (Product product) {
        int number = 0;
        for (int i = 0; i < orderlist.size(); i++) {
            if (orderlist.get(i).getProduct() == product) {
                number = orderlist.get(i).getNumber();
            }
        }
        return number;
    }
}
