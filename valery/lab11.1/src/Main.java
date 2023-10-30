public class Main {
    // базовый уровень
    public static void BaseLvL() {
        Base value = new Base();
        System.out.println("Общее количество секунд: " + secAmount(value));
    }
    // функция расчета количества секунд
    private static int secAmount(Base value) {
        return value.seconds + (value.minutes * 60);
    }
    // средний уровень
    public static void MediumLvL() {
        Medium value = new Medium();
        untilMidnight(value);
        minutesIncrease(value);
    }
    // функция расчета времени до полуночи
    private static void untilMidnight(Medium value) {
        // объявляем переменные для подсчета
        int cntHours;
        int cntMinutes;
        int cntSeconds;
        cntHours = Math.abs(24 - value.hours) - 1;
        cntMinutes = Math.abs(60 - value.minutes);
        cntSeconds = Math.abs(60 - value.seconds);
        System.out.println("Времени до следующей полуночи: " + cntHours + ":" + cntMinutes + ":" + cntSeconds);
    }
    // функция добавления 100 минут
    private static void minutesIncrease(Medium value) {
        System.out.println("Время до обработки: ");
        value.show();
        value.minutes += 100;
        while(value.minutes / 60 >= 1) {
            value.minutes -= 60;
            value.hours += 1;
        }
        System.out.println("Время после добавления 100 минут: ");
        value.show();
    }
    public static void main(String[] args) {
        BaseLvL();
        MediumLvL();
    }
}