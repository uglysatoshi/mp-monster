public class Main {
    public static void Base() {
        for(int i = 0; i < 5; i++) {
            System.out.print(new ExtendedTriangle());
        }
    }
    public static void Medium() {
        for(int i = 0; i < 5; i++) {
            System.out.print(new ComplexImpedance(Math.random()*100, Math.random()*100));
        }
    }
    public static void main(String[] args) {
        Base();
        Medium();
    }
}