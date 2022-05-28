package EasyString;

public class GoalParserInterpretation {
    public static void main(String[] args) {
        String command = "G()(al)";
        System.out.println(interpret(command));
    }

    public static String interpret(String command) {

//        StringBuilder sb = new StringBuilder();
//        int i =0;
//        while(i<command.length())
//        {
//            if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
//                sb.append("o");
//                i +=2;
//            } else if (command.charAt(i) == '(' && command.charAt(i + 1) == 'a' && command.charAt(i + 2) == 'l' && command.charAt(i + 3) == ')'){
//
//                sb.append("al");
//                i+=4;
//            } else if (command.charAt(i) == 'G'){
//                sb.append("G");
//                i++;
//            }
//        }
//
//        return new String(sb);


        command = command.replace("()","o");
        command = command.replace("(al)","al");
        return command;
    }
}
