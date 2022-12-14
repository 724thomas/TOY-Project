package src.summary;

import src.customers.Customer;
import src.customers.Customers;
import src.exception.InputEmptyException;
import src.exception.InputRangeException;
import src.menuConfig.MenuConfig;
import src.parameters.Parameters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Summary extends Customers {

    private static final String[] groups = new String[]{"OTHERS","GENERAL","VIP","VVIP"};
    private static final String[] sortOptions = new String[]{"ASCENDING","DESCENDING","END"};

    public static void SummaryMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n==============================\n 1. Summary\n 2. Summary (Sorted By Name)\n 3. Summary (Sorted By Spent Time)\n 4. Summary (Sorted By Total Payment)\n 5. Back\n==============================\nChoose One: ");
        int choice=0;
        try{choice =Integer.parseInt(br.readLine());
            if (choice<1 || choice>5){throw new InputRangeException();}
        } catch (NumberFormatException var1){System.out.println("Invalid Type for Input. Please try again.");SummaryMenu();
        } catch (InputRangeException var2){System.out.println("Invalid Input. Please try again.");SummaryMenu();
        }
        switch (choice){
            case 1:
                for (int i=0; i<groups.length; i++){showResult(createGroup(Customers.customerList,groups[i]),groups[i]);}
                SummaryMenu();
                break;
            case 2:
                chooseSortOrderMenu("NAME");
                SummaryMenu();
                break;
            case 3:
                chooseSortOrderMenu("SPENTTIME");
                SummaryMenu();
                break;
            case 4:
                chooseSortOrderMenu("TOTALPAY");
                SummaryMenu();
                break;
            case 5:
                MenuConfig.topMenu();
                break;
        }
    }
//*****************************************************************************************************************
    public static void chooseSortOrderMenu(String parameter) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n** Type 'end', if you want to exit! **\n");
        System.out.println("Which order? Type ( ASCENDING , DESCENDING ) : ");
        String sortOrder = "";
        try{
            sortOrder = br.readLine().toUpperCase();
            if (sortOrder==null){throw new NullPointerException();}
            if (sortOrder.equals("")){throw new InputEmptyException();}
            for (int i = 0; i< sortOptions.length; i++){
                if (sortOrder.equals(sortOptions[i])){}else{throw new InputRangeException();}}}
        catch (NullPointerException var2) {System.out.println("Null Input. Please input something."); chooseSortOrderMenu(parameter);}
        catch (InputEmptyException var3) {System.out.println("Empty Input. Please input something.");chooseSortOrderMenu(parameter);}
        catch (InputRangeException var4) {System.out.println("Invalid Input. Please try again.");chooseSortOrderMenu(parameter);}
        if (sortOrder.equals("END")){
            SummaryMenu();
        }else{
            for (int i=0; i<groups.length; i++){showResult(sortGroup(createGroup(Customers.customerList,groups[i]),parameter,sortOrder),groups[i]);}}
    }
    //*****************************************************************************************************************
    public static Customer[] sortGroup(Customer[] customers, String parameter, String sortOrder){
        //Arrays.sort(Customers.customerList, Comparator.comparing(Customer::getName).reversed().thenComparing(Customer::getTotalPay));
        if (sortOrder.equals("ASCENDING")) {
            switch (parameter) {
                case "NAME":
                    Arrays.sort(customers, Comparator.comparing(Customer::getName).thenComparing(Customer::getSerialNo));
                    break;
                case "SPENTTIME":
                    Arrays.sort(customers, Comparator.comparing(Customer::getSpentTime).thenComparing(Customer::getSerialNo));
                    break;
                case "TOTALPAY":
                    Arrays.sort(customers, Comparator.comparing(Customer::getTotalPay).thenComparing(Customer::getSerialNo));
                    break;
            }
        }else if(sortOrder.equals("DESCENDING")){
            switch(parameter) {
                case "NAME":
                    Arrays.sort(customers, Comparator.comparing(Customer::getName).reversed().thenComparing(Customer::getSerialNo));
                    break;
                case "SPENTTIME":
                    Arrays.sort(customers, Comparator.comparing(Customer::getSpentTime).reversed().thenComparing(Customer::getSerialNo));
                    break;
                case "TOTALPAY":
                    Arrays.sort(customers, Comparator.comparing(Customer::getTotalPay).reversed().thenComparing(Customer::getSerialNo));
                    break;
            }
        }
        return customers;
    }

    // ?????? Customer[]?????? group??? parameter??? ?????? ????????? Customer[]??? ??????
    public static Customer[] createGroup(Customer[] customers, String group){
        Customer[] tempCustomers = new Customer[customers.length];
        int count=0;

        int minSpentTime=Integer.MIN_VALUE;
        int minTotalPay=Integer.MIN_VALUE;
        int maxSpentTime=0;
        int maxTotalPay=0;
        switch(group){
            case "OTHERS":
                minSpentTime=0;
                minTotalPay=0;
                maxSpentTime= Parameters.getParameter(groups[1],1);
                maxTotalPay=Parameters.getParameter(groups[1],2);
                break;
            case "GENERAL":
                minSpentTime=Parameters.getParameter(groups[1],1);
                minTotalPay=Parameters.getParameter(groups[1],2);
                maxSpentTime=Parameters.getParameter(groups[2],1);
                maxTotalPay=Parameters.getParameter(groups[2],2);
                break;
            case "VIP":
                minSpentTime=Parameters.getParameter(groups[2],1);
                minTotalPay=Parameters.getParameter(groups[2],2);
                maxSpentTime=Parameters.getParameter(groups[3],1);
                maxTotalPay=Parameters.getParameter(groups[3],2);
                break;
            case "VVIP":
                minSpentTime=Parameters.getParameter(groups[3],1);
                minTotalPay=Parameters.getParameter(groups[3],2);
                maxSpentTime=Integer.MAX_VALUE;
                maxTotalPay=Integer.MAX_VALUE;
                break;
            default:
                System.out.println("Unknown group type");
                break;
        }

        for (int i=0; i<customers.length; i++){
            if (((customers[i].getSpentTime()>=minSpentTime) && (customers[i].getSpentTime()<maxSpentTime)) && ((customers[i].getTotalPay()>=minTotalPay) || (customers[i].getTotalPay()<maxTotalPay))){
                System.arraycopy(customers, i, tempCustomers, count++, 1);
            }
        }
        Customer[] groupCustomers = new Customer[count];
        System.arraycopy(tempCustomers, 0, groupCustomers, 0, count);
        return groupCustomers;
    }



    //Customer[]??? ???????????? ??????.
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
