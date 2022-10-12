package src.parameters;

public class Parameters {

    //General -> Vip -> VVIP
    private static int[] generalParameter = new int[]{-1,-1};
    private static int[] vipParameter = new int[]{-1,-1};
    private static int[] vvipParameter = new int[]{-1,-1};


    public static void setParameter(String group, int parameter, int value){
        switch (group){
            case "GENERAL":
                generalParameter[parameter-1]=value;
            case "VIP":
                vipParameter[parameter-1]=value;
            case "VVIP":
                vvipParameter[parameter-1]=value;
        }
    }

    public static int getParameter(String group, int parameter){
        switch (group) {
            case "GENERAL":
                return generalParameter[parameter - 1];
            case "VIP":
                return vipParameter[parameter - 1];
            case "VVIP":
                return vvipParameter[parameter - 1];
            default:
                return -1;
        }
    }
}
