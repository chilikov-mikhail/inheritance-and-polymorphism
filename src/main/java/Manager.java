public class Manager implements Employee {

    private int fixedPartOfSalary = 50_000;
    private int amountOfMoneyEarned = (int) (115_000 + ((140_000 - 115_000) * Math.random()));
    Company company;

    public Manager(Company company) {
        this.company = company;
        company.setIncome(amountOfMoneyEarned);
    }

    @Override
    public int getMonthSalary() {
        return (int) (fixedPartOfSalary + amountOfMoneyEarned * 0.05);
    }

    public int getAmountOfMoneyEarned() {
        return amountOfMoneyEarned;
    }
}
