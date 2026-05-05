package lambdaEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

public class CollectionEx {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // 요소를 꺼내어서 하나씩 출력
        list.forEach(i -> System.out.print(i+" "));
        System.out.println();

        //list 내의 2의 배수 또는 3의 배수 제거
        list.removeIf(x -> x % 2 == 0 || x % 3 == 0);
        System.out.println(list);

        //모든 수를 10 곱하기
        list.replaceAll(i -> i*10);
        System.out.println(list);

        HashMap<String, String> map = new HashMap<>();
        map.put("1", "10");
        map.put("2", "20");
        map.put("3", "30");
        map.put("4", "40");

        // map의 모든 요소를 {k,v}방식으로 출력
        map.forEach((k,v) -> System.out.printf("{%s, %s} ,",k,v));
        System.out.println();

    }

}
