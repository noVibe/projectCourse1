import java.util.ArrayList;

class EmployeeBook {
    private ArrayList<Employee> theBook = new ArrayList<>();
    private int id = 0; // Счетчик id

    public EmployeeBook() {
    }

    public void sumSalary(int department) { // Сумма ЗП: выводит результат работы метода salarySumming //+
        checkDepartment(department);
        String lineFiler = department == 0 ? "all employees" : department + " department";
        System.out.printf("Salary sum of %s is: %s\n", lineFiler, summingSalary(department));
    }

    public void findAverageSalary(int department) { //Средняя ЗП //+
        checkDepartment(department);
        int peoplesAmount = 0;
        for (int i = 0; i < theBook.size(); i++) {
            if (theBook.get(i).getDepartment() == department || department == 0) {
                peoplesAmount++;
            }
        }
        String lineFiller = department == 0 ? "all employees" : department + " department";
        System.out.printf("Average salary of %s is %.2f\n", lineFiller, summingSalary(department) / peoplesAmount);
    }

    public void findSmallestSalary(int department) { // Min ЗП 1-5 конкретный департамент, 0 - всe // +
        checkDepartment(department);
        double minimal = theBook.get(0).getSalary();
        for (int i = 0; i < theBook.size(); i++) {
            if (theBook.get(i).getDepartment() == department || department == 0) {
                if (minimal > theBook.get(i).getSalary()) {
                    minimal = theBook.get(i).getSalary();
                }
            }
        }
        System.out.println(minimal);
    }

    public void findBiggestSalary(int department) { // Max ЗП 1-5 конкретный департамент, 0 - всe // +
        checkDepartment(department);
        double max = theBook.get(0).getSalary();
        for (int i = 0; i < theBook.size(); i++) {
            if (theBook.get(i).getDepartment() == department || department == 0) {
                if (max < theBook.get(i).getSalary()) {
                    max = theBook.get(i).getSalary();
                }
            }
        }
        System.out.println(max);
    }

    public void printmployeesDataList(int department) { // Список данных сотрудников (всех или отдела) // +
        checkDepartment(department);
        for (int i = 0; i < theBook.size(); i++) {
            if (theBook.get(i).getDepartment() == department || department == 0) {
                String lineFiller = department == 0 ? "Department: " + department + "," : "";
                System.out.printf("%s id: %s, Name: %s, Salary: %s\n", lineFiller, theBook.get(i).getId(), theBook.get(i).getName(), theBook.get(i).getSalary());
            }
        }
    }

    public void printEmployeesNamesList(int department) { // Вывод имен сотрудников (всех или отдела) // +
        checkDepartment(department);
        for (int i = 0; i < theBook.size(); i++) {
            if (theBook.get(i).getDepartment() == department || department == 0) {
                System.out.printf("Name: %s\n", theBook.get(i).getName());
            }
        }
    }

    public void indexingSalary(int department, double percent) { // Индексация ЗП (всех или отдела) // +
        checkDepartment(department);
        for (int i = 0; i < theBook.size(); i++) {
            if (theBook.get(i).getDepartment() == department || department == 0) {
                theBook.get(i).setSalary(theBook.get(i).getSalary() + theBook.get(i).getSalary() * percent / 100);
            }
        }
        System.out.println("Indexation completed");
    }

    public void printListWithSalaryBelow(double salaryBorder) { // Выводит всех, у кого ЗП меньше границы // +
        checkNegative(salaryBorder);
        for (int i = 0, switcher = 1; i < theBook.size(); i++) {
            if (theBook.get(i).getSalary() < salaryBorder) {
                System.out.printf("This employee has salary below %s: %s, %s, %s\n", salaryBorder, theBook.get(i).getId(), theBook.get(i).getName(), theBook.get(i).getSalary());
                switcher = 0; // отменяет выполнение else на последнем элементе массива, если if выполнилось хотя бы раз
            } else if (i == (theBook.size() - 1) * switcher) {
                System.out.printf("No one has salary smaller than %s\n", salaryBorder);
            }
        }
    }

    public void getListWithSalaryAbove(double salaryBorder) { // Выводит всех, у кого ЗП выше границы // +
        checkNegative(salaryBorder);
        for (int i = 0, switcher = 1; i < theBook.size(); i++) {
            if (theBook.get(i).getSalary() >= salaryBorder) {
                System.out.printf("This employee has salary above %s: %s, %s, %s\n", salaryBorder, theBook.get(i).getId(), theBook.get(i).getName(), theBook.get(i).getSalary());
                switcher = 0; // отменяет выполнение else на последнем элементе массива, если if выполнилось хотя бы раз
            } else if (i == (theBook.size() - 1) * switcher) {
                System.out.printf("No one has salary bigger than %s\n", salaryBorder);
            }
        }
    }

    public void addNewEmployee(String name, double salary, int department) { // Добавляет сотрудника // +
        checkName(name);
        checkNegative(salary);
        checkDepartment(department);
        Employee newEmployee = new Employee(name, salary, department, id);
        theBook.add(newEmployee);
        System.out.printf("The new employee %s was added\n", name);
        id++;
    }

    public void removeEmployee(String name) { // Убирает сотрудника через имя // +
        for (int i = 0; i < theBook.size(); i++) {
            if (name.equals(theBook.get(i).getName())) {
                theBook.remove(i);
            }
        }
        System.out.println("Employee has been deleted");
    }

    public void removeEmployee(int id) { // Убирает сотрудника через id // +
        checkNegative(id);
        for (int i = 0; i < theBook.size(); i++) {
            if (id == theBook.get(i).getId()) {
                theBook.remove(i);
            }
        }
        System.out.println("Employee has been deleted");
    }

    public void changeSalary(String name, double newSalary) { // Меняет ЗП по имени // +
        checkName(name);
        checkNegative(newSalary);
        for (int i = 0; i < theBook.size(); i++) {
            if (name.equals(theBook.get(i).getName())) {
                theBook.get(i).setSalary(newSalary);
            }
        }
        System.out.printf("New salary for %s has been set: %s\n", name, newSalary);
    }

    public void changeDepartment(String name, int newDepartment) { // Меняет отдел по имени // +
        checkName(name);
        checkDepartment(newDepartment);
        for (int i = 0; i < theBook.size(); i++) {
            if (name.equals(theBook.get(i).getName())) {
                theBook.get(i).setDepartment(newDepartment);
            }
        }
        System.out.printf("New department for %s is now %s\n", name, newDepartment);
    }

    private double summingSalary(int department) { // считает сумму ЗП (всех или отдела) // +
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
    private void checkDepartment(int department) { // Проверяет значение департамента. Не дает создать сотрудника с департаментом 0
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if ((stackTrace[2].getMethodName() == "addNewEmployee") && department > 5 || department <= 0) {
            throw new IllegalArgumentException("Department must be from 1 to 5! can't add a new employee with department value " + department);
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
    private void checkName(String name) { // Проверяет ФИО на соответствие формату
        if (!name.matches("[А-Я][а-я]+(-?[А-Я][а-я]+)*\\s[А-Я][а-я]+\\s[А-Я][а-я]+")) {
            throw new IllegalArgumentException("Wrong name! Use russian keys with format: Фамилия Имя Отчество");
        }
    }
}




