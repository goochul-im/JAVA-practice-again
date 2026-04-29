package CharEx;

public class EmojiTest {
    public static void main(String[] args) {
        String emoji = "😀";

        System.out.println("문자열 길이(length): " + emoji.length());

        System.out.println("실제 문자 개수: " + emoji.codePointCount(0, emoji.length()));

        char[] chars = emoji.toCharArray();
        System.out.println("첫 번째 char: " + Integer.toHexString(chars[0])); // d83d
        System.out.println("두 번째 char: " + Integer.toHexString(chars[1])); // de00
    }
}
