// Use department 0 for all database operations. Use 1-5 for single department operations
public class Main {
    public static void main(String[] args) {
        EmployeeBook eBook = new EmployeeBook(5);
        eBook.addNewEmployee("Пирожков Артур Максимович", 45000, 1);
        eBook.addNewEmployee("Куклачев Юрий Дмитриевич", 90000, 1);
        eBook.addNewEmployee("Бэкхем Дэвид Эдвардович", 10000000, 3);
        eBook.addNewEmployee("Салтыков-Щедрин Михаил Еврграфович", 200200, 4);
        eBook.addNewEmployee("Киркоров Филипп Бедросович", 300000, 2);
        eBook.addNewEmployee("Галифианакис Зак Гарриевич", 200000, 2);
        eBook.addNewEmployee("Сагиев Борат Александрович", 15, 2);

        eBook.findSmallestSalary(5);


    }
}