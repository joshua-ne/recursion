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
    }
}
