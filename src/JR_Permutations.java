import java.util.*;

public class JR_Permutations {

    private static void permutations(String prefix, String str, List<String> res) {
        int n = str.length();
        if (n == 0) {res.add(prefix);}
        else {
            for (int i = 0; i < n; i++) {
                //permutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+i, n), res);
                permutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), res);
            }
        }
    }

    private static void permutations2(char[] a, int n, List<String> res) {
        if (n == 1) {res.add(new String(a)); return;}

        for(int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            permutations2(a, n - 1, res);
            swap(a, i, n - 1);
        }

    }

    private static List<StringBuilder> backTrack(Character curChar, Set<Character> choices) {
        List<StringBuilder> tempAns = new ArrayList<>();

        // reaching the leaf node
        if (choices.size() == 0) {
            tempAns.add(new StringBuilder(Character.toString(curChar)));
            return tempAns;
        }

        //Iterate to traverse all possible choices
        Iterator iter = choices.iterator();
        while (iter.hasNext()) {
            Character nextChar = (Character) iter.next();
            //copy the choices and remove the current char from the choices
            Set<Character> remainingChoices = new HashSet<>(choices);
            remainingChoices.remove(nextChar);

            //go to next level, will end when remainingChoices reaches to a size of 0
            tempAns.addAll(backTrack(nextChar, remainingChoices));
        }

        //append self char and return
        if(curChar != null){
            for(StringBuilder sb : tempAns) sb.append(curChar);
        }
        return tempAns;
    }

    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }



    public static void main(String[] args){
        String str = "abc";
        char[] chars = new char[]{'a', 'b', 'c', 'd'};
        List<String> res = new ArrayList<>();
        permutations("", str, res);
        for(String s : res) {
            System.out.println(s);
        }

        System.out.println();

        List<String> res2 = new ArrayList<>();
        permutations2(str.toCharArray(), str.length(), res2);
        for(String s : res2) {
            System.out.println(s);
        }

        System.out.println();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('b');
        set.add('c');
        for(StringBuilder sb : backTrack(null, set)){
            System.out.println(sb.toString());
        }
    }
}
