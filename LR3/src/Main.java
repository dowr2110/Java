public class Main {
    public static void main(String[] args) {
        System.out.println("zadanie 1");
        int [] xx =new int[10];
        for (int i=0;i<xx.length;i++)
        {
            xx[i]=i;
        }
        for (int i=0;i<xx.length;i++)
        {
            System.out.println(xx[i]);
        }

        System.out.println("\nzadanie 2");
        int[][] xx2=new int[5][5];
        for (int i=0;i<xx2.length;i++)
        {
            for(int j=0;j<xx2[i].length;j++) {
                xx2[i][j] = i + j;
            }
        }

        for (int i=0;i<xx2.length;i++)
        {
            System.out.println(" ");
            for(int j=0;j<xx2[i].length;j++){
                System.out.println(xx2[i][j]);
            }
        }

        System.out.println("\nzadanie 3");
        int q=500;
        System.out.println("1) "+(~q));//ун отриц
        System.out.println("2) "+(123&456));
        System.out.println("3) "+(789>>>2));
        System.out.println("4) "+(q<<=2));
        System.out.println("5) "+(q^=10));//бит искл

        System.out.println("\nzadanie 4");
        boolean z=true;
        boolean c=false;
        int n=10;
        int m=(n==1)?20:30;//тернарн
        System.out.println("1) "+(z||c));
        System.out.println("2) "+(z&&c));
        System.out.println("3) "+(m));

        System.out.println("\nzadanie 5");
        System.out.println("\nif/else");
        if(n==1)
        {
            System.out.println(20);
        }
        else
            System.out.println(30);

        System.out.println("\nwhile");
        int t = 0;
        while (t <= 5) {
            System.out.println(t);
            t++;
        }

        System.out.println("\ndo while");
        int u = 0;
        do {
            System.out.println(u);
            u++;
        } while (u <= 10);

        System.out.println("\nswitch");
        int sw=3;
        switch (sw) {
            case -1:
                System.out.println("sw -1");
                break;
            case 0:
                System.out.println("sw 0");
            case 1:
            case 2:
                System.out.println("sw 1 or 2");
                break;
            case 3:
                System.out.println("sw 3");
                break;
            default:
                System.out.println("sw default");
                break;
        }




        System.out.println("\nzadanie 6");
        //Airline[] TurkishAirlines = new Airline[3];
        //TurkishAirlines[0] = new Airline();
        //TurkishAirlines[1] = new Airline();
        //TurkishAirlines[2] = new Airline();
        System.out.println(Airline.getCount());

    }
}
class Airline
{
    public static int count=0;

    public Airline()
    {
        count++;
    }
    public static int getCount()
    {
        return count;
    }
}
