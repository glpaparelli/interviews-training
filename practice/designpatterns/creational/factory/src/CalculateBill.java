package designpatterns.creational.factory.src;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import designpatterns.creational.factory.src.plan.Plan;

public class CalculateBill {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));          
        PlanFactory factory = new PlanFactory();

        System.out.print("enter plan for bill generation: ");  
        String planName = br.readLine();  

        System.out.println();

        System.out.print("enter number of units: ");  
        int units = Integer.parseInt(br.readLine());  

        Plan plan = factory.getPlan(planName.toUpperCase());

        System.out.printf("bill amount for %s of %d is:", planName, units);
        plan.getRate();  
        plan.calculateBill(units);  
    }
}
