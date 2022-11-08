package designpatterns.creational.prototype.src;

public class EmployeeRecord implements Prototype{
    private int employeeID;
    private double salary;
    private String address;
    private String name;
    private String position;

    public EmployeeRecord(
        int employeeID, 
        double salary, 
        String address, 
        String name, 
        String position
    ){
        this.employeeID = employeeID;
        this.salary = salary;
        this.address = address;
        this.name = name;
        this.position = position;
    }

    public int getEmployeeID() {
        return employeeID;
    }
    public double getSalary() {
        return salary;
    }
    public String getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    
    @Override
    public Prototype getClone() {
        return new EmployeeRecord(
            this.employeeID, 
            this.salary, 
            this.address, 
            this.name, 
            this.position
        );
    }
}
