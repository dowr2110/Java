import A.A2.A3.*;//Zadanie 2
import A.*;//Zadanie 3
import A.A2.*;//Zadanie 4
import A.A2.A3.*;//Zadanie 4
import B.B2.CCC2;
import B.CCC;

public class Main {
    public static void main(String[] args) {

        System.out.println("Zadanie 1");

        A.AAA aaa =new A.AAA(5);
        aaa.output();

        A.A2.BBB2 bbb2 =new A.A2.BBB2(10);
        bbb2.output();

        A.A2.AAA2 aaa2 =new A.A2.AAA2(15);
        aaa2.output();

        A.A2.A3.AAA3 aaa3 =new A.A2.A3.AAA3(20);
        aaa3.output();

        A.A2.A3.BBB3 bbb3 =new A.A2.A3.BBB3(25);
        bbb3.output();

        System.out.println("Zadanie 6");

        CCC ccc =new CCC(45);
        ccc.outA();

        System.out.println("Zadanie 7");

        CCC2 ccc2=new CCC2(88);
        ccc2.output2();

    }
}
