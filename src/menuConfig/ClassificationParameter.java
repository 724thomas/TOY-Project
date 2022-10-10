package src.menuConfig;

import src.Parameters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClassificationParameter {



    public static void setParameter() throws IOException{
        String choice=chooseParameterMenu();
        if (choice.equals("END")){
            MenuConfig.cpMenu();
        }else{
            showParameter(choice);
        }
    }

    public static void viewParameter() throws IOException{
        String choice=chooseParameterMenu();
        if (choice.equals("END")){
            MenuConfig.cpMenu();
        }else{
            showParameter(choice);
            viewParameter();
        }
    }

    public static void updateParameter() throws IOException{
        String choice=chooseParameterMenu();
        if (choice.equals("END")){
            MenuConfig.cpMenu();
        }else{
            whichParameter(choice);
        }
    }

    public static void whichParameter(String parameter) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("==============================");
        System.out.println(" 1. Minimum Spent Time");
        System.out.println(" 2. Minimum Total Pay");
        System.out.println(" 3. Back");
        System.out.println("==============================");
        System.out.print("Choose One: ");
        int choice = Integer.parseInt(br.readLine());
        switch (choice) {
            case 1:
                setMinimumSpentTime(parameter);
                updateParameter();
                break;
            case 2:
                setMinimumTotalPay(parameter);
                updateParameter();
                break;
            case 3:
                chooseParameterMenu();
                break;
        }
    }




    public static void setMinimumSpentTime(String parameter) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.print("Input Minimum Spent Time : ");
        System.out.println();
        int time=Integer.parseInt(br.readLine());
        switch (parameter){
            case "GENERAL":
                Parameters.setGeneralMinimumSpentTime(time);
                break;
            case "VIP":
                Parameters.setVipMinimumSpentTime(time);
                break;
            case "VVIP":
                Parameters.setVvipMinimumSpentTime(time);
        }
        whichParameter(parameter);
    }
    public static void setMinimumTotalPay(String parameter) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.print("Input Minimum Total Pay : ");
        System.out.println();
        int money=Integer.parseInt(br.readLine());
        switch (parameter){
            case "GENERAL":
                Parameters.setGeneralMinimumTotalPay(money);
                break;
            case "VIP":
                Parameters.setVipMinimumTotalPay(money);
                break;
            case "VVIP":
                Parameters.setVvipMinimumTotalPay(money);
        }
        whichParameter(parameter);
    }





    public static String chooseParameterMenu() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        System.out.println("Which group? Type ( General  ,  VIP  ,  VVIP ) ");
        System.out.println("** Type 'end', if you want to exit! **");
        System.out.println();

        return br.readLine().toUpperCase();
    }
    public static void showParameter(String parameter){
        System.out.println("Group Type General :  "+ parameter);
        System.out.println();
        System.out.println("Current Parameter :");
        int minTime =0 ;
        int minPay = 0;
        switch (parameter){
            case "GENERAL":
                minTime=Parameters.getGeneralMinimumSpentTime();
                minPay=Parameters.getGeneralMinimumTotalPay();
                break;
            case "VIP":
                minTime=Parameters.getVipMinimumSpentTime();
                minPay=Parameters.getVipMinimumTotalPay();
                break;
            case "VVIP":
                minTime=Parameters.getVvipMinimumSpentTime();
                minPay=Parameters.getVvipMinimumTotalPay();
                break;
            default:
                break;
        }
        System.out.println("1. Minimum Time Spent : " + minTime);
        System.out.println("2. Minimum Total Amount of Payment : " + minPay);
        System.out.println();
    }


}
