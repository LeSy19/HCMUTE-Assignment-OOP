public class Employee {

    private int id;
    private String name;
    private double salary;

    private static int employeeCount = 0;
    private static int nextId = 1000;
    public static String companyName = "TechCorp";
    private static double totalSalary = 0;

    public Employee(String name, double salary) {
        this.id = nextId;
        nextId++;

        this.name = name;
        this.salary = salary;

        employeeCount++;
        totalSalary += salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        totalSalary -= this.salary;

        this.salary = salary;

        totalSalary += this.salary;
    }

    // tra ve so luong employee
    public int getEmployeeCount() {
        return employeeCount;
    }

    // tra ve tong luong
    public double getTotalSalary() {
        return totalSalary;
    }

    public static double getAverageSalary() {
        if (totalSalary == 0) {
            return 0;
        }

        return totalSalary / employeeCount;
    }

    public static String changeCompanyName(String newName) {
        if (newName != null && !newName.trim().isEmpty()) {
            companyName = newName;
        } else {
            System.out.println("vui long nhap thong tin teen cong ty moi!");
        }
        return newName;
    }

    public static void main(String[] args) {

        Employee emp1 = new Employee("Lê Văn Sỹ", 1000);
        Employee emp2 = new Employee("Nguyễn Văn A", 2000);
        Employee emp3 = new Employee("Trần Thị B", 3000);

        // In thông tin từng nhân viên
        System.out.println("===== DANH SÁCH NHÂN VIÊN =====");

        System.out.println("ID: " + emp1.getId() + " | Ten: " + emp1.getName() + " | Luong: " + emp1.getSalary());

        System.out.println("ID: " + emp2.getId() + " | Ten: " + emp2.getName() + " | Luong: " + emp2.getSalary());

        System.out.println("ID: " + emp3.getId() + " | Ten: " + emp3.getName() + " | Luong: " + emp3.getSalary());

        System.out.println("Tong so nhan vien: " + employeeCount);

        System.out.println("Tong luong: " + totalSalary);

        System.out.println("Luong trung binh: " + Employee.getAverageSalary());

        Employee.changeCompanyName("Sy LE");
        System.out.println("Tên công ty: " + Employee.companyName);
    }

}
