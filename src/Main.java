package src;


import src.menuConfig.MenuConfig;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Customers.addACustomer(new Customer("asasdfdf","sdf",10,10));
        Customers.addACustomer(new Customer("asdf","sdasdff",20,30));
        Customers.addACustomer(new Customer("asdfdf","sdfer",30,40));
        Customers.addACustomer(new Customer("asdfdf","sdfer",40,40));
        Customers.addACustomer(new Customer("asdfdf","sdfer",50,40));

        MenuConfig.topMenu();

    }
}
