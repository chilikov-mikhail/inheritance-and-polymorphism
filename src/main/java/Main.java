import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Company company1 = new Company();
        System.out.println("Company1: ");

        company1.hireAll(HeldPost.OPERATOR, 180);
        company1.hireAll(HeldPost.MANAGER, 80);
        company1.hireAll(HeldPost.TOP_MANAGER, 9);
        company1.hire(HeldPost.TOP_MANAGER);

        printList(company1.getTopSalaryStaff(15));
        printList(company1.getLowestSalaryStaff(30));

        System.out.println(company1.getNumberOfEmployees());
        company1.fire(company1.getNumberOfEmployees() / 2);
        System.out.println(company1.getNumberOfEmployees());
        System.out.println();

        printList(company1.getTopSalaryStaff(15));
        printList(company1.getLowestSalaryStaff(30));



        Company company2 = new Company();
        System.out.println("Company2: ");

        for (int i = 0; i < 180; i++) {
            company2.hire(new Operator(company2));
        }

        List<Employee> workers = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            workers.add(new Manager(company2));
        }
        company2.hireAll(workers);

        for (int i = 0; i < 10; i++) {
            company2.hire(new TopManager(company2));
        }

        printList(company2.getTopSalaryStaff(15));
        printList(company2.getLowestSalaryStaff(30));

        System.out.println(company2.getNumberOfEmployees());
        int count = company2.getNumberOfEmployees() / 2;
        for (int i = 0; i < count; i++) {
            int indexRemove = (int) (company2.getNumberOfEmployees() * Math.random());
            company2.fire(company2.getEmployees().get(indexRemove));
        }
        System.out.println(company2.getNumberOfEmployees());
        System.out.println();

        printList(company2.getTopSalaryStaff(15));
        printList(company2.getLowestSalaryStaff(30));
    }

    private static void printList(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getMonthSalary());
        }
        System.out.println();
    }
}
