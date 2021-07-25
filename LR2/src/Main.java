import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //zadanie 1
        System.out.println("zadanie 1\n");
        int a1=5;
        int b1=10;
        System.out.println("1) "+(Math.pow(a1,2)-Math.pow(b1,2)));
        float a2=5.5f;
        float b2=10.5f;
        System.out.println("2) "+(Math.pow(a2,3)-Math.pow(b2,3)));
        double a3=Math.pow(5.26f,3);
        double b3=Math.pow(12.26f,3);
        System.out.println("3) "+(a3-b3));
        
        //zadanie 2
        //1
        char a='D',b='A';
        int plus=a+b;
        int minus=a-b;
        System.out.println("zadanie 2\n1) "+plus+"\n2) "+minus);
    }
}
