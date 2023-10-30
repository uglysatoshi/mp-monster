public class SyncAutoM {
    private final Statement A; // состояние А
    private final Statement B; // состояние B
    private boolean point; // помечает в каком состоянии находится автомат
    SyncAutoM() {
        // обозначаем имена состояний
        this.A = new Statement("A");
        this.B = new Statement("B");
        // помеяаем состояние A как активное
        this.point = true;
    }
    // функция смены состояния
    void changeStatement() {
        if(point) {
            while(true) { // пока не подобран сигнал
                // имитация случайно поступающих сигналов
                int a = (int) (Math.random() * (3));
                int b = (int) (Math.random() * (3));
                // сигнал для перехода в состояние A
                if(a == 1 && b == 0) {
                    point = true;
                    // состояние изменено -> выходим из цикла
                    break;
                }
                // сигнал для перехода в состояние B
                if(a == 0 && b == 2) {
                    point = false;
                    // состояние изменено -> выходим из цикла
                    break;
                }
            }
        }
        else {
            while(true) { // пока не подобран сигнал
                // имитация случайно поступающих сигналов
                int a = (int) (Math.random() * (3));
                int b = (int) (Math.random() * (3));
                // сигнал для перехода в состояние B
                if(a == 1 && b == 1) {
                    point = false;
                    // состояние изменено -> выходим из цикла
                    break;
                }
                // сигнал для перехода в состояние A
                if(a == 0 && b == 2) {
                    point = true;
                    // состояние изменено -> выходим из цикла
                    break;
                }
            }
        }
    }
    void showStatement() {
        // выводим активное состояние
        if(point) A.show();
        else B.show();
    }
}
