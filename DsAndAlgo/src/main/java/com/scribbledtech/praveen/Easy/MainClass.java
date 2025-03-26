package com.scribbledtech;


import org.apache.commons.lang3.StringUtils;

public class MainClass {

    public static void main(String[] args) {

        System.out.println(sumOfLargeNo("123,123", "23,333"));

    }

    public static String sumOfLargeNo(String input1, String input2)
    {
        if(StringUtils.isBlank(input1))
        {
            return input2;
        }
        if(StringUtils.isBlank(input2))
        {
            return input1;
        }
        String input1tmp = input1.trim().replaceAll(",","");
        String input2tmp = input2.trim().replaceAll(",","");
        int input1Length = input1tmp.length();
        int input2Length = input2tmp.length();
        int positionFromTail = 0;
        StringBuilder digitSum = new StringBuilder();
        int carry = 0;
        while(input1Length> positionFromTail || input2Length > positionFromTail || carry>0)
        {
            int input1CurrentDigit = 0;
            int input2CurrentDigit = 0;
            if(input1Length - positionFromTail >0)
            {
                 input1CurrentDigit = input1tmp.charAt(input1Length - positionFromTail -1) - '0';
            }
            if(input2Length - positionFromTail >0)
            {
                input2CurrentDigit = input2tmp.charAt(input2Length - positionFromTail -1) - '0';
            }
            int sumOfDigit = input1CurrentDigit + input2CurrentDigit + carry;
            digitSum.append(sumOfDigit % 10);
            carry = sumOfDigit / 10;
            positionFromTail++;
        }
        digitSum.reverse();
        for (int i = digitSum.length() - 3; i > 0; i -= 3) {
            digitSum.insert(i, ',');
        }
        return digitSum.toString();
    }
}
