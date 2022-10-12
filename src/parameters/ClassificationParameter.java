package src.parameters;

import src.menuConfig.MenuConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClassificationParameter extends Parameters{

    public static void classificationParameterMenu() throws IOException {
        System.out.println("1SET, 2VIEW, 3UPDATE, 4BACK");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int act=Integer.parseInt(br.readLine());
        if (act==4){
            MenuConfig.topMenu();}

        switch(act){
            case 1:chooseGroupMenu("SET");break;
            case 2:chooseGroupMenu("VIEW");break;
            case 3:chooseGroupMenu("UPDATE");break;
        }
    }

    public static void chooseGroupMenu(String act) throws IOException {
        System.out.println("** Type 'end', if you want to exit! **");
        System.out.print("Which group? Type ( General  ,  VIP  ,  VVIP ) : ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String group=br.readLine().toUpperCase();
        if (group.equals("END")){classificationParameterMenu();}

        switch (act){
            case "SET":
                chooseParameterMenu(act,group); break;
            case "VIEW":
                showCurrentParameter(group);
                classificationParameterMenu();
                break;
            case "UPDATE":
                chooseParameterMenu(act,group); break;
        }
    }

    public static void chooseParameterMenu(String act, String group) throws IOException{
        System.out.println();
        System.out.println("==============================");
        System.out.println(" 1. Minimum Spent Time");
        System.out.println(" 2. Minimum Total Pay");
        System.out.println(" 3. Back");
        System.out.println("==============================");
        System.out.print("Choose One : ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int parameter=Integer.parseInt(br.readLine());
        if (parameter==3){chooseGroupMenu(act);}

        switch (act){
            case "SET":
                switch(parameter) {
                    case 1:System.out.print("Input Minimum Spent Time: ");break;
                    case 2:System.out.print("Input Minimum Total Pay: ");break;
                }

                if (getParameter(group,parameter)==-1){
                    setParameter(group,parameter,Integer.parseInt(br.readLine()));
                }else{
                    System.out.println(group + " group already exists.");
                    System.out.println();
                    showCurrentParameter(group);
                }
                chooseParameterMenu(act,group);
                break;
            case "UPDATE":
                switch(parameter) {
                    case 1:System.out.print("Input Minimum Spent Time: ");break;
                    case 2:System.out.print("Input Minimum Total Pay: ");break;
                }

                if (getParameter(group,parameter)!=-1){
                    setParameter(group,parameter,Integer.parseInt(br.readLine()));
                    chooseParameterMenu(act,group);
                }else{
                    System.out.println("No parameter. Set the parameter first.");
                    chooseGroupMenu(act);
                }
                break;
        }

    }


    public static void showCurrentParameter(String group){
        System.out.println();
        System.out.println("GroupType : " + group);
        System.out.println("Parameter : "
                + "Parameter{minimumSpentTime=" + getParameter(group,1)
                + ", minimumTotalPay=" +getParameter(group,2));
        System.out.println();
    }
}
