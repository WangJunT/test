package com.jy.bingfa.consumeproone;

public class TestOne {
    public static void main(String[] args) {
        Publice publice = new Publice();
        Thread consume = new Thread(new Consume(publice));
        Thread product = new Thread(new Product(publice));
        consume.start();
        product.start();
    }
}
