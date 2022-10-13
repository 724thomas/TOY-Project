package src.customers;

public class Customer {

    private static int count=0;

    private int serialNo;
    private String name;
    private String userID;
    private int spentTime;
    private int totalPay;


    public Customer(){
        this.serialNo=++count;
    }

    public Customer(String name, String userID, int spentTime, int totalPay) {
        this.serialNo=++count;
        this.name = name;
        this.userID = userID;
        this.spentTime = spentTime;
        this.totalPay = totalPay;
    }



    public static int getCount() {
        return count;
    }
    public static void setCount(int count) {
        Customer.count = count;
    }
    public int getSerialNo() {
        return serialNo;
    }
    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public int getSpentTime() {
        return spentTime;
    }
    public void setSpentTime(int spentTime) {
        this.spentTime = spentTime;
    }
    public int getTotalPay() {
        return totalPay;
    }
    public void setTotalPay(int totalPay) {
        this.totalPay = totalPay;
    }
}
