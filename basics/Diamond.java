// Outer class (only one public class allowed per file)
public class Diamond {

    // Interface A
    interface InterfaceA {
        default void showMessage() {
            System.out.println("Hello from InterfaceA");
        }
    }

    // Interface B with same default method
    interface InterfaceB {
        default void showMessage() {
            System.out.println("Hello from InterfaceB");
        }
    }

    // Class that implements both interfaces
    static class DiamondProblemExample implements InterfaceA, InterfaceB {
        // Overriding the default method to resolve conflict
        @Override
        public void showMessage() {
            InterfaceA.super.showMessage(); // call InterfaceA's version
            InterfaceB.super.showMessage(); // call InterfaceB's version
            System.out.println("Resolved in implementing class");
        }
    }

    // Main method
    public static void main(String[] args) {
        DiamondProblemExample example = new DiamondProblemExample();
        example.showMessage();
    }
}
/*
 * // Outer class (only one public class allowed per file)
public class Diamond {

    // Interface A
    interface InterfaceA {
        default void showMessage() {
            System.out.println("Hello from InterfaceA");
        }
    }

    // Interface B with same default method
    interface InterfaceB {
        default void showMessage() {
            System.out.println("Hello from InterfaceB");
        }
    }

    // Class that implements both interfaces
    static class DiamondProblemExample implements InterfaceA, InterfaceB {
        // Overriding the default method to resolve conflict
        @Override
        public void showMessage() {
            InterfaceA.super.showMessage(); // call InterfaceA's version
            InterfaceB.super.showMessage(); // call InterfaceB's version
            System.out.println("Resolved in implementing class");
        }
    }

    // Main method
    public static void main(String[] args) {
        DiamondProblemExample example = new DiamondProblemExample();
        example.showMessage();
    }
}

 */