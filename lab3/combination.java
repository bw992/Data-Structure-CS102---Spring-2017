package lab3;

import java.util.ArrayList;
import java.util.List;

public class combination {
    public static List<List<Integer>> combine(int n, int k) {
        // Base case; [[1],[2],[3],...,[n]] & [[1,2,3,...,n]]
        if (k == n || k == 0) {
            List<Integer> elem = new ArrayList<>();
            System.out.println(elem);
            for (int i = 1; i <= k; ++i) {
                elem.add(i);
                //System.out.println(i);
                //System.out.println(elem);
            }
            ArrayList<List<Integer>> base = new ArrayList<>();
           
            
            base.add(elem);
            
            return base;
        }


        // recursive call to combine method, Choose k-1 from n-1;
        List<List<Integer>> result = combine(n - 1, k - 1);
        // Add n to all previous sub problem.
        for (List<Integer> temp : result){
            temp.add(n);
            //System.out.println(temp);
            
        }
        // recursive call to combine method, Choose k from n-1;
        System.out.println(result);
        result.addAll(combine(n - 1, k));
        return result;
    }

public static void main(String[] args) {
	System.out.println(combine(4,2));
}
}
