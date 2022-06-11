 class Human {

    private char gender;
    private int age;

    //constructor
    Human()
    {
        System.out.println("I'm a constructor called automatically");
    }

    //parameterized constructor
    Human(int age,char gender)
    {
        this.age= age;
        this.gender=gender;
    }

    //copy constructor
    Human(Human human)
    {
        System.out.println("Im in copy constructor");
        this.age = human.age;
        this.gender=human.gender;
    }

   // getter and setter
    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Main{
    public static void main(String[] args) {

        Human obj = new Human(23,'f');

        Human obj1 = new Human(obj);

        System.out.println(obj1.getAge());

    }
}


