public class ExceptionAAA1 extends Exception{

    @Override
    public String getMessage() {
        return super.getMessage();
    }//opisanie isklyuceniya

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }//otobrozit trassu steka

    @Override
    public String toString() {
        return "Ex AAA1" + super.toString();
    }//preobrazovat v stroke
}
