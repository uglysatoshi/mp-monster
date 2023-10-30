public class Auto {
    String label;
    String color;
    String WIN;
    String regNum;
    int yearRelease;
    int yearTO;
    int price;
    void show() {
        System.out.printf("Марка: %s\nЦвет: %s\nСерийный номер: %s\nРегистрационный номер: %s\nГод выпуска: %d\nГод ТехОсмотра: %d\nЦена: %d$\n\n",label, color, WIN, regNum, yearRelease, yearTO, price);
    }
}
