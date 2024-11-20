import java.util.Objects;

public class Employee {

    private static int counter = 0;
    private final int id;
    private byte department;
    private String lastName;
    private String firstName;
    private String middleName;
    private double salary;

    public Employee(byte department, String lastName, String firstName, String middleName, int salary) {
        this.id = ++counter;
        this.department = department;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.salary = salary;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public byte getDepartment() {
        return department;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public double getSalary() {
        return salary;
    }

    // Сеттеры
    public void setDepartment(byte department) {
        if (department >= 1 && department <= 5) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Отдел должен быть от 1 до 5.");
        }
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной.");
        }
    }


    public String getFullName(){
        return this.lastName + " " + this.firstName + " " + this.middleName;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                " Отдел: " + department +
                " ФИО: " + lastName + " " + firstName + " " + middleName +
                " Зарплата: " + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && department == employee.department && Double.compare(salary, employee.salary) == 0 && Objects.equals(lastName, employee.lastName) && Objects.equals(firstName, employee.firstName) && Objects.equals(middleName, employee.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, department, lastName, firstName, middleName, salary);
    }
}
