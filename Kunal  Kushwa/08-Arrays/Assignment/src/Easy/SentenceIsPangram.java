package Easy;
public class SentenceIsPangram {
    public static void main(String[] args) {
        String input= "thequickbrownfoxhelazydog";
        System.out.println(checkIfPangram(input));

    }

    private static boolean checkIfPangram(String input) {
        int index=0;
        boolean[] visited = new boolean[26];
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                index = input.charAt(i) - 'a';
            }
            visited[index] = true;
        }

        for (int i = 0; i <26 ; i++) {
            if(! visited[i]){
                return false;
            }

        }
        return  true;
    }


}
