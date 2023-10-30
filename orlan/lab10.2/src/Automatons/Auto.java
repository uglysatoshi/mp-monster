package Automatons;
// класс предок для автоматов нужных по заданию
// для удобного компанования разных автоматов
// в одном массиве
public class Auto {
    public boolean[] mark = new boolean[3];
    public void nextState(String str) {} // функция перевода в следюущее состояние
    public void showCurrentState() {} // функция вывода нынешнего значения автомата
    // функция выделения активного автомата
    public void markState(String str) {
        if(str.equals("A")) forMark(0);
        if(str.equals("B")) forMark(1);
        if(str.equals("C")) forMark(2);
    }
    // функция нахождения индекса активного состояния
    public int findState() {
        int statePlace = 0;
        for(int i = 0; i < mark.length; i++) {
            if(mark[i]) {
                statePlace = i;
            }
        }
        return statePlace;
    }
    public void forMark(int index) { // подфункция для выделения активного автомата
        for(int i = 0; i < mark.length; i++) {
            mark[i] = i == index;
        }
    }
}
