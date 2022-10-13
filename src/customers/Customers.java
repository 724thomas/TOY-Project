package src.customers;

import src.menuConfig.MenuConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Customers {

    public static Customer[] customerList = new Customer[0]; //Arrays of Customer

    public static void addACustomer(Customer custom1) {
        Customer[] copied = new Customer[customerList.length + 1];
        System.arraycopy(customerList, 0, copied, 0, customerList.length);
        copied[customerList.length] = custom1;
        customerList = copied;
    }
    public static Customer newCustomerData(Customer customer, int count) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n====== Customer " + (count) + " Info. ======\n==============================\n 1. Customer Name\n 2. Customer ID\n 3. Customer Spend Time\n 4. Customer Total Pay\n 5. Back\n==============================\n");
        System.out.print("Choose One: ");
        switch (Integer.parseInt(br.readLine())) {
            case 1:
                System.out.print("Input Customer's Name : ");
                customer.setName(br.readLine());
                newCustomerData(customer,count);
                break;
            case 2:
                System.out.print("Input Customer's ID : ");
                customer.setUserID(br.readLine());
                newCustomerData(customer,count);
                break;
            case 3:
                System.out.print("Input Customer's Spent Time at Your Store:");
                customer.setSpentTime(Integer.parseInt(br.readLine()));
                newCustomerData(customer,count);
                break;
            case 4:
                System.out.print("Input Customer's Total Payment at Your Store:");
                customer.setTotalPay(Integer.parseInt(br.readLine()));
                newCustomerData(customer,count);
                break;
            case 5:
                break;
        }
        return customer;
    }



    public static void updateCustomerData(int index) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("\n====== Customer " + index + " Info. ======\n==============================\n 1. Customer Name\n 2. Customer ID\n 3. Customer Spend Time\n 4. Customer Total Pay\n 5. Back\n==============================");
        System.out.print("Choose One: ");
        switch (Integer.parseInt(br.readLine())) {
            case 1:
                System.out.print("Input Customer's Name: ");
                customerList[index].setName(br.readLine());
                updateCustomerData(index);
                break;
            case 2:
                System.out.print("Input Customer's UserID: ");
                customerList[index].setUserID(br.readLine());
                updateCustomerData(index);
                break;
            case 3:
                System.out.print("Input Customer's Spent Time at Your Store: ");
                customerList[index].setSpentTime(Integer.parseInt(br.readLine()));
                updateCustomerData(index);
                break;
            case 4:
                System.out.print("Input Customer's Total Payment at Your Store: ");
                customerList[index].setTotalPay(Integer.parseInt(br.readLine()));
                updateCustomerData(index);
                break;
            case 5:
                CustomerData.CustomerDataMenu();
                break;
        }
    }


    public static void deleteCustomerData(int index) throws IOException {
        Customer[] copied = new Customer[customerList.length - 1];
        System.arraycopy(customerList, 0, copied, 0, --index);
        if (customerList.length != index) {
            System.arraycopy(customerList, index + 1, copied, index, customerList.length - index - 1);
        }
        customerList = copied;
        System.out.println("\nCustomer Data Deleted Successfully !\n");
        CustomerData.CustomerDataMenu();
    }
}


