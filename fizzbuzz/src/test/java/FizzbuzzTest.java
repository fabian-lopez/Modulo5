import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzbuzzTest {
    private static List<String> lista;
    private static List<String> listaReal;
    @BeforeAll
    public static void setFizzbuzzList(){
        lista = new ArrayList<>();
        lista.add("1");        lista.add("2");        lista.add("fizz");        lista.add("4");
        lista.add("buzz");        lista.add("fizz");        lista.add("7");        lista.add("8");
        lista.add("fizz");        lista.add("buzz");        lista.add("11");        lista.add("fizz");
        lista.add("13");        lista.add("14");        lista.add("fizzbuzz");        lista.add("16");
        lista.add("17");        lista.add("fizz");        lista.add("19");        lista.add("buzz");
        lista.add("fizz");        lista.add("22");        lista.add("23");        lista.add("fizz");
        lista.add("buzz");        lista.add("26");        lista.add("fizz");        lista.add("28");
        lista.add("29");        lista.add("fizzbuzz");        lista.add("31");        lista.add("32");
        lista.add("fizz");        lista.add("34");        lista.add("buzz");        lista.add("fizz");
        lista.add("37");        lista.add("38");        lista.add("fizz");        lista.add("buzz");
        lista.add("41");        lista.add("fizz");        lista.add("43");        lista.add("44");
        lista.add("fizzbuzz");        lista.add("46");        lista.add("47");        lista.add("fizz");
        lista.add("49");        lista.add("buzz");        lista.add("fizz");        lista.add("52");
        lista.add("53");        lista.add("fizz");        lista.add("buzz");        lista.add("56");
        lista.add("fizz");        lista.add("58");        lista.add("59");        lista.add("fizzbuzz");
        lista.add("61");        lista.add("62");        lista.add("fizz");        lista.add("64");
        lista.add("buzz");        lista.add("fizz");        lista.add("67");        lista.add("68");
        lista.add("fizz");        lista.add("buzz");        lista.add("71");        lista.add("fizz");
        lista.add("73");        lista.add("74");        lista.add("fizzbuzz");        lista.add("76");
        lista.add("77");        lista.add("fizz");        lista.add("79");        lista.add("buzz");
        lista.add("fizz");        lista.add("82");        lista.add("83");        lista.add("fizz");
        lista.add("buzz");        lista.add("86");        lista.add("fizz");        lista.add("88");
        lista.add("89");        lista.add("fizzbuzz");        lista.add("91");        lista.add("92");
        lista.add("fizz");        lista.add("94");        lista.add("buzz");        lista.add("fizz");
        lista.add("97");        lista.add("98");        lista.add("fizz");        lista.add("buzz");
    }

    @BeforeAll
    public static void setFizzbuzzListReal(){
        listaReal = new ArrayList<>();

        for(int i = 1; i <= 100; i++){
            if((i % 15) == 0 ){
                listaReal.add("fizzbuzz");
            }
            else if((i % 5) == 0 ){
                listaReal.add("buzz");
            }
            else if((i % 3) == 0 ){
                listaReal.add("fizz");
            } else listaReal.add(Integer.toString(i));
        }
    }

    @Test
    @DisplayName("Prueba fizzbuzz hardcoded 1")
    public void fizzbuzz(){
        String expected = "\t1\t2\tfizz\t4\tbuzz\tfizz\t7\t8\tfizz\tbuzz\t11\tfizz\t13\t14\tfizzbuzz\n" +
                "\t16\t17\tfizz\t19\tbuzz\tfizz\t22\t23\tfizz\tbuzz\t26\tfizz\t28\t29\tfizzbuzz\n" +
                "\t31\t32\tfizz\t34\tbuzz\tfizz\t37\t38\tfizz\tbuzz\t41\tfizz\t43\t44\tfizzbuzz\n" +
                "\t46\t47\tfizz\t49\tbuzz\tfizz\t52\t53\tfizz\tbuzz\t56\tfizz\t58\t59\tfizzbuzz\n" +
                "\t61\t62\tfizz\t64\tbuzz\tfizz\t67\t68\tfizz\tbuzz\t71\tfizz\t73\t74\tfizzbuzz\n" +
                "\t76\t77\tfizz\t79\tbuzz\tfizz\t82\t83\tfizz\tbuzz\t86\tfizz\t88\t89\tfizzbuzz\n" +
                "\t91\t92\tfizz\t94\tbuzz\tfizz\t97\t98\tfizz\tbuzz";

        assertEquals(expected, Fizzbuzz.fizzbuzz());
    }

    @Test
    @DisplayName("Fizzbuzz hardcoded 2")
    public void fizzbuzz2(){
        assertEquals(lista, Fizzbuzz.fizzbuzzList());
    }

    @Test
    @DisplayName("Fizzbuzz real test")
    public void fizzbuzzOK(){
        assertEquals(listaReal, Fizzbuzz.fizzbuzzList());
    }

}
