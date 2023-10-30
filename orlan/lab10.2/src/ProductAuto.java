import Automatons.*;

import java.util.Scanner;

public class ProductAuto {
    private final AutoA A;
    private final AutoB B;
    private final AutoC C;
    private int mark; // значение для обозначения автомата произведения
    public ProductAuto() {
        // определяем три автомата из задания
        this.A = new AutoA();
        this.B = new AutoB();
        this.C = new AutoC();
        mark = -1;
    }
    // находим автомат произведения
    void getProduct() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку состоящую из алфавита {A,B,C}: ");
        String finalState = in.next();
        if(AcceptationChar(finalState)) {
            if (finalState.charAt(finalState.length() - 1) == 'A') mark = 0;
            if (finalState.charAt(finalState.length() - 1) == 'B') mark = 1;
            if (finalState.charAt(finalState.length() - 1) == 'C') mark = 2;
        }
    }
    // функция проверки строки
    private boolean AcceptationNumber(String s) {
        for(int i = 0; i < s.length(); i++) {
            if((s.charAt(i) != '0' && s.charAt(i) != '1' ) || s.length() % 2 != 0)
                return false;
        }
        return true;
    }
    // функция вызова рекурсии для прохождения по всей строке сигнала
    void usageProduct() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите сигнал состоящий из алфавита {0,1} и кратен 2: ");
        String finalState = in.next();
        while(!AcceptationNumber(finalState)) {
            System.out.println("Значение не подходит по одному из параметров");
            System.out.print("Введите сигнал состоящий из алфавита {0,1} и кратен 2: ");
            finalState = in.next();
        }
        usageProductRecursion(finalState);
    }
    // Рекурсивная функция для прохождения по все строке
    private void usageProductRecursion(String state) {
        if(mark == 0) {
            if(state.length() >= 2) {
                String newState = state.substring(0, 2);
                state = state.substring(2);
                A.nextState(newState);
                A.showCurrentState();
                usageProductRecursion(state);
            }
        }
        if(mark == 1) {
            if(state.length() >= 2) {
                String newState = state.substring(0, 2);
                state = state.substring(2);
                B.nextState(newState);
                B.showCurrentState();
                usageProductRecursion(state);
            }
        }
        if(mark == 2) {
            if(state.length() >= 2) {
                String newState = state.substring(0, 2);
                state = state.substring(2);
                C.nextState(newState);
                C.showCurrentState();
                usageProductRecursion(state);
            }
        }

    }
    // функция проверки строки
    private boolean AcceptationChar(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != 'A' && s.charAt(i) != 'B' && s.charAt(i) != 'C')
                return false;
        }
        return true;
    }
}