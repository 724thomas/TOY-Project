package src;

import src.menuConfig.MenuConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Customers {

    private static Customer[] customerList = new Customer[0]; //Arrays of Customer

    public static void showCustomersID(){
        for (int i = 0; i< customerList.length; i++){
            System.out.println(customerList[i].getUserID());
        }
    }


    public static void addCustomerDataMenu() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        System.out.print("How many customers to input? ");
        int newCustomers = Integer.parseInt(br.readLine());

        for (int i=0; i<newCustomers; i++){
            addACustomer(newCustomerData(i));
        }
        MenuConfig.cdMenu();
    }
    public static Customer newCustomerData(int num) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Customer customer= new Customer();
        System.out.println();
        System.out.println("====== Customer " + (num+1) + " Info. ======");
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
        int choice= Integer.parseInt(br.readLine());
        return choice;
    }
    public static void addACustomer(Customer custom1) {
        Customer[] copied = new Customer[customerList.length+1];

        System.arraycopy(customerList, 0, copied, 0, customerList.length);


//        for (int j = 0; j< customerList.length; j++){
//            copied[j]= new Customer(
//                    customerList[j].getName(),
//                    customerList[j].getUserID(),
//                    customerList[j].getSpentTime(),
//                    customerList[j].getTotalPay());
//        }
        copied[customerList.length]= custom1;
        customerList = copied;
    }



    public static void viewCustomerData() throws IOException {
        System.out.println();
        System.out.println("======= Customer Info. =======");

        for (int i=0; i<customerList.length; i++){
            System.out.println("No. " + (i+1) + " => Customer{"
                    +"serialNO=" + customerList[i].getSerialNo()
                    +", name=" + customerList[i].getName()
                    +", userID=" + customerList[i].getUserID()
                    +", spentTime=" + customerList[i].getSpentTime()
                    +", totalPay=" + customerList[i].getTotalPay());
        }
    }






    public static void updateCustomerDataMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        viewCustomerData();

        System.out.println();
        System.out.print("Which customer ( 1 ~ " + customerList.length + " )?");
        int index = Integer.parseInt(br.readLine());
        System.out.println();
        switch(customerInfoSelectMenu()){
            case 1:
                System.out.print("Input Customer's Name: ");
                customerList[index].setName(br.readLine());
            case 2:
                System.out.print("Input Customer's UserID: ");
                customerList[index].setUserID(br.readLine());
            case 3:
                System.out.print("Input Customer's Spent Time at Your Store: ");
                customerList[index].setSpentTime(Integer.parseInt(br.readLine()));
            case 4:
                System.out.print("Input Customer's Total Payment at Your Store: ");
                customerList[index].setTotalPay(Integer.parseInt(br.readLine()));
            case 5:
                MenuConfig.cdMenu();
        }
    }


    public void changeCustomerInfo(int place) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        //CustomerInfo Println
        System.out.println("Which Customer? " + customerList.length);
        customerList[place].setTotalPay(1);

    }

    public static Customer[] deleteCustomers(Customer[] original, int place) throws CloneNotSupportedException {
        if (original.length==0){
            System.out.println();
            System.out.println("There is no existing customer data that can be deleted.");
            System.out.println("Please add customers.");
            System.out.println();
            return null;
        }else {
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




