public class Jazz {
    String lastname;
    String albumName;
    int circulation;
    int yearOfPublish;
    int price;
    void show() {
        System.out.printf("Исполнитель: %s\nНазвание альбома: %s\nТираж: %d\nГод выпуска альбома: %d\nСтоимость альбома: %dUAH\n\n",lastname, albumName, circulation, yearOfPublish, price);
    }
}
