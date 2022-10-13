package src.menuConfig;

import src.customers.CustomerData;
import src.customers.Customers;
import src.parameters.ClassificationParameter;
import src.summary.Summary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// TopMenu, ClassificationParameterMenu, CustomerDataMenu, SummaryMenu, Quit

public class MenuConfig {

    public static void topMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        System.out.println("==============================\n 1. Classification Parameter\n 2. Customer Data\n 3. Summary\n 4. Quit\n==============================");
        System.out.print("Choose One: ");
        int choice =Integer.parseInt(br.readLine());
        switch (choice) {
            case 1: ClassificationParameter.classificationParameterMenu();break;
            case 2: CustomerData.CustomerDataMenu();break;
            case 3: Summary.SummaryMenu();break;
            case 4: quit();break;
        }
    }
    public static void quit(){
        System.out.println();
        System.out.println("Program Ended");
        System.out.println("By WonJoon Choi");
        System.out.println();
    }

}
