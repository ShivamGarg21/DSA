import java.util.HashMap;
import java.util.ArrayList;
public class l001{
    public static void basic_01(){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Nepal",233);
        map.put("USA",23);
        map.put("Japan",20);
        map.put("India",5);
        // for(String s : map.keySet()){
        //     System.out.println(s);
        // }
        String key = "UA";
        if(map.containsKey(key)){
            System.out.println(map.get(key));
        }
        else
        System.out.println("not found");
    }

    public static void highfrequencyCharacter(String str){
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i < str.length; i++){
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        char ans = ' ';
        int freq = 0;
        for(Character ch : map.keySet()){
            if(map.get(ch)>freq){
                freq = map.get(ch);
                ans = ch;
            }
        }
        System.out.println(ans);
    }

    public static void positionofAllchar(String str){
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        if (!map.containsKey(ch))
        map.put(ch, new ArrayList<>());

        map.get(ch).add(i);
        }

    }
    public static void positionOfAllChar(String str){
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(i);
        }

         System.out.println(map);
        for(Character ch : map.keySet()){
            System.out.println(ch + " -> " + map.get(ch));
        }
    }
    public static void printfrequency(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            // if(map.containsKey(ch)){
            //     map.put(ch,map.get(ch)+1);
            // }
            // else    
            //     map.put(ch,1);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        System.out.print(map);
    }
    public static void highfrequencyCharacter(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
            // map.put(ch, map.getOrDefault(ch,0)+1);
        }
        char anschar = ' ';
        int freq = -(int)1e9;
        for(Character ch : map.keySet()){
                if(map.get(ch)>freq)
                    {
                        freq = map.get(ch);
                        anschar = ch;
                    }
        }
        System.out.print(anschar);
    }
    public static void positionofallchar(String str){
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        // for(int i=0;i<str.length();i++){
        //     char ch = str.charAt(i);
        //     if(map.containsKey(ch)){
        //         map.get(ch).add(i);
        //     }else{
        //         map.put(ch,new ArrayList<>());
        //         map.get(ch).add(i);
        //     }
        // }
        // System.out.print(map);
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            map.putIfAbsent(ch,new ArrayList<>());
            map.get(ch).add(i);
        }
        for(char ele : map.keySet()){
            System.out.println(ele + "->" + map.get(ele));
        }
    }

    public static void main(String[] args){
        positionofallchar("sadfdddsa");
    }
}