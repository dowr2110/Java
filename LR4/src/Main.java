public class Main {
    public static void main(String[] args) {
        System.out.println("zadanie 1");
        CCC ccc=new CCC();
        CCC ccc1=new CCC(10,5);
        int sum=ccc1.sum();
        int subb=ccc1.ssub(10,7);
        System.out.println(sum);
        System.out.println(subb);

        System.out.println("zadanie 2");
        DDD ddd=new DDD();
        DDD ddd1=new DDD(20,15);
        int sum2=ddd.sum();
        int sum3=ddd1.sum();
        int calc= ddd1.calc();
        System.out.println(sum2);
        System.out.println(sum3);
        System.out.println(calc);
    }
}
class CCC
{
    public int x;
    private int y;

    public CCC()
    {
        x=0;y=0;
    }
    public CCC(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public int sum(){
        return x+y;
    }
    public int ssub(int x,int y){
        return x-y;
    }
    public int getY(){
        return y;
    }
}

class DDD extends CCC{

    public int x;
    private int y;

    public DDD(){
        super(1,1);
    }
    public DDD(int x,int y){
        super(x,y);
    }
    public int sum(){
       return super.sum()+this.x+this.y;
    }
    public int calc(){
        return super.x*super.getY()+(x*y);
    }

}
