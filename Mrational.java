import java.util.List;
import java.util.stream.Collectors;

public class Mrational {
    public static void main(String[] args) {
        var rationals = List.of(
                new Rational(1, 4),
        new Rational(1, 8),
        new Rational(3, 4),
        new Rational(7, 8));
        //Imperativo
        var unMedio = new Rational(1, 2);
        for(Rational r : rationals){
            if(r.isLessThan(unMedio)){
                System.out.println(r);
            }
        }

        System.out.println("---- Menores que 1/2 ----");
        rationals.stream()
                .filter(r -> r.isLessThan(new Rational(1, 2))).
                forEach(System.out::println);

        System.out.println("---- Suma ----");
        Rational suma = rationals.
                stream().
                reduce(new Rational(0, 1),
                        (a, b) -> a.plus(b));
        System.out.println(suma);

        System.out.println("---- Racional Mayor ----");
        Rational rmayor =rationals.stream()
                .reduce(unMedio,(a,b) -> a.getGreater(b));
        System.out.println(rmayor);

        System.out.println("---- Suma numeradores ----");
        int sumaNumeradores = rationals.
                stream().
                mapToInt(Rational::getNumerator).
                sum();
        System.out.println(sumaNumeradores);

        System.out.println("---- Colección de sólo numeradores ----");
        List<Integer> numeradores = rationals.
                stream().
                mapToInt(Rational::getNumerator).
                boxed().
                collect(Collectors.toList());
        System.out.println(numeradores);

        System.out.println("---- Promedio numeradores ----");
        double promNume = rationals.
                stream().
                mapToInt(Rational::getNumerator).
                average().
                getAsDouble();
        System.out.println(promNume);

        System.out.println("---- Mayor y menor ----");
        int mayor;
        int menor;

        mayor = rationals.
                stream().
                mapToInt(Rational::getNumerator).
                max().
                getAsInt();
        menor = rationals.
                stream().
                mapToInt(Rational::getNumerator).
                min().
                getAsInt();
        System.out.printf("Mayor = %d, menor = %d\n",
                mayor,
                menor);
    }
}

