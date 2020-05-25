import java.util.*;

class Main {
    static Integer i1;
    static Integer i2;

    Main() {

    }

    {

    }

    public static void main(String[] args) {
        i1 = 128;
        i2 = 128;
        System.out.println("mlody socjalista wiktorek " + i1.equals(100));

        Wiktorek w1 = new Wiktorek(100, 100);
        Wiktorek w2 = new Wiktorek(100, 100);
        Wiktorek.Noga.malaNoga();
        System.out.println();

    }
}

interface CzlowiekZasole {
    void ChcePic();
}

interface CzlowiekZasole2 {
    void ChceZyc();
}

abstract class WojtZasole {

}

abstract class MerZasola {
    CzlowiekZasole cz = new Wiktorek(1,2);
}

class Wiktorek extends WojtZasole implements CzlowiekZasole, CzlowiekZasole2 {
    Integer i1;
    Integer i2;
    Set secik = new HashSet();
    List lista = new ArrayList();
    List listaL = new LinkedList();
    Map mapka = new HashMap();

    public final Integer A;

    Wiktorek(Integer i1, Integer i2) {
        this.i1 = i1;
        this.i2 = i2;
        A = 21;
    }

    public void ChcePic() {

    }

    public void ChceZyc() {

    }

    static public class Noga {
        public static void malaNoga() {
            System.out.println("malanoga");
        }
    }
}
