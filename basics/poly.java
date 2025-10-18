public class poly {
    interface Add { int sum(int a, int b); }
class Adder implements Add { public int sum(int a, int b){ return a+b; } }
class AnotherAdder implements Add { public int sum(int a, int b){ return a+b+1; } }
class add{
    public int sum(int a, int b){
        return a+b;
    }
}
public static void main(String[] args) {

Add obj = new Adder();  
Adder obj3= new Adder();
add obj2 =new add();    // ✅ Flexible: can later do obj = new AnotherAdder();
System.out.println(obj.sum(5,3)); // Output: 8
}

/*
 * All classes defined inside another class are non-static inner classes by default, so they belong to an instance of the outer class, not the class itself.
Since main is static, you cannot directly access non-static inner classes without a reference to the outer class.
That’s why the correct way is:

poly p = new poly();
add obj2 = p.new add();


In some IDEs, add obj2 = new add(); may appear to work because the IDE automatically fixes or treats it as top-level, but technically, it needs the outer class reference.
 */




 /*
  * Add obj = new Adder(); → interface reference allows polymorphism.

Can switch implementation later (obj = new AnotherAdder()) without changing other code.

Using Adder obj = new Adder(); → only works with Adder objects.

Disadvantage: less flexible, hard to extend with new implementations.

Always need new to create the object; interface just controls what type the reference can hold.


Method overding
  */
    
}
