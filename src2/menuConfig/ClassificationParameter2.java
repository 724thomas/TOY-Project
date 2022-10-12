package src2.menuConfig;

import src2.Parameters2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClassificationParameter2 {



    public static void setParameterMenu() throws IOException{
        setChooseGroupMenu();
    }

    public static void setChooseGroupMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        System.out.println("** Type 'end', if you want to exit! **");
        System.out.print("Which group? Type ( General  ,  VIP  ,  VVIP ) : ");
        String group=br.readLine().toUpperCase();
        System.out.println();

        if (group.equals("END")){
            MenuConfig2.cpMenu();}
        else{setChooseParameterMenu(group);}
    }

    public static void setChooseParameterMenu(String group) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("==============================");
        System.out.println(" 1. Minimum Spent Time");
        System.out.println(" 2. Minimum Total Pay");
        System.out.println(" 3. Back");
        System.out.println("==============================");
        System.out.print("Choose One : ");
        int parameter = Integer.parseInt(br.readLine());

        switch (parameter){
            case 1:
                System.out.print("Input Minimum Spent time : ");
                Parameters2.setParameter(group,parameter,Integer.parseInt(br.readLine()));
                setChooseParameterMenu(group);
                break;
            case 2:
                System.out.print("Input Minimum Total Pay : ");
                Parameters2.setParameter(group,parameter,Integer.parseInt(br.readLine()));
                setChooseParameterMenu(group);
                break;
            case 3:
                setChooseGroupMenu();
                break;
        }

    }
}
