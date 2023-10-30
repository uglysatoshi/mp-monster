package Base;
// Создаем класс DiamondLv2 наследник DiamondLv1
public class DiamondL2 extends DiamondLv1 {
    // Прописываем поля класса
    String P;
    double Qp;
    // Конструктор
    public DiamondL2(String a, double b, double c, String p) {
        super(a, b, c);
        this.P = p;
        if(P.equals("Белый")) {
            this.Qp = Q +1;
        } else {
            if(P.equals("Желтый")) {
                this.Qp = Q - 0.5;
            } else {
                this.Qp = Q;
            }
        }
    }
    // Переопределяем функцию для изменения объекта в строковый вид
    @Override
    public String toString() {
        return String.format("Название: %s\nВес(карат): %.1f\nКачество огранки(баллов): %.0f\nЦвет: %s\nQ: %.2f\nQp: %.2f\n\n", name, weight, quality, P, Q, Qp);
    }
}
