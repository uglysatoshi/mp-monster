package Hard;

// класс наследник - реалист
public class Real extends Person{
    public void Hello(Person person) {
        // различные приветствия исходя из возраста собеседника
        if(Math.abs(age - person.age) > 5)
            System.out.println(name + ": Здравствуй, " + person.name);
        else
            System.out.println(name + ": Привет, " + person.name);
    }
    public void About() {
        System.out.println("Меня зовут " + name + ", мой возраст " + age + " лет, я реалист");
    }
}
