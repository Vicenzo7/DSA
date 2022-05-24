package RecursionYT;

public class WalkingHome {
    public static void main(String[] args) {
        int dest=10;
        int src=1;

        reachHome(src,dest);
    }

    private static void reachHome(int src, int dest) {
        System.out.println("source "+src+" destination "+dest);

        //base condition
        if(src == dest)
        {
            System.out.println("reached Home");
            return;
        }

        //processing
        src++;

        //recursive relation
        reachHome(src,dest);

    }
}
