package designpatterns.creational.factory.src.plan;

public abstract class Plan {
    protected double rate; 
    
    public abstract void getRate();
    
    public void calculateBill(int units){
        System.out.println(units * this.rate);
    }
}
