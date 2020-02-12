



import java.lang.*;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        BlackBox test1 = new BlackBoxTestOne();
        BlackBox test2 = new BlackBoxTestTwo();
        List<List<Integer>> results1= pairs(5, test1);
        System.out.println("BlackBox1");
        for(List<Integer> list : results1) 
            System.out.println(list.get(0) + "-" + list.get(1));
        List<List<Integer>> results2 = pairs(50, test2);
        System.out.println("BlackBox2");
        for(List<Integer> list : results2) 
            System.out.println(list.get(0) + "-" + list.get(1));
    }
    public static class BlackBox {
        public int function(int x, int y) {
            return 0;
        }
    }

    public static class BlackBoxTestOne extends BlackBox {
        public int function(int x, int y) {
            return x + y;
        }
    }

    public static class BlackBoxTestTwo extends BlackBox {
        public int function(int x, int y) {
            return ((int) Math.pow(x, 2)) + y;
        }
    }

    public static int binarySearch(int x, int y, int z , BlackBox obj){
        int low = 1; 
        int high = y-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(obj.function(x,mid)==z){
                return mid;
            }
            if (obj.function(x,mid)>z){
                high = mid-1;
                
            }else  low = mid+1;
                
        }
        return -1;
        
    }
    public static List<List<Integer>> pairs(int z, BlackBox obj){
       List<List<Integer>> result = new ArrayList<>();
       int x=1;
       int y=1;
       
       while(obj.function(x,y)<= z){
           y*=2;
       }
       int max = y;
       while(obj.function(x,1)<=z){
           y= binarySearch(x,y,z,obj);
           if(y!= -1)
                result.add(Arrays.asList(new Integer[]{x,y}));
           else
                y=max;
           x++;
       }
       return result;
    }
      
} 
        


