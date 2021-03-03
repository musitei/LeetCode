import java.util.*;

public class Test1 {

    static String addByBase(int base,String a, String b) {

        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length());
        int carry = 0;

        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % base + '0'));
            carry /= base;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt(); // n进制
        String a = sc.next(); // 数字 a
        String b = sc.next(); // 数字 b

        System.out.println(addByBase(base,a, b));
    }

}
