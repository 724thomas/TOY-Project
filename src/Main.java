package src;


import src.customers.Customer;
import src.customers.Customers;
import src.menuConfig.MenuConfig;
import src.parameters.Parameters;
import src.summary.Summary;

import java.io.IOException;
import java.lang.reflect.Parameter;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        Parameters.setParameter("GENERAL",1,30);
        Parameters.setParameter("GENERAL",2,30);
        Parameters.setParameter("VIP",1,50);
        Parameters.setParameter("VIP",2,50);
        Parameters.setParameter("VVIP",1,70);
        Parameters.setParameter("VVIP",2,70);

        Customers.addACustomer(new Customer("aaa","asdf",10,10));
        Customers.addACustomer(new Customer("bbb","sdfg",20,30));
        Customers.addACustomer(new Customer("eee","dfgh",30,40));
        Customers.addACustomer(new Customer("ggg","fghj",40,40));
        Customers.addACustomer(new Customer("ddd","ghjk",49,51));
        Customers.addACustomer(new Customer("ddd","hjkl",51,49));
        Customers.addACustomer(new Customer("fff","qwer",60,60));
        Customers.addACustomer(new Customer("iii","wert",70,70));
        Customers.addACustomer(new Customer("nnn","erty",80,80));
        Customers.addACustomer(new Customer("mmm","rtyu",90,90));

        MenuConfig.topMenu();
    }


}
