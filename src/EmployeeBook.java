import java.text.DecimalFormat;
import java.util.ArrayList;

class EmployeeBook {
    private ArrayList<Employee> theBook = new ArrayList<>(); // Массив сотрудников
    private int id = 0; // Счетчик id
    private DecimalFormat moneyFormat = new DecimalFormat("###,###.##"); // Определение формата для денег

    public EmployeeBook() {
    }

    public void sumSalary(int department) { // Сумма ЗП: выводит результат работы метода summingSalary (среди всех или отдела)
        checkDepartment(department);
        String filler = department == 0 ? "all employees" : department + " department";
        System.out.printf("Salary sum of %s is: %s\n", filler, moneyFormat.format(summingSalary(department)));
    }

    public void findAverageSalary(int department) { // Средняя ЗП (среди всех или отдела)
        checkDepartment(department);
        int peoplesAmount = 0;
        for (int i = 0; i < theBook.size(); i++) {
            if (theBook.get(i).getDepartment() == department || department == 0) {
                peoplesAmount++;
            }
        }
        String filler = department == 0 ? "all employees" : department + " department";
        System.out.printf("Average salary of %s is: %s\n", filler, moneyFormat.format(summingSalary(department) / peoplesAmount));
    }

    public void findSmallestSalary(int department) { // Ищет самую низкую ЗП (среди всех или отдела)
        checkDepartment(department);
        double minimal = theBook.get(0).getSalary();
        for (int i = 0; i < theBook.size(); i++) {
            if (theBook.get(i).getDepartment() == department || department == 0) {
                if (minimal > theBook.get(i).getSalary()) {
                    minimal = theBook.get(i).getSalary();
                }
            }
        }
        String filler = department == 0 ? "overall" : "in department " + department;
        System.out.printf("The smallest salary %s is: %s\n", filler, moneyFormat.format(minimal));
    }

    public void findBiggestSalary(int department) { // Ищет самую большую ЗП (среди всех или отдела)
        checkDepartment(department);
        double max = theBook.get(0).getSalary();
        for (int i = 0; i < theBook.size(); i++) {
            if (theBook.get(i).getDepartment() == department || department == 0) {
                if (max < theBook.get(i).getSalary()) {
                    max = theBook.get(i).getSalary();
                }
            }
        }
        String filler = department == 0 ? "overall" : "in department " + department;
        System.out.printf("The biggest salary %s is: %s\n", filler, moneyFormat.format(max));
    }

    public void printEmployeesDataList(int department) { // Список данных сотрудников (всех или отдела)
        checkDepartment(department);
        System.out.println(department == 0 ? "All employees data:" : department + " department employees data:");
        for (int i = 0; i < theBook.size(); i++) {
            if (theBook.get(i).getDepartment() == department || department == 0) {
                System.out.printf("  id: %s,  %s, salary: %s\n", theBook.get(i).getId(), theBook.get(i).getName(), moneyFormat.format(theBook.get(i).getSalary()));
            }
        }
    }

    public void printEmployeesNamesList(int department) { // Вывод имен сотрудников (всех или отдела)
        checkDepartment(department);
        System.out.println(department == 0 ? "All employees names list:" : department + " department employees names list:");
        for (int i = 0; i < theBook.size(); i++) {
            if (theBook.get(i).getDepartment() == department || department == 0) {
                System.out.println("  " + theBook.get(i).getName());
            }
        }
    }

    public void indexingSalary(int department, double percent) { // Индексация ЗП (всех или отдела)
        checkDepartment(department);
        for (int i = 0; i < theBook.size(); i++) {
            if (theBook.get(i).getDepartment() == department || department == 0) {
                theBook.get(i).setSalary(theBook.get(i).getSalary() + theBook.get(i).getSalary() * percent / 100);
            }
        }
        String filler = department == 0 ? "to all employees" : "to department " + department;
        System.out.println("Indexation applied " + filler);
    }

    public void printListWithSalaryBelow(double salaryBorder) { // Выводит всех, у кого ЗП меньше границы
        checkNegative(salaryBorder);
        System.out.printf("These employees have salary below %s:\n", moneyFormat.format(salaryBorder));
        for (int i = 0, switcher = 1; i < theBook.size(); i++) {
            if (theBook.get(i).getSalary() < salaryBorder) {
                System.out.printf("  id: %s, %s, salary: %s\n", theBook.get(i).getId(), theBook.get(i).getName(), moneyFormat.format(theBook.get(i).getSalary()));
                switcher = 0; // отменяет выполнение else на последнем элементе массива, если if выполнилось хотя бы раз
            } else if (i == (theBook.size() - 1) * switcher) {
                System.out.printf("No one has salary smaller than %s\n", moneyFormat.format(salaryBorder));
            }
        }
    }

