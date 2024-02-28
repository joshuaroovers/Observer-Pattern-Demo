import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class RomanObserver extends Observer {

    public RomanObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        int num = subject.getState();
        HashMap<Integer,String> romanLetters = new HashMap<>();
        romanLetters.put(1000,"M");
        romanLetters.put(900,"CM");
        romanLetters.put(500,"D");
        romanLetters.put(400,"CD");
        romanLetters.put(100,"C");
        romanLetters.put(90,"XC");
        romanLetters.put(50,"L");
        romanLetters.put(40,"XL");
        romanLetters.put(10,"X");
        romanLetters.put(9,"IX");
        romanLetters.put(5,"V");
        romanLetters.put(4,"IV");
        romanLetters.put(1,"I");

        StringBuilder roman = new StringBuilder();
        ArrayList<Integer> sortedKeys = new ArrayList<>(romanLetters.keySet());
        Collections.sort(sortedKeys);
        Collections.reverse(sortedKeys);

        for(Integer value : sortedKeys) {
            while (num >= value) {
                num = num - value;
                roman.append(romanLetters.get(value));
            }
        }

        System.out.println( "Roman String: " +  roman );

        //original code vvv (from javatpoint.com/convert-integer-to-roman-numerals-in-java)
        //prob better but eh  *hashmap*
//        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
//        String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
//        StringBuilder roman = new StringBuilder();
//        for(int i=0;i<values.length;i++)
//        {
//            while(num >= values[i])
//            {
//                num = num - values[i];
//                roman.append(romanLetters[i]);
//            }
//        }
    }
}
