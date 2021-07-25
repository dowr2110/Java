package A;

public class AAA {

    public int a;

    public AAA(int a){
        this.a=a;
    }

    public void output(){
        System.out.println(this.getClass()+" "+this.a);
    }
}
