package algorithm.stringAlgo;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
//        String str = "III";       // output: 3
//        String str = "LVIII";       // output: 58
        String str = "MCMXCIV";   // output: 1994

        // function call
        int ans1 = romanToIntWithMap(str);
        int ans2 = romanToInt(str);

        // output
        System.out.println("answer with map: " + ans1);
        System.out.println("answer with switch: " + ans2);
    }

    public static int romanToInt(String s) {
        int ans = 0;
        int number = 0;
        int prev = 0;
        // traverse through the string
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I':
                    number = 1;
                    break;
                case 'V':
                    number = 5;
                    break;
                case 'X':
                    number = 10;
                    break;
                case 'L':
                    number = 50;
                    break;
                case 'C':
                    number = 100;
                    break;
                case 'D':
                    number = 500;
                    break;
                case 'M':
                    number = 1000;
                    break;
            }
            // if prev number (number on right) is larger, substract, else keep adding
            if (number < prev) {
                ans -= number;
            } else {
                ans += number;
            }
            prev = number;
        }
        return ans;
    }

    public static int romanToIntWithMap(String s) {
        int ans = 0;
        HashMap<Character, Integer> romanValMap = getRomanSymbolToValueMap();

        // traverse through the string
        for (int i = 0; i < s.length() - 1; i++) {
            // if smaller number is placed before larger number, substract the smaller number, else keep on adding
            if (romanValMap.get(s.charAt(i)) < romanValMap.get((s.charAt(i + 1)))) {
                ans -= romanValMap.get(s.charAt(i));
            } else {
                ans += romanValMap.get(s.charAt(i));
            }
        }
        ans += romanValMap.get(s.charAt(s.length() - 1));
        return ans;
    }

    private static HashMap<Character, Integer> getRomanSymbolToValueMap() {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        return romanMap;
    }
}
