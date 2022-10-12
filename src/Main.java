package src;


import src.customers.Customer;
import src.customers.Customers;
import src.menuConfig.MenuConfig;
import src.parameters.Parameters;

import java.io.IOException;
import java.lang.reflect.Parameter;

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
//        MenuConfig.topMenu();
        showResult(Customers.customerList,"OTHERS");
        showResult(Customers.customerList,"VIP");
        testing(Customers.customerList,"VIP");
    }

    public static void testing (Customer[] customers, String group){
        showResult(createGroup(customers,group),group);
    }
    /////////**************************************************************************
    public static Customer[] sortGroup(Customer[] customers, String parameter, int sortOrder){
        Customer tempCustomer = new Customer();
        for (int i=0; i<customers.length-1; i++){
            if (customers[i].getName().compareTo(customers[i+1].getName())<0){
                tempCustomer=customers[i];
            }
        }
        return customers;
    }
    /////////**************************************************************************
    // 기존 Customer[]에서 group의 parameter에 맞게 새로운 Customer[]을 리턴
    public static Customer[] createGroup(Customer[] customers, String group){
        Customer[] tempCustomers = new Customer[customers.length];
        int count=0;
        int minSpentTime=Parameters.getParameter(group,1);
        int minTotalPay=Parameters.getParameter(group,2);;
        for (int i=0; i<customers.length; i++){
            if ((customers[i].getSpentTime()>=minSpentTime) && (customers[i].getTotalPay()>=minTotalPay)){
                System.arraycopy(customers, i, tempCustomers, count++, 1);
            }
        }
        Customer[] groupCustomers = new Customer[count];
        System.arraycopy(tempCustomers, 0, groupCustomers, 0, count);
        return groupCustomers;
    }



    //Customer[]을 보기좋게 출력.
    public static void showResult(Customer[] customers, String group){
        System.out.println("\n==============================");
        System.out.println(group + " group : " + customers.length + " customer(s)");
        if (group!="OTHERS"){
            System.out.println("[Parameter] Parameter{minimumSpentTime="+ Parameters.getParameter(group,1) + ", minimumTotalPay=" + Parameters.getParameter(group,2) + "}");
        }
        System.out.println("------------------------------");
        for (int j=0; j<customers.length; j++){
            System.out.println("No. " + (j+1) + " => Customer{serialNo=" + customers[j].getSerialNo() + ", " + "name=" + customers[j].getName() + ", " + "userID=" + customers[j].getUserID() +", " + "spentTime=" + customers[j].getSpentTime() + ", " + "totalPay=" + customers[j].getTotalPay());
        }
    }

}
