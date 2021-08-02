package com.jy.aop;

public class Account {
    public int balance;
    public boolean pay(int amount) {
        if (balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }
}
