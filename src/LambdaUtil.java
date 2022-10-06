import java.util.function.Predicate;

public class LambdaUtil {
    public static void printWithLambda (String inputString) {
        Printable printable = p -> System.out.println(p);
        printable.print(inputString);
    }
}
