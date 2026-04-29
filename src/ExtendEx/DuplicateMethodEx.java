package ExtendEx;

public class DuplicateMethodEx {

    private interface itf1 {
        String getOne(int a, int b);
    }

    private interface itf2{
        int getOne(int a, int b);
    }

//    private class Exclass implements itf1, itf2 {
//
//        @Override
//        public int getOne(int a, int b) { // 호환 불가
//            return "";
//        }
//    }

}

