package src2;


import src2.menuConfig.MenuConfig2;

import java.io.IOException;

public class Main2 {
    public static void main(String[] args) throws IOException {

        Customers2.addACustomer(new Customer2("asasdfdf","sdf",10,10));
        Customers2.addACustomer(new Customer2("asdf","sdasdff",20,30));
        Customers2.addACustomer(new Customer2("asdfdf","sdfer",30,40));
        Customers2.addACustomer(new Customer2("asdfdf","sdfer",40,40));
        Customers2.addACustomer(new Customer2("asdfdf","sdfer",50,40));

        MenuConfig2.topMenu();

    }
}
