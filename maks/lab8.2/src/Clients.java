import java.io.Serializable;

class Clients implements Serializable {
    private String name;
    private double payment;
    private int monthsPaid;
    private int monthsPaidInAdvance;
    public Clients(String name, double payment, int monthsPaid, int monthsPaidInAdvance) {
        this.name = name;
        this.payment = payment;
        this.monthsPaid = monthsPaid;
        this.monthsPaidInAdvance = monthsPaidInAdvance;
    }
    public void reducePayment() {
        if (monthsPaidInAdvance >= 3) {
            payment *= 0.93; // Уменьшаем стоимость на 7%
        }
    }
    @Override
    public String toString() {
        return String.format("ФИ: %s\nЕжемесячный платеж: %.2f\nОплачено месяцев: %d\nОплачено месяцев наперед: %d\n", name, payment, monthsPaid, monthsPaidInAdvance);
    }
}
