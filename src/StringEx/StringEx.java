package StringEx;

public class StringEx {

    public static void main(String[] args) {

        String s = "myg string";

        System.out.println(s.lastIndexOf("string"));
        System.out.println(s.substring(3));
//        System.out.println(s.charAt(-1));

        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity());

        System.out.println(s.replace("m", "q"));

        System.gc(); // 가비지 컬렉션을 되도록이면 실행해라
    }

}
