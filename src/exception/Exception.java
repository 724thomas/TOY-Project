package src.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exception {
    public static int numberException(int value, int rangeFrom, int rangeTo) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int val =value;
        try{
            if (val<rangeFrom || val>rangeTo){
                throw new InputRangeException();
            }
        } catch (NumberFormatException var1) {
            System.out.println("Invalid Type for Input. Please try again.");
            numberException(Integer.parseInt(br.readLine()),rangeFrom,rangeTo);
        } catch (InputRangeException var2){
            System.out.println("Invalid Input. Please try again.");
            numberException(Integer.parseInt(br.readLine()),rangeFrom,rangeTo);
        }
        return val;
    }
}
