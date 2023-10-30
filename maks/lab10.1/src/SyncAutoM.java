public class SyncAutoM {
    private final Statement A; // состояние А
    private final Statement B; // состояние B
    private final boolean[] point; // помечает в каком состоянии находится автомат
    SyncAutoM() {
        // обозначаем имена состояний
        this.A = new Statement("A");
        this.B = new Statement("B");
        // помечаем состояние A как активное
        this.point = new boolean[]{true, false};
    }
    private void pointStatement(int ind) {
        for(int i = 0; i < 2; i++) {
            point[i] = i == ind;
        }
    }
    // функция смены состояния
    void changeStatement() {
        int statementPlace = 0;
        for(int i = 0; i < 2; i++) {
            if(point[i]) statementPlace = i;
        }
        if(statementPlace == 0) {
            while(true) {
                // имитация случайно поступающих сигналов
                int a = (int) (Math.random() * (2));
                int b = (int) (Math.random() * (2));
                // сигналы для перехода в другие состояния
                if (a == 0 && b == 1) {
                    pointStatement(0);
                    break;
                }
                if (a == 1 && b == 1) {
                    pointStatement(1);
                    break;
                }
            }
        }
        if(statementPlace == 1) {
            while(true) {
                // имитация случайно поступающих сигналов
                int a = (int) (Math.random() * (2));
                int b = (int) (Math.random() * (2));
                // сигналы для перехода в другие состояния
                if (a == 0 && b == 1) {
                    pointStatement(1);
                    break;
                }
                if (a == 1 && b == 1) {
                    pointStatement(0);
                    break;
                }
            }
        }
    }
    void showStatement() {
        // выводим активное состояние
        if(point[0]) A.show();
        if(point[1]) B.show();
    }
}