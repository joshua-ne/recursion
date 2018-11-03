import java.util.*;

public class JR_Combinations {


    //backTrack
    private static List<StringBuilder> backTrack(int level, String element, boolean isData) {
        List<StringBuilder> tempAns = new ArrayList<>();

        if (level == element.length()) {
            if(isData) tempAns.add(new StringBuilder(Character.toString(element.charAt(level - 1))));
            else tempAns.add(new StringBuilder());
            return tempAns;
        }

        tempAns.addAll(backTrack(level + 1, element, true));
        tempAns.addAll((backTrack(level + 1, element, false)));

        if(isData) {
            for(StringBuilder sb : tempAns){
                sb.append(element.charAt(level - 1));
            }
        }
        return tempAns;
    }

    //topDown which transform K-tree to binary tree
    private static void topDown1(int level, String element, StringBuilder sb, boolean isData, List<StringBuilder> res){
        if(level == 0) res.add(new StringBuilder(""));

        if(isData) {
            sb.append(element.charAt(level - 1));
            res.add(new StringBuilder(sb));
        }

        if(level == element.length()) return;

        topDown1(level + 1, element, new StringBuilder(sb), true, res);
        topDown1(level + 1, element, new StringBuilder(sb), false, res);
    }

    //topDown using K-tree
    private  static void topDown2(int level, String element, StringBuilder sb, List<StringBuilder> res){

        //if(level == 0) res.add(new StringBuilder(""));
        res.add(new StringBuilder(sb));
        for (int i = level; i < element.length(); i++) {
            sb.append(element.charAt(i));
            topDown2(i + 1, element, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String element = "abc";
        List<StringBuilder> res1 = backTrack(0, element, false);
        List<StringBuilder> res = new ArrayList<>();
        topDown1(0, element, new StringBuilder(), false, res1);
        topDown2(0, element, new StringBuilder(), res);

        for(StringBuilder str : res) {
            System.out.println(str.toString());
        }
        System.out.println(res.size());
    }
}
