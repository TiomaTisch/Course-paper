import java.util.Arrays;
import java.util.Objects;

public class EmployeeBook {
    private Employee[] employees;
    private int maxEmployees;

    public EmployeeBook(int maxEmployees) {
        this.maxEmployees = maxEmployees;
        this.employees = new Employee[maxEmployees];
    }

    // Добавление сотрудника
    public boolean addEmployee(Employee newEmployee) {
        for (int i = 0; i < maxEmployees; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                return true;
            }
        }
        return false;
    }

    // Удаление сотрудника
    public boolean removeEmployee(int id) {
        for (int i = 0; i < maxEmployees; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                return true;
            }
        }
        return false;
    }

    // Получение сотрудника по ID
    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    //  Получить список всех сотрудников со всеми имеющимися по ним данными
    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
    }
    // Поиск сотрудника с минимальной ЗП
    public Employee findEmployeeWithMinSalary() {
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {if (employee != null) {
            if (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        }
        return minSalaryEmployee;
    }

    // Поиск сотрудника с максимальной ЗП
    public Employee findEmployeeWithMaxSalary() {
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary()) {
                    maxSalaryEmployee = employee;
                }
            }
        }
        return maxSalaryEmployee;
    }

    // Подсчет среднего значения зарплат
    public double getAverageSalary() {
        return getTotalSalary() / (double) countEmployees();
    }

    // Сумму затрат на ЗП в месяц
    public double getTotalSalary() {
        double total = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                total += employee.getSalary();
            }
        }
        return total;
    }

    // Подсчёт количество действующих сотрудников
    public int countEmployees() {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return count;
    }

    // Напечатать ФИО всех сотркдников
    public void printEmployeeNames() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    // Индексировать ЗП всех сотрудников на процент
    public void indexSalary(double percentage) {
        for (Employee employee : employees) {
            if (employee != null) {
                double newSalary = employee.getSalary() * (1 + percentage / 100);
                employee.setSalary(newSalary);
            }
        }
    }
    // Сотрудник с минимальной ЗП в заданном отделе
    public Employee findEmployeeWithMinSalaryInDepartment(int department) {
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary()) {
                    minSalaryEmployee = employee;
                }
            }
        }
        return minSalaryEmployee;
    }

    // Сотрудник с максимальной ЗП в заданном отделе
    public  Employee findEmployeeWithMaxSalaryInDepartment(int department) {
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary()) {
                    maxSalaryEmployee = employee;
                }
            }
        }
        return maxSalaryEmployee;
    }

    // Сумма затрат на ЗП по заданному отделу
    public double getTotalSalaryByDepartment(int department) {
        double total = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                total += employee.getSalary();
            }
        }
        return total;
    }

    // Средняя ЗП по заданному отделу
    public double getAverageSalaryByDepartment(int department) {
        double total = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                total += employee.getSalary();
                count++;
            }
        }
        return count > 0 ? total / count : 0;
    }

    // Индексировать ЗП всех сотрудников в заданном отделе
    public void indexSalaryByDepartment(int department, double percentage) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                double newSalary = employee.getSalary() * (1 + percentage / 100);
                employee.setSalary(newSalary);
            }
        }
    }

    // Напечатать всех сотрудников в заданном отделе
    public void printAllEmployeesInDepartment(int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println(employee.toString().replace(", department=" + department, ""));
            }
        }
    }

    // Сотрудники с ЗП меньше указанной
    public void printEmployeesWithSalaryLessThan(double salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("ID: " + employee.getId() + ", ФИО: " + employee.getFullName() + ", Зарплата: " + employee.getSalary());
            }
        }
    }

    // Сотрудники с ЗП больше или равной указанной
    public void printEmployeesWithSalaryGreaterOrEqualThan(double salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.println("ID: " + employee.getId() + ", ФИО: " + employee.getFullName() + ", Зарплата: " + employee.getSalary());
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return maxEmployees == that.maxEmployees && Objects.deepEquals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(employees), maxEmployees);
    }
}

