package RecursionUnacedemy;

public class SpaceCombination {
    public static void main(String[] args) {
        String input = "123";
        String output = "";
        findCombination(input, 0, output);
    }

    private static void findCombination(String input, int index, String output) {
        //base case
        if (index == input.length()) {
            System.out.println(output);
            return;
        }

        char ch = input.charAt(index);
        //no space - put character without space
        output = output + ch;
        findCombination(input, index + 1, output);

        //with space - put character with space but character is already added at line 21
        output = output + " ";

        if (index != input.length() - 1)
            findCombination(input, index + 1, output);


    }
}
