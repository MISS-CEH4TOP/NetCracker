package entity;

import org.joda.time.LocalDate;
import org.joda.time.Years;

/** Класс пользователя */
public class Person {
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
}
