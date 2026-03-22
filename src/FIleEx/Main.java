package FIleEx;

import java.io.File;
import java.io.IOException;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) throws IOException {

        File[] roots = File.listRoots();

        for (File root : roots) {
            System.out.println(root);
        }

        File file = new File("src/", "bj7");
        file.createNewFile();

        System.out.println("Absolute Path : " + file.getAbsolutePath());
        System.out.println("Canonical Path : " + file.getCanonicalPath());
        System.out.println("name : " + file.getName());
        System.out.println("Parent : " + file.getParent());
        System.out.println("ParentFile : " + file.getParentFile());
        System.out.println("Path : " + file.getPath());
        System.out.println("isAbsolute : " + file.isAbsolute());
        System.out.println("toString : " + file.toString());
    }
}
