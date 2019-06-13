package lesson17.homework4;

public class Solution {
    public static void main(String[] args) {
        String str = "https://www.gromecode.com";

        System.out.println(validate(str));
    }

    public static boolean validate(String address){
        if(address == null)
             return false;

        if(address.isEmpty())
            return false;

        int protocolLength;

        if(address.startsWith("http://"))
            protocolLength = "http://".length();
        else if(address.startsWith("https://"))
            protocolLength = "https://".length();
        else return false;

        if(!address.endsWith(".com") && !address.endsWith(".org") && !address.endsWith(".net"))
            return false;

        String addressBody = address.substring(protocolLength, address.length() - 4);

        if(addressBody.isEmpty())
            return false;

        if(addressBody.startsWith("www.")){
            String addressBodyW = addressBody.substring(4);
            for(char ch : addressBodyW.toCharArray()){
                if(!Character.isLetter(ch)){
                    return false;
                }
            }
        }else {
            for(char ch : addressBody.toCharArray()){
                if(!Character.isLetter(ch)){
                    return false;
                }
            }
        }
        return true;
    }
}
