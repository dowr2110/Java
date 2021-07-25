import pack1.*;
import pack1.pack11.*;
import pack1.pack11.pack111.*;

public class Main {
    public static void main(String[] args) {

        AAA aaa=new AAA();
        //pack1.AAA aaa=new AAA();-------без этого можно когда используешь import
        System.out.println(aaa.sum(3,5));

        //pack1.pack11.BBB bbb=new pack1.pack11.BBB();
        BBB bbb=new BBB();
        System.out.println(bbb.sub(10,5));

        //pack1.pack11.pack111.CCC ccc= new pack1.pack11.pack111.CCC();
        CCC ccc=new CCC();
        System.out.println(ccc.mult(3,7));

        pack1.AAA1 aaa1=new pack1.AAA1();
        System.out.println(aaa1.negsum(20,4));

        pack1.pack11.pack111.CCC1 ccc1=new pack1.pack11.pack111.CCC1();
        System.out.println(ccc1.segmult(3,5));
    }
}



