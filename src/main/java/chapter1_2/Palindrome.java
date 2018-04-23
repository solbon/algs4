package chapter1_2;

public class Palindrome {
    public static void main(String[] args) {
        String s = args[0];
        System.out.println(isPalindrome(s) ? s + " is palindrome" : s + " is not palindrome");
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n/2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
