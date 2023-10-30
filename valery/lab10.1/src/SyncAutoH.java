public class SyncAutoH {
    private final Statement A; // состояние А
    private final Statement B; // состояние B
    private final Statement C; // состояние А
    private final Statement D; // состояние B
    private final boolean[] point; // помечает в каком состоянии находится автомат
    SyncAutoH() {
        // обозначаем имена состояний
        this.A = new Statement("A");
        this.B = new Statement("B");
        this.C = new Statement("C");
        this.D = new Statement("D");
        // помеяаем состояние A как активное
        this.point = new boolean[]{true, false, false, false};
    }
    // функция, которая помечает активное состояние
    private void pointStatement(int ind) {
        for(int i = 0; i < 4; i++) {
            point[i] = i == ind;
        }
    }
    // функция смены состояния
    void changeStatement() {
        int statementPlace = 0;
        // находим индекс активного состояния
        for(int i = 0; i < 4; i++) {
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
                if(a == 1 && b == 0) {
                    pointStatement(3);
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
                if(a == 1 && b == 1) {
                    pointStatement(1);
                    break;
                }
                if(a == 0 && b == 1) {
                    pointStatement(2);
                    break;
                }
            }
        }
        if(statementPlace == 2) {
            while(true) {
                // имитация случайно поступающих сигналов
                int a = (int) (Math.random() * (2));
                int b = (int) (Math.random() * (2));
                // сигналы для перехода в другие состояния
                if(a == 0 && b == 1) {
                    pointStatement(1);
                    break;
                }
                if(a == 1 && b == 1) {
                    pointStatement(0);
                    break;
                }
            }
        }
        if(statementPlace == 3) {
            while(true) {
                // имитация случайно поступающих сигналов
                int a = (int) (Math.random() * (2));
                int b = (int) (Math.random() * (2));
                // сигналы для перехода в другие состояния
                if(a == 0 && b == 0) {
                    pointStatement(2);
                    break;
                }
            }
        }
    }
    void showStatement() {
        int statementPlace = 0;
        for(int i = 0; i < 4; i++) {
            if(point[i]) {
                statementPlace = i;
            }
        }
        // выводим активное состояние
        if(statementPlace == 0) {
            A.show();
        }
        if(statementPlace == 1) {
            B.show();
        }
        if(statementPlace == 2) {
            C.show();
        }
        if(statementPlace == 3) {
            D.show();
        }
    }
}
