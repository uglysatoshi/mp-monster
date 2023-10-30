public class ExtendedTriangle extends Triangle {
    double beta;
    double alpha;
    public ExtendedTriangle() {
        super();
        this.alpha = Math.toDegrees(Math.atan(a/b));
        this.beta = 90 - alpha;
    }
    // Переопределение метода toString для получения текстового представления объекта
    @Override
    public String toString() {
        return String.format("Первый катет: %.2f\nВторой катет: %.2f\nТангенс альфа: %.2f\nУгол β в радианах: %.2f\nРазность углов β и α: %.2f\n\n", a, b, a/b, beta, Math.abs(beta-alpha));
    }
}
