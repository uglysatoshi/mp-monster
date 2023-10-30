public class Triangle {
    double firstKat;
    double secondKat;
    public Triangle(double a, double b) {
        this.firstKat = a;
        this.secondKat = b;
    }
    public double getHepo() {
        return Math.sqrt(Math.pow(firstKat, 2) + Math.pow(secondKat, 2));
    }
    @Override
    public String toString() {
        return String.format("Первый катет: %.2f \nВторой катет: %.2f \nГипотенуза: %.2f\n\n", firstKat, secondKat, Math.sqrt(Math.pow(firstKat, 2) + Math.pow(secondKat, 2)));
    }
}
