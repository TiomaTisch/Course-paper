public class Main {
    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook(10);

        employeeBook.addEmployee(new Employee((byte) 1, "Иванов", "Иван", "Иванович", 50000));
        employeeBook.addEmployee(new Employee((byte) 2, "Петров", "Петр", "Петрович", 60000));
        employeeBook.addEmployee(new Employee((byte) 3, "Сидоров", "Сидор", "Сидорович", 55000));
        employeeBook.addEmployee(new Employee((byte) 4, "Алексеев", "Алексей", "Алексеевич", 70000));
        employeeBook.addEmployee(new Employee((byte) 1, "Лебедев", "Лев", "Львович", 75000));
        employeeBook.addEmployee(new Employee((byte) 2, "Кузнецов", "Кузьма", "Кузьмич", 48000));
        employeeBook.addEmployee(new Employee((byte) 3, "Максимов", "Максим", "Максимович", 72000));
        employeeBook.addEmployee(new Employee((byte) 4, "Васильев", "Василий", "Васильевич", 80000));
        employeeBook.addEmployee(new Employee((byte) 5, "Соколов", "Сокол", "Соколович", 59000));
        employeeBook.addEmployee(new Employee((byte) 1, "Романов", "Роман", "Романович", 65000));


        System.out.println("Сотрудник с минимальной зарплатой в отделе 1: " + employeeBook.findEmployeeWithMinSalaryInDepartment(1));
        System.out.println("Сотрудник с максимальной зарплатой в отделе 2: " + employeeBook.findEmployeeWithMaxSalaryInDepartment(2));
        System.out.println("Сумма затрат на зарплату по отделу 3: " + employeeBook.getTotalSalaryByDepartment(3));
        System.out.println("Средняя зарплата по отделу 4: " + employeeBook.getAverageSalaryByDepartment(4));

        employeeBook.indexSalary(10);
        employeeBook.indexSalaryByDepartment(5, 5);
        System.out.println("Список сотрудников в отделе 2:");
        employeeBook.printAllEmployeesInDepartment(2);

        System.out.println("Сотрудники с зарплатой меньше 60000:");
        employeeBook.printEmployeesWithSalaryLessThan(60000);

        System.out.println("Сотрудники с зарплатой больше или равной 60000:");
        employeeBook.printEmployeesWithSalaryGreaterOrEqualThan(60000);

        System.out.println("Удаление сотрудника с ID 3: " + employeeBook.removeEmployee(3));
        System.out.println("Сотрудник с ID 3: " + employeeBook.getEmployeeById(3));

    }
}