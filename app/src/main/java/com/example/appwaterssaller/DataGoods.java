package com.example.appwaterssaller;

import java.util.ArrayList;

public class DataGoods {

    ArrayList<Product> productlist = new ArrayList<>();

    public DataGoods() {

        Product product0 = new Product(0, "ВОДА ПИЛИГРИМ",19.0,"Рекомендована диетологами. Добывается в ледниках Кавказа", 70.0,"piligrim.png");
        Product product1 = new Product(1, "ВОДА ДОМБАЙ",19.0,"Добывается в ледниках Кавказа. Содержит необходимые 16 минералов и микроэлементов ", 80.0,"dombay.png");
        Product product2 = new Product(2, "ВОДА ГОРНАЯ ВЕРШИНА",19.0,"Добывается в ледниках Кавказа. Содержит необходимые 16 минералов и микроэлементов ", 90.0,"gornay.png");
        Product product3 = new Product(3, "ПОМПА «LILU» STANDARD",0.0,"Для бутылей 11 и 19 литров. Проста и удобна в эксплуатации. ", 330.0,"pompalilu.png");
        Product product4 = new Product(4, "ПОМПА ЭЛЕКТРИЧЕСКАЯ «SMIXX XL-D2»",0.0,"Подключается от сети. Адаптер в комплекте ", 900.0,"pompasmixx.png");
        Product product5 = new Product(5, "КУЛЕР MYL-31T",0.0,"Настольный кулер для воды с компрессорным охлаждением и краном.", 3400.0,"kyllermyl31t.png");
        Product product6 = new Product(6, "ЧИСТКА КУЛЕРА",0.0,"Чистка куллера", 1000.0,"chistka.png");
        Product product7 = new Product(7, "РЕМОНТ КУЛЛЕРА",0.0,"Ремонт куллера", 1000.0,"remont.png");


        productlist.add(product0);
        productlist.add(product1);
        productlist.add(product2);
        productlist.add(product3);
        productlist.add(product4);
        productlist.add(product5);
        productlist.add(product6);
        productlist.add(product7);

    }

    public ArrayList<Product> getProductlist() {
        return productlist;
    }
}
