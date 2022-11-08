package designpatterns.creational.factory.src;

import designpatterns.creational.factory.src.plan.*;
import designpatterns.creational.factory.src.plan.Plan;

public class PlanFactory {
    public Plan getPlan(String planType){
        switch (planType) {
            case "DOMESTICPLAN":
                return new DomesticPlan();
            case "COMMERCIALPLAN":
                return new CommercialPlan();
            case "INSTITUTIONALPLAN":
                return new InstitutionalPlan();
            default:
                return null;
        }
    }
}
