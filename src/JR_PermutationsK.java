import java.util.*;

public class JR_PermutationsK {

    private static List<String> permute (char[] a, int k) {

        List<String> res = new ArrayList<>();
        char[] path = new char[k];
        Set<Integer> choiceIndex = new HashSet<>();
        for(int i = 0; i < a.length; i++) choiceIndex.add(i);
        dfs(0, k,'0', a, choiceIndex, path, res);
        return res;
    }

    private static void dfs(int level, int k, char curChar, char[] a, Set<Integer> choiceIndex, char[] path, List<String> res) {
        if (level != 0) path[level - 1] = curChar;
        if (level == k) {res.add(new String(path)); return;}
        for(Integer nextCharIndex : choiceIndex) {
            Set<Integer> choiceIndexNext = new HashSet<>(choiceIndex);
            choiceIndexNext.remove(nextCharIndex);
            dfs(level + 1, k, a[nextCharIndex], a, choiceIndexNext, path, res);
        }
    }

    private static List<StringBuilder> backTrack(Character curChar, Set<Character> choices) {
        List<StringBuilder> tempAns = new ArrayList<>();

        if (choices.size() == 0) {
            tempAns.add(new StringBuilder(Character.toString(curChar)));
            return tempAns;
        }

        Iterator iter = choices.iterator();
        while (iter.hasNext()) {
            Character nextChar = (Character) iter.next();
            Set<Character> remainingChoices = new HashSet<>(choices);
            remainingChoices.remove(nextChar);
            tempAns.addAll(backTrack(nextChar, remainingChoices));
        }

        if(curChar != null){
            for(StringBuilder sb : tempAns) sb.append(curChar);

        }


        return tempAns;
    }

    public static void main(String[] args) {
        int n = 3, k = 3;
        String elements = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        char[] a = new char[n];
        for (int i = 0; i < n; i++)
            a[i] = elements.charAt(i);
        List<String> res = permute(a, k);
        for(String str : res) {
            System.out.println(str);
        }
        System.out.println(res.size());
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
