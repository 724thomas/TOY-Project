import src.Customer;
import src.Customers;

public class Experiment {
    public static void main(String[] args) {



        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


        int[] arr2=deleteCustomers(arr,1);
        for (int i=0; i<arr2.length;i++){
            System.out.println(arr2[i]);
        }

        System.out.println();

//        public Customer[] addCustomers() throws CloneNotSupportedException {
//            custCount++;
//            Customer[] copied = new Customer[custCount];
//            copied = (Customer[]) this.clone();
//            return copied;
//        }

    }

    public static int[] deleteCustomers(int[] original, int place) {
        int[] copied = new int[original.length];

        for (int i = 0; i < place - 1; i++) {
            copied[i] = original[i];
        }

        for (int i = place; i < original.length; i++) {
            copied[i] = original[i];
        }
        return copied;
    }
}
