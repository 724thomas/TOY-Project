package src.menuConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// TopMenu, ClassificationParameterMenu, CustomerDataMenu, SummaryMenu, Quit

public class MenuConfig {

    public static void topMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        System.out.println("==============================");
        System.out.println(" 1. Classification Parameter");
        System.out.println(" 2. Customer Data");
        System.out.println(" 3. Summary");
        System.out.println(" 4. Quit");
        System.out.println("==============================");
        System.out.print("Choose One: ");
        int choice =Integer.parseInt(br.readLine());
        switch (choice) {
            case 1: cpMenu();break;
            case 2: cdMenu();break;
            case 3: summaryMenu();break;
            case 4: quit();break;
        }
    }

    public static void cpMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        System.out.println("==============================");
        System.out.println(" 1. Set Parameter");
        System.out.println(" 2. View Parameter");
        System.out.println(" 3. Update Parameter");
        System.out.println(" 4. Back");
        System.out.println("==============================");
        System.out.print("Choose One: ");
        int choice =Integer.parseInt(br.readLine());
        switch (choice) {
            case 1: ClassificationParameter.setParameter(); br.close(); break;
            case 2: ClassificationParameter.viewParameter(); br.close(); break;
            case 3: ClassificationParameter.updateParameter(); br.close(); break;
            case 4: topMenu();break;
        }
    }

    public static void cdMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        System.out.println("==============================");
        System.out.println(" 1. Classification Parameter");
        System.out.println(" 2. Customer Data");
        System.out.println(" 3. Summary");
        System.out.println(" 4. Quit");
        System.out.println("==============================");
        System.out.print("Choose One: ");
        switch (Integer.parseInt(br.readLine())){
            case 1: br.close(); break;
            case 2: br.close(); break;
            case 3: br.close(); break;
            case 4: br.close(); break;
            case 5: MenuConfig.topMenu(); br.close(); break;
        }
    }

    public static void summaryMenu() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        System.out.println("==============================");
        System.out.println(" 1. Summary");
        System.out.println(" 2. Summary (Sorted By Name)");
        System.out.println(" 3. Summary (Sorted By Spent Time)");
        System.out.println(" 4. Summary (Sorted By Total Payment)");
        System.out.println(" 5. Back");
        System.out.println("==============================");
        System.out.print("Choose One: ");
        switch (Integer.parseInt(br.readLine())){
            case 1: br.close(); break;
            case 2: br.close(); break;
            case 3: br.close(); break;
            case 4: br.close(); break;
            case 5: MenuConfig.topMenu(); br.close(); break;
        }
    }

    public static void quit(){
        System.out.println();
        System.out.println("Program Ended");
        System.out.println("By WonJoon Choi");
        System.out.println();
    }

}
