public class TopManager implements Employee {

    Company company;
    private int fixedPartOfSalary = 100_000;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        if (company.getIncome() > 10_000_000) {
            return (int) (fixedPartOfSalary * 2.5);
        }
        return fixedPartOfSalary;
    }
}
