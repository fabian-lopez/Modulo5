import java.util.ArrayList;
import java.util.List;

public class Fizzbuzz {
    public static String fizzbuzz(){
        String result = "";

        for(int i = 1; i <= 100; i++){
            if((i % 15) == 0 ){
                result += "\tfizzbuzz\n";
            }
            else if((i % 5) == 0 ){
                result += "\tbuzz";
            }
            else if((i % 3) == 0 ){
                result += "\tfizz";
            }
            else result += "\t" + i;
        }

        return result;
    }

    public static List<String> fizzbuzzList(){
        List<String> result = new ArrayList<>();

        for(int i = 1; i <= 100; i++){
            if((i % 15) == 0 ){
                result.add("fizzbuzz");
            }
            else if((i % 5) == 0 ){
                result.add("buzz");
            }
            else if((i % 3) == 0 ){
                result.add("fizz");
            } else result.add(Integer.toString(i));
        }
        return result;
    }
}