    public void printListWithSalaryAbove(double salaryBorder) { // Выводит всех, у кого ЗП выше границы
        checkNegative(salaryBorder);
        System.out.printf("These employees have salary above %s:\n", moneyFormat.format(salaryBorder));
        for (int i = 0, switcher = 1; i < theBook.size(); i++) {
            if (theBook.get(i).getSalary() >= salaryBorder) {
                System.out.printf("  id: %s, %s, salary: %s\n", theBook.get(i).getId(), theBook.get(i).getName(), moneyFormat.format(theBook.get(i).getSalary()));
                switcher = 0; // отменяет выполнение else на последнем элементе массива, если if выполнилось хотя бы раз
            } else if (i == (theBook.size() - 1) * switcher) {
                System.out.printf("No one has salary bigger than %s\n", moneyFormat.format(salaryBorder));
            }
        }
    }

    public void addNewEmployee(String name, double salary, int department) { // Добавляет сотрудника
        checkName(name);
        checkNegative(salary);
        checkDepartment(department);
        Employee newEmployee = new Employee(name, salary, department, id);
        theBook.add(newEmployee);
        System.out.printf("The new employee %s was added\n", name);
        id++;
    }

    public void removeEmployee(String name) { // Убирает сотрудника через имя
        for (int i = 0; i < theBook.size(); i++) {
            if (name.equals(theBook.get(i).getName())) {
                theBook.remove(i);
                System.out.println("Employee " + name + " has been deleted");
                return;
            }
        }
        searchFail("name");
    }

    public void removeEmployee(int id) { // Убирает сотрудника через id
        checkNegative(id);
        for (int i = 0; i < theBook.size(); i++) {
            if (id == theBook.get(i).getId()) {
                System.out.printf("Employee %s has been deleted\n", theBook.get(i).getName());
                theBook.remove(i);
                return;
            }
        }
        searchFail("id");
    }

    public void changeSalary(String name, double newSalary) { // Меняет ЗП по имени
        checkName(name);
        checkNegative(newSalary);
        for (int i = 0; i < theBook.size(); i++) {
            if (name.equals(theBook.get(i).getName())) {
                theBook.get(i).setSalary(newSalary);
                System.out.printf("New salary for %s has been set: %s\n", name, moneyFormat.format(newSalary));
                return;
            }
        }
        searchFail("name");
    }

    public void changeDepartment(String name, int newDepartment) { // Меняет отдел по имени
        checkName(name);
        checkDepartment(newDepartment);
        for (int i = 0; i < theBook.size(); i++) {
            if (name.equals(theBook.get(i).getName())) {
                theBook.get(i).setDepartment(newDepartment);
                System.out.printf("New department for %s is now %s\n", name, newDepartment);
            }
        }
        searchFail("name");
    }

    private double summingSalary(int department) { // считает сумму ЗП (всех или отдела)
        checkDepartment(department);
        double salarySumCurrent = 0;
        for (int i = 0; i < theBook.size(); i++) {
            if (theBook.get(i).getDepartment() == department || department == 0) {
                salarySumCurrent += theBook.get(i).getSalary();
            }
        }
        return salarySumCurrent;
    }

    /////// Блок проверки данных
    private void checkDepartment(int department) { // Проверяет значение департамента и не позволяет иметь сотруднику департамент 0
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if ((stackTrace[2].getMethodName().equals("addNewEmployee") || stackTrace[2].getMethodName().equals("changeDepartment")) && (department > 5 || department <= 0)) {
            throw new IllegalArgumentException("Department must be from 1 to 5! Employee can't get department " + department);
        }
        if (department > 5 || department < 0) {
            throw new IllegalArgumentException("Department must be from 1 to 5! can't operate with department value " + department + ". Use 1-5 for employee operations or 0 for general operations");
        }
    }

    private void checkNegative(double value) { // Проверяет значения для полей, которые должны быть больше нуля
        if (value <= 0) {
            throw new IllegalArgumentException("Negative value! salary and id must always be positive");
        }
    }

    private void checkName(String name) { // Проверяет ФИО на соответствие формату Фамилиия Имя Отчество
        if (!name.matches("[А-Я][а-я]+(-?[А-Я][а-я]+)*\\s[А-Я][а-я]+\\s[А-Я][а-я]+")) {
            throw new IllegalArgumentException("Wrong name! Use russian keys with format: Фамилия Имя Отчество");
        }
    }

    private void searchFail(String filler) { // Сообщение об ошибке при остутствии записи в БД
        throw new IllegalArgumentException("This employee does not exist! Make sure that " + filler + " is correct!");
    }

}




