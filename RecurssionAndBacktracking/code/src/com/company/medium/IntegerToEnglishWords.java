package com.company.medium;

public class IntegerToEnglishWords {
    static String[] tens = {"", "Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    static String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};


    public static String numberToWords(int num) {
        // if number is equal to 0 than no number can be formed
        if(num == 0)
            return "Zero";

        return solve(num);
    }


    public static String solve(int num)
    {
        StringBuilder sb = new StringBuilder();
        if(num >= 1000000000){
            sb.append(solve(num/1000000000)).append(" Billion ").append(solve(num % 1000000000));
        }else if (num >= 1000000){
            sb.append(solve(num/1000000)).append(" Million ").append(solve(num % 1000000));
        }else if (num >= 1000){
            sb.append(solve(num/1000)).append(" Thousand ").append(solve(num % 1000));
        }else if (num >= 100)
        {
            sb.append(solve(num/100)).append(" Hundred ").append(solve(num % 100));
        }else if(num >= 20){
            sb.append(tens[num/10]).append("  ").append(solve(num % 10));
        }else{
            sb.append(ones[num]);
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        int num = 89654753;

        System.out.println(numberToWords(num));
    }
}
