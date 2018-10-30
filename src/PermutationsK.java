/******************************************************************************
 *  Compilation:  javac PermutationsK.java
 *  Execution:    java PermutationsK n k
 *  
 *  Enumerates all permutations of size k chosen from n elements.
 *
 *  % java PermutationsK 4 2 | sort
 *  ab
 *  ac
 *  ad
 *  ba 
 *  bc
 *  bd
 *  ca
 *  cb
 *  cd
 *  da
 *  db 
 *  dc 
 *
 *  Limitations
 *  -----------
 *    *  Assumes n <= 52
 *
 ******************************************************************************/

public class PermutationsK {

    public static void choose(char[] a, int k) {
        enumerate(a, a.length, k);
    }

    private static void enumerate(char[] a, int n, int k) {
        if (k == 0) {
            for (int i = n; i < a.length; i++)
                StdOut.print(a[i]);
            StdOut.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            enumerate(a, n-1, k-1);
            swap(a, i, n-1);
        }
    }  

    // helper function that swaps a[i] and a[j]
    public static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    // sample client
    public static void main(String[] args) {
        //int n = Integer.parseInt(args[0]);
        //int k = Integer.parseInt(args[1]);
        int n = 4, k = 3;
        String elements = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        char[] a = new char[n];
        for (int i = 0; i < n; i++)
            a[i] = elements.charAt(i);
        choose(a, k);
    }

}
