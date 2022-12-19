package Builder;

public class Main {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();

        System.out.println("Есть возраст: " + mom.getName() + " " + mom.hasAge());
        System.out.println("Есть адрес: " + mom.getName() + " " + mom.hasAddress());

        System.out.println("Имя: " + mom.getName());
        System.out.println("Фамилия: " + mom.getSurname());
        System.out.println("Возраст: " + mom.getAge());
        System.out.println("Адрес: " + mom.getAddress());

        mom.setAddress("Москва");
        System.out.println("Новый адрес проживания: " + mom.getName() + " "
                + mom.getSurname() + " адрес: " + mom.getAddress());

        mom.happyBirthday();
        System.out.println("С днем рождения! " + mom.getName() + " "
                + mom.getSurname() + " возраст: " + mom.getAge());
//---------------------------------------------------------------------------------------------------------------------
        Person dad = new PersonBuilder()
                .setName("Алекс")
                .setSurname("Вольф")
                .build();
        System.out.println(dad);

        System.out.println("Есть возраст: " + dad.getName() + " " + dad.hasAge());
        System.out.println("Есть адрес: " + dad.getName() + " " + dad.hasAddress());

        dad.setAddress("Москва");
        System.out.println("Новый адрес проживания: " + dad.getName() + " "
                + dad.getSurname() + " адрес: " + dad.getAddress());

        dad.happyBirthday();
        System.out.println("С днем рождения! " + dad.getName() + " "
                + dad.getSurname() + " возраст: " + dad.getAge());
        System.out.println("Есть возраст: " + dad.getName() + " " + dad.hasAge());
        System.out.println("Есть адрес: " + dad.getName() + " " + dad.hasAddress());
//---------------------------------------------------------------------------------------------------------------------
        Person son = mom.newChildBuilder()
                .setName("Макс")
                .build();

        System.out.println(son);
        System.out.println("У матери " + mom.getName() + " есть сын, " + son.getName());
//---------------------------------------------------------------------------------------------------------------------
        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
//---------------------------------------------------------------------------------------------------------------------
    }
}