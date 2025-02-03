package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort
{
    public static void main(String [] args)
    {
        String str = "jjkkke";
        System.out.println(frequencySort(str));
    }

    public static String frequencySort(String s)
    {
        StringBuilder stringBuilder = new StringBuilder();
        Map<Character,Integer> hm = new HashMap<>();
        for(char c: s.toCharArray())
        {
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        List<Character> l = new ArrayList<>(hm.keySet());
        l.sort((ob1,ob2) -> hm.get(ob2)-hm.get(ob1));
        for(char c: l){
            for(int i=0; i<hm.get(c); i++)
            {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }


}
