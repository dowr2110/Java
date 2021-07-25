import A1.A2.A3.AAA;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        AAA a = new AAA();

        a.setBirthday(100, 2, 21);
        a.setFirstDate(new Date(118, 8, 1));
        a.setName("Dowrangeldi");
        a.setSurname("Atayew");
        a.setUniversity("Belorussian State Technological University");
        a.setFathername("Djemshidovich");

        System.out.println("Name - " + a.getName());
        System.out.println("Surname - " + a.getSurname());
        System.out.println("Birthday - " + a.getBirthday());
        System.out.println("University - " + a.getUniversity());
        System.out.println("First Date - " + a.getFirstDate());
        System.out.println("Father Name - " + a.getFathername());
    }
}
