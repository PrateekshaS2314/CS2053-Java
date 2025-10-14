public class WrapperDemo {
    public static void main(String[] args) {
        int num = 10;
        Integer obj = Integer.valueOf(num);
        System.out.println("Wrapper class object: " + obj);

        Integer autoBoxed = num;
        System.out.println("After Autoboxing: " + autoBoxed);

        int autoUnboxed = autoBoxed;
        System.out.println("After Auto-unboxing: " + autoUnboxed);

        
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();

        list.add(5);    
        list.add(10);
        list.add(15);

        System.out.println("\nArrayList elements: " + list);

        int sum = 0;
        for (Integer i : list) {
            sum += i;   
        }

        System.out.println("Sum of elements: " + sum);
    }
}
