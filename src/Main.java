import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        String string = "Printed by lambda";
        Printable printable = p -> System.out.println(p);
        printable.print(string);

        System.out.println();
        Predicate <String> predikateNotNull = pnn -> (!pnn.equals(null));
        System.out.println("Proverka nepustoy stroki v lambda (Printable): " + predikateNotNull.test("Not empty string"));

        System.out.println();
        System.out.println("Proverka nachinaetsya li na J ili N, zakanchivaetsya na A (Predicate): ");
        Predicate <String> predicateStringSimbols = pss -> {
            String test = pss;
            if (String.valueOf(test.charAt(0)).equals("J") || (String.valueOf(test.charAt(0)).equals("N"))) {
                if (String.valueOf(test.charAt(test.length() - 1)).equals("A")) {
                    return true;
                }
            }
            return false;
        };
        String testedString = "NAMBA";
        System.out.println("Slovo - " + testedString +", resultat: " + predicateStringSimbols.test(testedString));

        System.out.println();
        System.out.println("Proverka znaka chisla (Function)");
        int testedInt = -11;
        Function <Integer,String> functionZnak = a -> {
            String znak ="";
            if (a > 0) {znak = "Pologitelnoe";
            } else if (a < 0) {znak = "Otricatelnoe";
            } else {znak = "Nol";}
            return znak;
        };
        System.out.println("Proveraemoe chislo: " + testedInt + ". Rezultat: " + functionZnak.apply(-10));

        System.out.println();
        System.out.println("Random (Supplier");
        Supplier<Integer> randomSupplier = () -> (int) Math.round(Math.random()*10);
        System.out.println("Random 0...10: " + randomSupplier.get());

        System.out.println();
        System.out.println("Printable cherez staticheskiy metod");
        LambdaUtil.printWithLambda("Printed whith Lambda");
    }
}