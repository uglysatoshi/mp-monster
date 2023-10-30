import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {
    public static void Base() {
        // Объявляем список
        LinkedList<Worker> list = new LinkedList<>();
        // Заполняем список
        for(int i = 0; i < 5; i++) {
            list.add(new Worker());
        }
        // Выводим сотрудников старше 30 и не имеющих высшее
        for(Worker w : list) {
            if(w.age > 30 && !w.edDegree.equals("Высшее")) {
                w.show();
            }
        }
    }
    public static void Medium() {
        // Объявляем список
        LinkedList<Player> list = new LinkedList<>();
        // Объявляем список
        for(int i = 0; i < 5; i++) {
            list.add(new Player());
        }
        // Выводим футболистов старше 20 и получающих больше 1 карточки за 10 игр
        for (Player p : list) {
            long result = ChronoUnit.YEARS.between(p.date, LocalDate.now());

            if(result > 20 && (((double) p.yellowCards / p.countGames) * 10.0) > 1.0 ) {
                p.show();
            }
        }
    }
    public static void Hard() {
        // Объявляем список
        LinkedList<Tovar> list = new LinkedList<>();
        // Объявляем список
        for(int i = 0; i < 5; i++) {
            list.add(new Tovar());
        }
        // Сортируем список
        sort(list);
        // Выводим список
        for(Tovar t : list) {t.show();}
        // Выводим товары, которым более 10 месяцев
        print10(list);
    }
    private static void sort(LinkedList<Tovar> list) {
        list.sort(Comparator.comparingInt(tovar -> tovar.price));
    }
    private static void print10(LinkedList<Tovar> list) {
        for(Tovar t : list) {
            long result = ChronoUnit.YEARS.between(t.date, LocalDate.now()) * 12 + ChronoUnit.MONTHS.between(t.date, LocalDate.now());
            if(result > 10) t.show();
        }
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}