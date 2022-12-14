// Use department 0 for all database operations. Use 1-5 for single department operations
public class Main {
    public static void main(String[] args) {
        EmployeeBook eBook = new EmployeeBook(5);
        eBook.addNewEmployee("Пирожков Артур Максимович", 45000, 1);
        eBook.addNewEmployee("Куклачев Юрий Дмитриевич", 90000, 1);
        eBook.addNewEmployee("Бэкхем Дэвид Эдвардович", 10000000, 3);
        eBook.addNewEmployee("Салтыков-Щедрин Михаил Еврграфович", 2000, 4);
        eBook.addNewEmployee("Киркоров Филипп Бедросович", 300000, 2);
        eBook.addNewEmployee("Галифианакис Зак Гарриевич", 200000, 2);
        eBook.addNewEmployee("Сагиев Борат Александрович", 15, 2);
        eBook.sumSalary(0);
        eBook.sumSalary(4);
        eBook.findAverageSalary(5);
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
        eBook.removeEmployee(0);
        eBook.sumSalary(1);
        eBook.changeSalary("Галифианакис Зак Гарриевич", 250000);
        eBook.printEmployeesDataList(0);
    }
}