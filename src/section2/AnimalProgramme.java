package section2;

public class AnimalProgramme {

   
    static class Animal {
        
        private String name;
        private int age;

        
        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

       
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        
        public void makeSound() {
            System.out.println("Animal makes a sound");
        }

        public void showInfo() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    
    static class Dog extends Animal {
        private String breed;

       
        public Dog(String name, int age, String breed) {
            super(name, age);
            this.breed = breed;
        }

        
        public String getBreed() {
            return breed;
        }

        public void setBreed(String breed) {
            this.breed = breed;
        }

     
        @Override
        public void makeSound() {
            System.out.println("Woof Woof!");
        }

        @Override
        public void showInfo() {
            super.showInfo();  
            System.out.println("Breed: " + breed);
        }
    }

    
    static class Cat extends Animal {
        private String color;

        
        public Cat(String name, int age, String color) {
            super(name, age); // Calling the parent (Animal) constructor
            this.color = color;
        }

        
        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

       
        @Override
        public void makeSound() {
            System.out.println("Meow Meow!");
        }

        
        @Override
        public void showInfo() {
            super.showInfo();  
            System.out.println("Color: " + color);
        }
    }

    public static void main(String[] args) {
       
        Dog dog = new Dog("Buddy", 5, "Golden Retriever");
        Cat cat = new Cat("Whiskers", 3, "Gray");

        
        System.out.println("Dog Details:");
        dog.showInfo(); 
        dog.makeSound();

        System.out.println("\nCat Details:");
        cat.showInfo(); 
        cat.makeSound();
    }
}
