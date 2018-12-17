package repository;

import entity.Person;
import interfaces.PersonInterface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;
import org.apache.log4j.Logger;
import sorter.BubbleSort;
import sorter.ISorting;
import sorter.SelectionSort;

/** Класс, реализующий основные методы для работы с пользователем*/
public class PersonRepository implements PersonInterface{

    // Инициализация логера
    static final Logger log = Logger.getLogger(PersonRepository.class);

    /** Идентификатор пользователя */
    private static int id = 1;

    /** Массив для хранения пользователей */
    Person[] persones = new Person[0];

    ISorting sorting = new BubbleSort();
    //ISorting selectSort = new SelectionSort(persones);

    public void sort (Comparator<Person> comparator) {
        sorting.sort(persones, comparator);
        printPersones(persones);
    }

    public void sortById () {
        sorting.sort(persones, (p1, p2)->p1.getId() - p2.getId());
        printPersones(persones);
    }

    public void sortByAge () {
        sorting.sort(persones, (p1, p2)->p1.getAge() - p2.getAge());
        printPersones(persones);
    }

    /** Метод добавления пользователя
     * @param person - объект класса Person
     */
    public void create(Person person) {
        if (person.getId() == 0) person.setId(PersonRepository.id++);
        persones = Arrays.copyOf(persones, persones.length + 1);
        persones[persones.length - 1] = person;
        log.info("create person");
        printPersones(persones);
        System.out.println("------------create------------------------");
        log.error(person);
    }

    /** Метод удалния пользователя
     * @param person - объект класса Person
     */
    public void delete(Person person) {
        int i;
        for (i = 0; i < persones.length; i++){
            if(persones[i].getId() == person.getId()) break;
        }
        if (i != persones.length) {
            for (int k = i; k < persones.length-1; k++) {
                persones[k] = persones[k+1];
            }
            persones = Arrays.copyOf(persones, persones.length - 1);
            printPersones(persones);
        }
        else System.out.println("Error!");
        System.out.println("------------delete------------------");
    }

    /** Метод поиска пользователя по идентификатору
     * @param id - идентификатор пользоватея
     * @return возврящает пользователя
     */
    public Person get(int id) {
        for (int i = 0; i< persones.length; i++){
            if(persones[i].getId() == id) return persones[i];
        }
        return null;
    }

    public Person[] search(Predicate<Person> filter) {
        Person[] person = new Person[0];
        for (int i = 0; i< persones.length; i++){
            if(filter.test(persones[i]))
            {
                person = Arrays.copyOf(person, person.length + 1);
                person[person.length - 1] = persones[i];
            }
        }
        printPersones(person);
        return person;
    }


    /** Метод вывода данных пользователей в консоль
     * @param person - объект класса Person
     */
    public void printPersones(Person[] person) {
        if(person != null) {
            for(int i = 0; i<person.length; i++) {
                System.out.println("id: " + person[i].getId() + "; FIO: " + person[i].getName() +
                        "; gender: " + person[i].getGender() + "; birthday: " + person[i].getBirthday() +
                        "; age: " + person[i].getAge());
            }
        }
    }

    /** Метод вывода данных пользователя в консоль
     * @param person - объект класса Person
     */
    public void printPerson(Person person) {
        if (person != null) {
            System.out.println("id: " + person.getId() + "; FIO: " + person.getName() +
                    "; gender: " + person.getGender() + "; birthday: " + person.getBirthday() +
                    "; age: " + person.getAge());
        }
        else System.out.println("Пользователь не найден");
    }

    public Person[] getPersones() {
        return persones;
    }
}
