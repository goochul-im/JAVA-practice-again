package classEx;

public class PlayGround {

    static void main() {
        InnerNonStaticClassEx classEx = new InnerNonStaticClassEx();
        classEx.new InnerClass().method1();
    }
    
}
