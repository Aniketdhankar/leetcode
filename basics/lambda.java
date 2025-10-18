public class lambda {
    interface Add { 
        int sum(int a, int b); 
    }

    class add {
        public int sum(int a, int b){
            return a + b;
        }
    }

    public static void main(String[] args) {
        // Using lambda expression for Add interface
        Add obj = (a, b) -> a + b;          // equivalent to Adder
        Add objAnother = (a, b) -> a + b + 1; // equivalent to AnotherAdder

        // For non-static inner class, create instance of outer class
        lambda p = new lambda();
        add obj2 = p.new add();

        System.out.println(obj.sum(5, 3));           // Output: 8
        System.out.println(objAnother.sum(5, 3));   // Output: 9
        System.out.println(obj2.sum(5, 3));         // Output: 8
    }
    
}
