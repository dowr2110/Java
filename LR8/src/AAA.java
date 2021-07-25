public class AAA {
    public AAA (Integer a) throws ExceptionAAA1{
        if (a == null) throw new ExceptionAAA1();
    }

    public void methode (int a) throws ExceptionAAA2, ExceptionAAA3 {

        if (a == 0) throw new ExceptionAAA2();
        if (a < 0) throw new ExceptionAAA3();
    }
}
