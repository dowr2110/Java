public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------------3");
        System.out.println("\"01234567\".lenght = " + "01234567".length());

        System.out.println("--------------------------------------4");
        String s06 = new String ("01234567");
        for (int i = 0; i < s06.length(); i++) {
            System.out.print(s06.charAt(i)
                    + ((i < s06.length() - 1) ? "-" : ""));//izvlecenie simvolov
        }
        System.out.println("");
        char[] cs1 = new char[6-2];
        s06.getChars(2, 6, cs1, 0);
        for (int i = 0; i < cs1.length; i++) {
            System.out.print(cs1[i] + ((i < cs1.length - 1) ? "-": ""));
        }

        System.out.println();
        System.out.println("--------------------------------------5");
        String s07 = new String("01324567");
        String s08 = new String("01324567");
        System.out.println( "(s07 == s08) = " + (s07 == s08));
        System.out.println( "(s07 == \"01234567\") = " + (s07 == "01234567"));
        System.out.println( "s07.equals(s08)" + s07.equals(s08));
        String s09 = s08;
        System.out.println( "(s08 == s09) = " + (s08 == s09));

        System.out.println("--------------------------------------6");
        String s10 = new String ("Человека невозможно чему-нибудь научить, уго можно убедить");
        System.out.println(s10.indexOf('j'));
        System.out.println(s10.indexOf('о'));
        System.out.println(s10.lastIndexOf('о'));
        System.out.println(s10.indexOf('о', 5));
        System.out.println(s10.lastIndexOf('о', 5));
        System.out.println(s10.lastIndexOf('о', 14));

        System.out.println("--------------------------------------7");
        String s11 = new String ("Лучший вид на этот город,если сесть в бомбардировщик");
        System.out.println(s11.substring(26));//birinji 26 simvoly ayyrya
        System.out.println(s11.substring(26,30));

        System.out.println("--------------------------------------8");
        String s12 = new String ("Оффтопик - любое сетевое сообщение " +
                "выходящее за рамки ранее установленной темы");
        System.out.println(s12.replace('ф', 'f'));
        System.out.println(s12.toUpperCase());
        System.out.println(s12.toLowerCase());

        System.out.println("--------------------------------------9");
        StringBuffer s15 = new StringBuffer(100);
        s15.append("В городе Сочи темные ночи");
        System.out.println("s15.length() = " + s15.length());
        System.out.println("s15.capacity() = " + s15.capacity());//gowrum
        s15.insert(9, "и теплые ");
        System.out.println(s15);
        System.out.println("s15.length() = " + s15.length());
        System.out.println("s15.capacity() = " + s15.capacity());
        s15.delete(21, 30);
        System.out.println(s15);
        s15.ensureCapacity(200);
        System.out.println("s15.capacity() = " + s15.capacity());
        String s16 = s15.toString();

        System.out.println("--------------------------------------11");
        Planet planet = Planet.Eart;

        switch (planet)
        {
            case Mercury:System.out.println("Mercury");break;
            case Jupiter:System.out.println("Jupiter");break;
            case Eart:System.out.println("Eart");break;
            default:System.out.println("default");
        }

        System.out.println("--------------------------------------12");//расширенный
        System.out.println(planet.gravity);
        System.out.println(planet.mass);
        System.out.println(planet.raduis);

    }

    //11
    public enum Planet{
        Mercury(3.302, 2.438),
        Venus(1.502, 5.438),
        Eart(1.355, 8.438),
        Mars(3.123, 4.438),
        Jupiter(5.302, 6.438),
        Saturn(3.245,2.438),
        Uranus(5.302, 2.438),
        Neptun(9.362, 1.438);

        private final double mass;
        private final double raduis;
        private final double gravity;
        private static final double G=6.673000-11;

        Planet(double mass, double raduis)
        {
            this.mass=mass;
            this.raduis=raduis;
            this.gravity=G*mass/(raduis*raduis);
        }
    }
}

