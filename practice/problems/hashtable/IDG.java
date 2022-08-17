package problems.hashtable;
import java.util.HashSet;
import java.util.Set;
//TODO
public class IDG {

    private Set<Integer> set;

    public IDG(){
        this.set = new HashSet<>();
    }

    public boolean insert(int val) {
        if(set.contains(val))
            return false;

        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!set.contains(val))
            return false;

        set.remove(val);
        return true;
    }
    
    public int getRandom() {
        int random = (int) ((Math.random() * (set.size() - 0)) + 0) - 1;
        Integer[] setArray = new Integer[set.size()];
        set.toArray(setArray);

        return setArray[random];
    }
}
