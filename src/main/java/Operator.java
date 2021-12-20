public class Operator implements Employee {
    Company company;
    private int fixedPartOfSalary = 56_000;

    public Operator(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        return fixedPartOfSalary;
    }
}
