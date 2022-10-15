package strings;

import java.util.ArrayList;

public class Dice {
    public static void main(String[] args) {
//        dice("", 4);
//        System.out.println();
//        System.out.println(diceRet("",4));

        diceFace("", 7, 7);
        System.out.println();
        System.out.println(diceFaceRet("",7,7));
    }


    static void dice(String p, int target) {
        if (target == 0) {
            System.out.print(p + " ");
            return;
        }


        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - i);
        }
    }

    static ArrayList<String> diceRet(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            ans.addAll(diceRet(p + i, target - i));
        }

        return ans;
    }

    static void diceFace(String p, int target, int faces) {
        if (target == 0) {
            System.out.print(p + " ");
            return;
        }

        for (int i = 1; i <= faces && i <= target; i++) {
            diceFace(p + i, target - i, faces);
        }
    }


    static ArrayList<String> diceFaceRet(String p, int target, int faces) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= faces && i <= target; i++) {
            ans.addAll(diceFaceRet(p + i, target - i, faces));
        }

        return ans;
    }
}
