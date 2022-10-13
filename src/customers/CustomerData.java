package src.customers;

import src.exception.InputRangeException;
import src.menuConfig.MenuConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomerData extends Customers{

//    private static final String[] actsOptions = new String[]{"OTHERS","GENERAL","VIP","VVIP"};

    public static void CustomerDataMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n==============================\n 1. Add Customer Data\n 2. View Customer Data\n" + " 3. Update Customer Data\n 4. Delete Customer Data\n 5. Back\n==============================");
        System.out.print("Choose One : ");
        int choice=0;
        try{choice =Integer.parseInt(br.readLine());
            if (choice<1 || choice>5){throw new InputRangeException();}
        } catch (NumberFormatException var1){System.out.println("Invalid Type for Input. Please try again.");CustomerDataMenu();
        } catch (InputRangeException var2){System.out.println("Invalid Input. Please try again.");CustomerDataMenu();
        }
        switch(choice){
            case 1:
                inputNumbersOfAddingCustomersMenu();
                break;
            case 2:
                showCustomerList("View");
                CustomerDataMenu();
                break;
            case 3:
                showCustomerList("Update");
                inputIndexOfUpdatingCustomersMenu();
                break;
            case 4:
                showCustomerList("Deleting");
                inputIndexOfDeletingCustomersMenu();
                break;
            case 5:
                MenuConfig.topMenu();
                break;
        }
    }

    public static void showCustomerList(String act){
        System.out.println("\n======= Customer Info. =======");

        for (int i = 0; i < customerList.length; i++) {
            System.out.println("No. " + (i + 1) + " => Customer{"
                    + "serialNO=" + customerList[i].getSerialNo()
                    + ", name=" + customerList[i].getName()
                    + ", userID=" + customerList[i].getUserID()
                    + ", spentTime=" + customerList[i].getSpentTime()
                    + ", totalPay=" + customerList[i].getTotalPay());
        }
    }




    //*****합치는게 깔끔한데, 나중에 수정하기 어려울것 같음.*****
    public static void inputNumbersOfAddingCustomersMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("How many customers to input? ");
        int newCustomers=0;
        try{newCustomers =Integer.parseInt(br.readLine());
            if (newCustomers<1){throw new InputRangeException();}
        } catch (NumberFormatException var1){System.out.println("Invalid Type for Input. Please try again.");inputNumbersOfAddingCustomersMenu();
        } catch (InputRangeException var2){System.out.println("Invalid Input. Please try again.");inputNumbersOfAddingCustomersMenu();
        }
        int count=1;
        for (int i = 0; i < newCustomers; i++) {
            addACustomer(newCustomerData(new Customer(),count++));
        }
        CustomerDataMenu();
    }
    public static void inputIndexOfUpdatingCustomersMenu() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nWhich customer ( 1 ~ " + customerList.length + " )?\n");
        int customerNo=0;
        try{customerNo =Integer.parseInt(br.readLine());
            if (customerNo<1){throw new InputRangeException();}
        } catch (NumberFormatException var1){System.out.println("Invalid Type for Input. Please try again.");inputIndexOfUpdatingCustomersMenu();
        } catch (InputRangeException var2){System.out.println("Invalid Input. Please try again.");inputIndexOfUpdatingCustomersMenu();
        }
        updateCustomerData(customerNo-1);
    }
    public static void inputIndexOfDeletingCustomersMenu() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nWhich customer ( 1 ~ " + customerList.length + " )?\n");
        int customerNo=0;
        try{customerNo =Integer.parseInt(br.readLine());
            if (customerNo<1 || customerNo> customerList.length){throw new InputRangeException();}
        } catch (NumberFormatException var1){System.out.println("Invalid Type for Input. Please try again.");inputIndexOfDeletingCustomersMenu();
        } catch (InputRangeException var2){System.out.println("Invalid Input. Please try again.");inputIndexOfDeletingCustomersMenu();
        }
        deleteCustomerData(customerNo);
        showCustomerList("Deleting");
    }
}
