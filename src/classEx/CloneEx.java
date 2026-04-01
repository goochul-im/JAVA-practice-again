package classEx;

public class CloneEx {

    public static void main(String[] args) throws CloneNotSupportedException{

        Employee e1 = new Employee("goochul", 28, new Date(1999, 1, 23));

        Employee e2 = (Employee) e1.clone();

        System.out.println("e1 == e2 : " + (e1 == e2));
        System.out.println("e1.name == e2.name : " + (e1.name.equals(e2.name)));
        System.out.println("e1.hiredate == e2.hiredate : " + (e1.hireDate == e2.hireDate));

    }

    private static class Date{
        int year, month, day;

        public Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    private static class Employee implements Cloneable {

        String name;
        int age;
        Date hireDate;

        public Employee(String name, int age, Date hireDate) {
            this.name = name;
            this.age = age;
            this.hireDate = hireDate;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Employee emp = (Employee) super.clone();
            if (hireDate != null) {
                emp.hireDate = new Date(hireDate.year, hireDate.month, hireDate.day);
            }
            return emp;
        }
    }

}


