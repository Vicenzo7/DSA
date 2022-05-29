package EasyString;

public class RobotReturnToOrigin {
    public static void main(String[] args) {
        String moves = "LL";
        System.out.println(judgeCircle(moves));
    }

    public static boolean judgeCircle(String moves) {
        int L=0,R=0,U=0,D=0;

        for (int i = 0; i < moves.length() ; i++) {
            if(moves.charAt(i) == 'L')
            {
                L++;
            }
            else if(moves.charAt(i) == 'R')
            {
                R++;
            }
            else if(moves.charAt(i) == 'U')
            {
                U++;
            }
            else{
                D++;
            }
        }

        if(L==R && U==D)
        {
            return true;
        }
        return false;
    }
}
