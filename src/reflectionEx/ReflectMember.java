package reflectionEx;

import ExceptionEx.FinallyEx;
import ExtendEx.InterfaceEx;
import annotationEx.Stub;

import java.sql.Ref;

@Stub
public class ReflectMember {

    static {
        System.out.println("ReflectMember init");
    }

    {
        System.out.println("ReflectMember Instance init");
    }

    private String name;
    protected int age;
    public String grade;

    public class MyInnerClass {

    }

    private class MyPrivateClass{

    }

    // 기본 생성자 (리플렉션에서 객체를 동적으로 생성할 때 필요)
    public ReflectMember() {
        this.name = "이름 없음";
        this.age = 0;
        this.grade = "BRONZE";
    }

    // 인자가 있는 생성자
    public ReflectMember(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    private ReflectMember(String name) {
        this.name = name;
    }

    protected ReflectMember(String name, String now) {

    }

    // 공개된 메소드
    public void sayHello(String talk) {
        System.out.println(name + "님이 말합니다: " + talk);
    }

    // 숨겨진(private) 메소드
    private void upgradeGrade() {
        this.grade = "GOLD";
        System.out.println("비밀리에 등급이 업그레이드 되었습니다.");
    }

    @Override
    public String toString() {
        return "Member{name='" + name + "', age=" + age + ", grade='" + grade + "'}";
    }

}
