package src;

public class Parameters {

    //General -> Vip -> VVIP
    private static int[] generalParameter = new int[]{0,0};
    private static int[] vipParameter = new int[]{0,0};
    private static int[] vvipParameter = new int[]{0,0};

    private static int generalMinimumSpentTime=-1;
    private static int generalMinimumTotalPay=-1;

    private static int vipMinimumSpentTime=-1;
    private static int vipMinimumTotalPay=-1;

    private static int vvipMinimumSpentTime=-1;
    private static int vvipMinimumTotalPay=-1;


    public static int getGeneralParameter(int parameter){
        return generalParameter[parameter-1];
    }
    public static void setGeneralParameter(int parameter, int value){
        generalParameter[parameter-1]=value;
    }

    public static int getVipParameter(int parameter){
        return vipParameter[parameter-1];
    }
    public static void setVipParameter(int parameter, int value){
        vipParameter[parameter-1]=value;
    }
    public static int getVvipParameter(int parameter){
        return vvipParameter[parameter-1];
    }
    public static void setVvipParameter(int parameter, int value){
        vvipParameter[parameter-1]=value;
    }


    public static int getGeneralMinimumSpentTime() {
        return generalMinimumSpentTime;
    }

    public static void setGeneralMinimumSpentTime(int generalMinimumSpentTime) {
        Parameters.generalMinimumSpentTime = generalMinimumSpentTime;
    }

    public static int getGeneralMinimumTotalPay() {
        return generalMinimumTotalPay;
    }

    public static void setGeneralMinimumTotalPay(int generalMinimumTotalPay) {
        Parameters.generalMinimumTotalPay = generalMinimumTotalPay;
    }

    public static int getVipMinimumSpentTime() {
        return vipMinimumSpentTime;
    }

    public static void setVipMinimumSpentTime(int vipMinimumSpentTime) {
        Parameters.vipMinimumSpentTime = vipMinimumSpentTime;
    }

    public static int getVipMinimumTotalPay() {
        return vipMinimumTotalPay;
    }

    public static void setVipMinimumTotalPay(int vipMinimumTotalPay) {
        Parameters.vipMinimumTotalPay = vipMinimumTotalPay;
    }

    public static int getVvipMinimumSpentTime() {
        return vvipMinimumSpentTime;
    }

    public static void setVvipMinimumSpentTime(int vvipMinimumSpentTime) {
        Parameters.vvipMinimumSpentTime = vvipMinimumSpentTime;
    }

    public static int getVvipMinimumTotalPay() {
        return vvipMinimumTotalPay;
    }

    public static void setVvipMinimumTotalPay(int vvipMinimumTotalPay) {
        Parameters.vvipMinimumTotalPay = vvipMinimumTotalPay;
    }
}
