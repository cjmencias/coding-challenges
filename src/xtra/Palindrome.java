package xtra;

public class Palindrome {

    public static void main(String[] args) {
        int a = 415;

        boolean isPalindrome =
                a == Integer.parseInt(new StringBuilder(String.valueOf(a)).reverse().toString());

        System.out.println(isPalindrome);

    }
}
