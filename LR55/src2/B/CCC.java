package B;

import A.*;
public class CCC {
    public int a;

    public CCC(int a){
        this.a=a;
    }

    public void output(){
        System.out.println(this.getClass()+" "+this.a);
    }

    A.AAA aaa= new AAA(99);
    public void outA()
    {
    System.out.println("был создан обьект и вызов метода этого обьекта ");
    aaa.output();
    }
}
