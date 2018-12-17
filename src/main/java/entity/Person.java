package entity;

import org.joda.time.LocalDate;
import org.joda.time.Years;
import repository.PersonRepository;

import java.util.Comparator;
import java.util.Objects;

/** Класс пользователя */
public class Person implements Comparable<Person>{

    /** Поле идентификатор пользователя */
    private int id;

    /** Поле ФИО пользователя */
    private String name;

    /** Поле пол пользователя */
    private Gender gender;

    /** Поле день рождения пользователя */
    private LocalDate birthday;


    /** Конструктор по умолчанию класса Person */
    public Person() {}

    /** Конструктор - создание нового объекта с определенными значениями
     * @param name - имя пользователя
     * @param gender - пол человека
     * @param brithday - день рождения
     */
    public Person(String name, Gender gender, LocalDate brithday) {
        this.name = name;
        this.gender = gender;
        this.birthday = brithday;
    }


    /**
     * Функция получения значения поля
     * @return возвращает идентификатор пользователя
     */
    public int getId() {
        return id;
    }

    /**
     * Функция задает значение полю идентификатора
     * @param id - идентификатор пользователя
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Функция получения значения поля
     * @return возвращает имя пользователя
     */
    public String getName() {
        return name;
    }

    /**
     * Функция задает значение полю
     * @param name - имя пользователя
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Функция получения значения поля имя
     * @return возвращает пол пользователя
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Функция задает значение полю пол
     * @param gender - пол пользователя
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Функция получения значения поля
     * @return возвращает дату рождения пользователя
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Функция задает значение полю
     * @param birthday - дата рождения
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * Функция вычисления значения поля возраста
     * @return возвращает возраст пользователя
     */
    public int getAge() {
        int age = birthday != null ? Years.yearsBetween(birthday, LocalDate.now()).getYears() : 0;
        return age;
    }


    /**
     *
     */
    public Comparator<Person> personComparatorId = (Person p1, Person p2)-> p1.getId() > p2.getId() ? 1 : p1.getId() < p2.getId() ? -1 : 0;
    public Comparator<Person> personComparatorName = (Person p1, Person p2)-> p1.getName().compareTo(p2.getName());
    public Comparator<Person> personComparatorAge = (Person p1, Person p2)-> p1.getAge() > p2.getAge() ? 1 : p1.getAge() < p2.getAge() ? -1 : 0;
    public Comparator<Person> personComparatorBirthday = (Person p1, Person p2)-> p1.getBirthday().compareTo(p2.getBirthday());


    /**
     * @param p переопределение метода compareTo (метод сравнивает строку с другим объектом)
     * @return возвращает в результате выполнения сравнения целое число:
     * - положительное, если вызывающий объект больше объекта, переданного в качестве параметра;
     * - отрицательное, если вызывающий объект меньше объекта, переданного в качестве параметра;
     * - нуль, если объекты равны.
     */
    @Override
    public int compareTo(Person p) {
        return name.compareTo(p.getName());
    }


    /**
     * Переопределение метода toString()
     * @return - возвращает объект в json формате
     */
    @Override
    public String toString() {
        return String.format("{id: %d, FIO: %s, gender: %s, birthday: %s, age: %d}",
                this.getId(), this.getName(), this.getGender(), this.getBirthday(), this.getAge());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name) &&
                gender == person.gender &&
                Objects.equals(birthday, person.birthday);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, gender, birthday);
    }
}
