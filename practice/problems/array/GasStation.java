package problems.array;
/*
 * > PROBLEM 134 (medium): Gas Station
 *   There are n gas stations along a circular route, where the amount
 *   of gas available at the i-th station is gas[i]. 
 * 
 *   You have a car with an unlimited gas tank and it costs cost[i] of 
 *   gas to traver from the i-th station to its next i+1-th station. 
 *   You begin the journey with an empty tank at one of the gas stations. 
 * 
 *   Given two integer arrays gas and cost, return the starting gas 
 *   station's index if you can travel around the circuit once in the
 *   clockwise direction, otherwise return -1. 
 *   If there exists a solution, it is guaranteed to be unique. 
 *  
 * > SOLUTION: 
 *   First of all the amount of gas available should be more
 *   than the total gas needed, otherwise the solution don't exists
 * 
 *   Another key property is the fact that if a route i -> j fails
 *   than also every subroute (i+1) -> j, (i+2) -> j, ...
 *   will fail. The next starting point worth trying is j+1!
 *   - consider the failing trip:  i -> a -> b -> c -> j -/
 *      - failing means that we can't go away from j, it means
 *        that the amount of gas we have in the tank when we reach j
 *        is not enough to pay the cost of leaving j. 
 *      - if we start from "a" we do the trip: a -> b -> c -> j -/ which also
 *        fail. this is because the total cost of the trip is less than the 
 *        total gas gained
 *          - this is true: i -> a has a positive gain of gas because otherwise 
 *            it would fail i -> a, hence going from i -> a leave in the tank a 
 *            positive (or 0) amount of gas and with it you fail, so surely you 
 *            starting from a, because starting from a would be as starting with gas[i] - cost[i] 
 *            in the tank. 
 */
public class GasStation {
    public static void main(String[] args) {
        assert(solution(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}) == 3);
        assert(solution(new int[]{2,3,4}, new int[]{3,4,3}) == -1);
    }    

    public static int solution(int[] gas, int[] cost){
        if(gas.length == 0 || gas == null || cost == null)
            return -1;

        int start = 0; //starting index
        int tank = 0; //amount of gas currently in the tank

        /*
            amount of gas that we gain arriving in the station i:
            At the station i we have gas[i] amount of gas available, 
            but from i we can only go to the station i+1, and going 
            from i to i+1 costs cost[i]. 
                - Arriving in the station i gives us gas[i] amount of ga. 
                - Arriving in the station i has also a fixed cost, which is the 
                cost of leaving i for i+1. 
            The variable gain mesaures the actual gas profit of reaching i
        */
        int gain = 0;

        // sum every gas[i] - sum of every cost[i]
        int gasVSCost = 0;

        for(int i = 0; i < gas.length; i++){
            gain = gas[i] - cost[i];
            tank = tank + gain;
            gasVSCost = gasVSCost + gain;

            if(tank < 0){
                start = i+1;
                tank = 0;
            }
        }

        // if the total gas available is less than the total gas needed 
        // is impossible to go a full circle and we don't have a solution
        if(gasVSCost >= 0)
            return start;
        else
            return -1;
    }
}
