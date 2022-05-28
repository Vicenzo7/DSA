package RecursionUnacedemy;

public class PowerSet {
    public static void main(String[] args) {
        String input ="abcd";
        String output = "";
        printPowerSet(input,0,output);
    }

    private static void printPowerSet(String input, int index, String output) {
        //base case
        if(index == input.length()){
            System.out.println(output);
            return;
        }

        char ch = input.charAt(index);

        //exclude
        printPowerSet(input, index+1, output);

        //include ch
        output= output+ch;
        printPowerSet(input,index+1,output);


    }


}
