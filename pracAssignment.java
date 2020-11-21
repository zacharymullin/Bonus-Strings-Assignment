import java.util.Scanner;

public class pracAssignment
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter PPAP sentence:");
        System.out.println(makePPAP(sc.nextLine()));
        System.out.println("Enter palindrome:");
        //sc.nextLine();
        System.out.println(palindrome(sc.nextLine()));
        //System.out.println(palindrome("test"));
        System.out.println("Enter decimal integer for conversion to binary:");
        System.out.println(binary(sc.nextInt()));
        System.out.println("Enter English phrase for conversion to Pig Latin:");
        sc.nextLine();
        System.out.println(pigLatin(sc.nextLine()));
    }

    public static String makePPAP(String str){
        int lastPos = 0;
        String obj1 = "";
        String obj2 = "";
        if(str.substring(0,9).equals("I have a ")){
            for(int i = 0; str.charAt(9+i) != ','; i++){
                obj2 = obj2 + str.charAt(9+i);
                lastPos = i+9;
            }
        }
        if(str.substring(lastPos+1,lastPos+12).equals(", I have a ")){
            for(int i = 0; lastPos+12+i < str.length(); i++){
                obj1 = obj1 + str.charAt(12+lastPos+i);
            }
        }
        return "Uh! " + obj1.substring(0,1).toUpperCase() + obj1.substring(1,obj1.length()) + " " + obj2 + ".";
    }

    public static boolean palindrome(String str){
        String pal = "";
        String origConverted = "";
        for(int i = str.length()-1; i >= 0; i--){
            if(Character.isLetter(str.charAt(i)))pal = pal + str.charAt(i);
        }
        for(int i = 0; i < str.length(); i++){
            if(Character.isLetter(str.charAt(i))) origConverted = origConverted + str.charAt(i);
        }
        String ret = pal.toLowerCase();
        //System.out.println(pal);
        return ret.equals(origConverted.toLowerCase());

    }

    public static String binary(int x){
        String ret = "";
        String retRev = "";
        while(x != 0){
            ret = ret + Integer.toString(x % 2);
            x = x / 2;
        }
        for(int i = ret.length() - 1; i >= 0; i--){
            retRev = retRev + ret.charAt(i);
        }
        return retRev;
    }

    public static String pigLatin(String str){
        //System.out.println(str);
        String ret = "";
        int end = str.indexOf(" ");
        while (str.length() > 0){
            if(end > 0){
                if(end > 2) ret = ret + str.substring(1, end) + str.substring(0,1) + "ay";
                else ret = ret + str.substring(0,end);
                ret = ret + " ";
                str = str.substring(end+1);
                end = str.indexOf(" ");
            }
            else{
                if(str.length() > 2)ret = ret + str.substring(1,str.length()) + str.substring(0,1) + "ay";
                else ret = ret + str;
                str = "";
            }
        }
        return ret;
    }
}
