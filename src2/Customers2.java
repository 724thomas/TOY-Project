package src2;

import src2.menuConfig.MenuConfig2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Customers2 {

    private static Customer2[] customerList = new Customer2[0]; //Arrays of Customer

    public static void showCustomersID() {
        for (int i = 0; i < customerList.length; i++) {
            System.out.println(customerList[i].getUserID());
        }
    }


    public static void addCustomerDataMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("How many customers to input? ");
        int newCustomers = Integer.parseInt(br.readLine());

        for (int i = 0; i < newCustomers; i++) {
            addACustomer(newCustomerData(i));
        }
        MenuConfig2.cdMenu();
    }

    public static Customer2 newCustomerData(int num) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Customer2 customer = new Customer2();
        System.out.println();
        System.out.println("====== Customer " + (num + 1) + " Info. ======");
        System.out.println();

        switch (customerInfoSelectMenu()) {
            case 1:
                System.out.print("Input Customer's Name : ");
                customer.setName(br.readLine());
                newCustomerData(num);
                break;
            case 2:
                System.out.print("Input Customer's ID : ");
                customer.setUserID(br.readLine());
                newCustomerData(num);
                break;
            case 3:
                System.out.print("Input Customer's Spent Time at Your Store:");
                customer.setSpentTime(Integer.parseInt(br.readLine()));
                newCustomerData(num);
                break;
            case 4:
                System.out.print("Input Customer's Total Payment at Your Store:");
                customer.setTotalPay(Integer.parseInt(br.readLine()));
                newCustomerData(num);
                break;
            case 5:
                break;
        }
        return customer;
    }

    public static int customerInfoSelectMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("==============================");
        System.out.println(" 1. Customer Name");
        System.out.println(" 2. Customer ID");
        System.out.println(" 3. Customer Spend Time");
        System.out.println(" 4. Customer Total Pay");
        System.out.println(" 5. Back");
        System.out.println("==============================");
        System.out.print("Choose One: ");
        int choice = Integer.parseInt(br.readLine());

        return choice;
    }

    public static void addACustomer(Customer2 custom1) {
        Customer2[] copied = new Customer2[customerList.length + 1];

        System.arraycopy(customerList, 0, copied, 0, customerList.length);

        copied[customerList.length] = custom1;
        customerList = copied;
    }


    public static void viewCustomerData() {
        System.out.println();
        System.out.println("======= Customer Info. =======");

        for (int i = 0; i < customerList.length; i++) {
            System.out.println("No. " + (i + 1) + " => Customer{"
                    + "serialNO=" + customerList[i].getSerialNo()
                    + ", name=" + customerList[i].getName()
                    + ", userID=" + customerList[i].getUserID()
                    + ", spentTime=" + customerList[i].getSpentTime()
                    + ", totalPay=" + customerList[i].getTotalPay());
        }
    }


    public static void updateCustomerDataMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        viewCustomerData();

        System.out.println();
        System.out.print("Which customer ( 1 ~ " + customerList.length + " )?");
        int index = Integer.parseInt(br.readLine());
        System.out.println();
        switch (customerInfoSelectMenu()) {
            case 1:
                System.out.print("Input Customer's Name: ");
                customerList[index].setName(br.readLine());
                customerInfoSelectMenu();
                break;
            case 2:
                System.out.print("Input Customer's UserID: ");
                customerList[index].setUserID(br.readLine());
                customerInfoSelectMenu();
                break;
            case 3:
                System.out.print("Input Customer's Spent Time at Your Store: ");
                customerList[index].setSpentTime(Integer.parseInt(br.readLine()));
                customerInfoSelectMenu();
                break;
            case 4:
                System.out.print("Input Customer's Total Payment at Your Store: ");
                customerList[index].setTotalPay(Integer.parseInt(br.readLine()));
                customerInfoSelectMenu();
                break;
            case 5:
                MenuConfig2.cdMenu();
                break;
        }
    }

    public static void deleteCustomersDataMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        viewCustomerData();
        System.out.println();
        System.out.print("Which customer ( 1 ~ " + customerList.length + " )?");
        int index = Integer.parseInt(br.readLine());
        deleteCustomerData(index);
        viewCustomerData();
        MenuConfig2.cdMenu();
    }

    public static void deleteCustomerData(int index) {
        Customer2[] copied = new Customer2[customerList.length - 1];
        System.arraycopy(customerList, 0, copied, 0, --index);
        if (customerList.length != index) {
            System.arraycopy(customerList, index + 1, copied, index, customerList.length - index - 1);
        }
        customerList = copied;
        System.out.println();
        System.out.println("Customer Data Deleted Successfully !");
    }
}


