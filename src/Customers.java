package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Customers {

    private Customer[] customers;
    private static int custCount=0;

    public Customers(Customer[] customers) {
        this.customers = customers;
    }


    public static int customerInfoSelectMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("==============================");
        System.out.println(" 1. Customer Name");
        System.out.println(" 2. Customer ID");
        System.out.println(" 3. Customer Spend Time");
        System.out.println(" 4. Customer Total Pay");
        System.out.println("==============================");
        System.out.print("Choose One: ");
        int choice= Integer.parseInt(br.readLine());
        return choice;
    }

    public Customer[] addACustomerData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Customer customer= new Customer();
        switch (customerInfoSelectMenu()) {
            case 1:
                System.out.print("Input Customer's Name : ");
                customer.setName(br.readLine());
                addACustomerData();
                break;
            case 2:
                System.out.print("Input Customer's ID : ");
                customer.setUserID(br.readLine());
                addACustomerData();
                break;
            case 3:
                System.out.print("Input Customer's Spent Time at Your Store:");
                customer.setSpentTime(Integer.parseInt(br.readLine()));
                addACustomerData();
                break;
            case 4:
                System.out.print("Input Customer's Total Payment at Your Store:");
                customer.setTotalPay(Integer.parseInt(br.readLine()));
                addACustomerData();
                break;
            case 5:
                break;
        }
        return addACustomer(customers,customer);
    }



    public static Customer[] addACustomer(Customer[] original, Customer customer) throws IOException {
        Customer[] copied = new Customer[original.length+1];

        for (int i=0; i< original.length; i++){
            copied[i].setSerialNo(original[i].getSerialNo());
            copied[i].setName(original[i].getName());
            copied[i].setUserID(original[i].getUserID());
            copied[i].setSpentTime(original[i].getSpentTime());
            copied[i].setTotalPay(original[i].getTotalPay());
        }

        copied[original.length+1]= customer;

        return copied;
    }

    public void changeCustomerInfo(int place) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        //CustomerInfo Println
        System.out.println("Which Customer? " + this.customers.length);
        customers[place].setTotalPay(1);

    }

    public static Customer[] deleteCustomers(Customer[] original, int place) throws CloneNotSupportedException {
        if (original.length==0){
            System.out.println();
            System.out.println("There is no existing customer data that can be deleted.");
            System.out.println("Please add customers.");
            System.out.println();
            return null;
        }else {
            custCount--;
            Customer[] copied = new Customer[original.length-1];

            for (int i=0; i<place-1; i++){
                copied[i].setSerialNo(original[i].getSerialNo());
                copied[i].setName(original[i].getName());
                copied[i].setUserID(original[i].getUserID());
                copied[i].setSpentTime(original[i].getSpentTime());
                copied[i].setTotalPay(original[i].getTotalPay());
            }

            for (int i=place; i< original.length; i++){
                copied[i-1].setSerialNo(original[i].getSerialNo());
                copied[i-1].setName(original[i].getName());
                copied[i-1].setUserID(original[i].getUserID());
                copied[i-1].setSpentTime(original[i].getSpentTime());
                copied[i-1].setTotalPay(original[i].getTotalPay());
            }
            System.out.println("Customer Data Deleted Successfully ! ");
            return copied;
        }
    }



//    public static void customerInfoMenu() throws IOException {
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//
//
//        System.out.println();
//        System.out.println("==============================");
//        System.out.println(" 1. Customer Name");
//        System.out.println(" 2. Customer ID");
//        System.out.println(" 3. Customer Spend Time");
//        System.out.println(" 4. Customer Total Pay");
//        System.out.println("==============================");
//        System.out.print("Choose One: ");
//        int choice= Integer.parseInt(br.readLine());
//        switch (choice){
//            case 1:
//                addACustomer();
//
//        }
//    }
}



