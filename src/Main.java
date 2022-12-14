

public class Main {
    public static void main(String[] args) {
            /*
            ______________________________________________________________________________________________________
                    Use department 0 for all database operations. Use 1-5 for single department operations
            ------------------------------------------------------------------------------------------------------
            addNewEmployee          - Add new employee
            sumSalary               - Get salary sum for everyone or single department
            findAverageSalary       - Get average salary of company or single department
            findSmallestSalary      - Who has the smallest salary of company or single department
            findBiggestSalary       - Who has the biggest salary of company or single department
            printEmployeesDataList  - Gives all company's or single department data
            printEmployeesNamesList - Gives all company's or single department names
            indexingSalary          - Set new salaries for everyone or single department via index
            printListWithSalaryBelow- Shows list of employees of company or single department with salary below value
            printListWithSalaryAbove- Shows list of employees of company or single department with salary above value
            removeEmployee          - Removes employee from database via name or id
            changeSalary            - Changes the salary via name
            changeDepartment        - Changes department via name
            ------------------------------------------------------------------------------------------------------
         */
        EmployeeBook eBook = new EmployeeBook();
        eBook.addNewEmployee("Пирожков Артур Максимович", 45000, 4);
        eBook.addNewEmployee("Куклачев Юрий Дмитриевич", 90000, 1);
        eBook.addNewEmployee("Бэкхем Дэвид Эдвардович", 10000000, 3);
        eBook.addNewEmployee("Салтыков-Щедрин Михаил Еврграфович", 2000, 4);
        eBook.addNewEmployee("Киркоров Филипп Бедросович", 300000, 2);
        eBook.addNewEmployee("Галифианакис Зак Гарриевич", 200000, 2);
        eBook.addNewEmployee("Сагиев Борат Александрович", 15, 2);
        eBook.sumSalary(0);
        eBook.sumSalary(4);
        eBook.findAverageSalary(0);
        eBook.findAverageSalary(4);
        eBook.findSmallestSalary(4);
        eBook.findBiggestSalary(0);
        eBook.printEmployeesDataList(2);
        eBook.printEmployeesNamesList(3);
        eBook.printEmployeesNamesList(0);
        eBook.indexingSalary(1, 10);
        eBook.printListWithSalaryBelow(20);
        eBook.printListWithSalaryAbove(150000);
        eBook.removeEmployee("Киркоров Филипп Бедросович");
        eBook.printEmployeesDataList(1);
        eBook.removeEmployee(1);
        eBook.sumSalary(1);
        eBook.changeSalary("Галифианакис Зак Гарриевич", 250000);
    }
}