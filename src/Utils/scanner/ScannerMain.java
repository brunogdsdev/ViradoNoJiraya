package Utils.scanner;

import java.util.Scanner;

public class ScannerMain {
    public static void main(String[] args) {
        String text = "Bruno,Gaby,Tony,true,200";
        Scanner scan = new Scanner(text);

        scan.useDelimiter(",");
        while(scan.hasNext()){
            if(scan.hasNextInt()){
                int i = scan.nextInt();
                System.out.println("Int: "+ i);
            }else if(scan.hasNextBoolean()){
                boolean b = scan.nextBoolean();
                System.out.println("Bool: "+b);
            }else{
                System.out.println(scan.next());
            }
        }
    }
}
