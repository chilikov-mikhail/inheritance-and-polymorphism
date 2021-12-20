import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

    private int income;
    private List<Employee> employees = new ArrayList<>();

    public int getIncome() {
        return income;
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public void setIncome(int amountOfMoneyEarnedManager) {
        this.income += amountOfMoneyEarnedManager;
    }

    public int getNumberOfEmployees() {
        return employees.size();
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(List<Employee> employees) {
        this.employees.addAll(employees);
    }

    public void fire(Employee employee) {
        if (employee instanceof Manager) {
            setIncome(((Manager) employee).getAmountOfMoneyEarned() * (-1));
        }
        employees.remove(employee);
    }

    public void hire(HeldPost heldPost) {
        switch (heldPost) {
            case MANAGER:
                employees.add(new Manager(this));
                break;
            case TOP_MANAGER:
                employees.add(new TopManager(this));
                break;
            case OPERATOR:
                employees.add(new Operator(this));
        }
    }

    public void hireAll(HeldPost heldPost, int count) {
        for (int i = 0; i < count; i++) {
            hire(heldPost);
        }
    }

    public void fire(int count) {
        if (count < employees.size() && count > 0) {
            for (int i = 0; i < count; i++) {
                int indexRemove = (int) (employees.size() * Math.random());
                fire(employees.get(indexRemove));
            }
        } else if (count > 0) {
            employees = new ArrayList<>();
            income = 0;
        }
    }

    public List<Employee> getTopSalaryStaff(int count) {
        employees.sort(new EmployeeComparator());
        Collections.reverse(employees);
        return getListSalaryStaff(employees, count);
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        employees.sort(new EmployeeComparator());
        return getListSalaryStaff(employees, count);
    }

    private List<Employee> getListSalaryStaff(List<Employee> employees, int count) {
        if (count <= 0) {
            return Collections.emptyList();
        } else if (count < employees.size()) {
            return employees.subList(0, count);
        } else {
            return employees;
        }
    }
}
