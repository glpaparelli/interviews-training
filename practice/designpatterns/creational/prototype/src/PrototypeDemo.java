package designpatterns.creational.prototype.src;

public class PrototypeDemo {
    public static void main(String[] args) {
        EmployeeRecord e1 = new EmployeeRecord(
        1000, 
        2000, 
        "main plaza", 
        "john", 
        "actor");

        EmployeeRecord e2 = (EmployeeRecord) e1.getClone();

        assert(e1 == e2);
    }
}
