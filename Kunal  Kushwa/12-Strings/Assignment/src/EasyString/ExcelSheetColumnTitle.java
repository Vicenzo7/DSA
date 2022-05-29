package EasyString;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        int columnNumber = 701;
        System.out.println(convertToTitle(columnNumber));
    }

    public static String convertToTitle(int columnNumber) {
        String result ="";
        while(columnNumber>0)
        {
            char ch = (char) (65+(columnNumber-1)%26);
            result = ch + result;
            columnNumber = ((columnNumber-1)/26);
        }

        return result;
    }
}
