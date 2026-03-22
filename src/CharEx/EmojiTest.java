package CharEx;

public class EmojiTest {
    public static void main(String[] args) {
        String emoji = "😀"; // 웃는 얼굴 이모지

        // 1. 문자열의 길이는? (결과: 2)
        System.out.println("문자열 길이(length): " + emoji.length());

        // 2. 실제 유니코드 포인트 개수는? (결과: 1)
        System.out.println("실제 문자 개수: " + emoji.codePointCount(0, emoji.length()));

        // 3. 내부 char 배열 들여다보기
        char[] chars = emoji.toCharArray();
        System.out.println("첫 번째 char: " + Integer.toHexString(chars[0])); // d83d
        System.out.println("두 번째 char: " + Integer.toHexString(chars[1])); // de00
    }
}
