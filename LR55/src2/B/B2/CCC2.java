package B.B2;
import A.*;

public class CCC2 extends A.A2.AAA2 {
    public int a;


    public CCC2(int a){
        super(1110);
        this.a=a;
    }

    public void output(){
        System.out.println(this.getClass()+" "+this.a);
    }

    public void output2(){
        System.out.println("использован унаследованный метод предка ");
        super.output();
    }
}
