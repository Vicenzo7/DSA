package company.blackBuck;

public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
        System.out.println(numberToTitle(28));
    }

    public static int titleToNumber(String columnTitle) {
        int result = 0;
        for (char ch : columnTitle.toCharArray()) {
            int value = ch - 'A' + 1;
            result = result * 26 + value;
        }

        return result;
    }

    public static String numberToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            // Adjusting for 0-based index
            columnNumber--;

            // Calculate the remainder after dividing by 26
            int remainder = columnNumber % 26;

            // Convert the remainder to a character and append to the result
            result.insert(0, (char) ('A' + remainder));

            // Update columnNumber for the next iteration
            columnNumber /= 26;
        }

        return result.toString();
    }
}
