public class Main {
    public static void main(String[] args) {
        try {
                AAA aaa=new AAA(0);
                aaa.methode(0);
        }
        catch (ExceptionAAA1 e)
        {
            System.out.println(e.toString()+" -----Параметр конструктора NULL");
        }
        catch (ExceptionAAA2 e)
        {
            System.out.println(e.toString()+" ----- Параметр метода равен 0");
        }
        catch (ExceptionAAA3 e)
        {
            System.out.println(e.toString()+" ----- Параметр метода меньше 0");
        }
        finally {

        }
    }
}
