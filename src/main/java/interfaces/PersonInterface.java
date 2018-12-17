package interfaces;

import entity.Person;

import java.util.Comparator;
import java.util.function.Predicate;

/** Интерфейс методов для работы с пользователем */
public interface PersonInterface  {
    /** Метод поиска пользователя по идентификатору
     * @param id - идентификатор пользоватея
     * @return возврящает пользователя
     */
    Person get(int id);

    /** Метод добавления пользователя
     * @param person - объект класса Person
     */
    void create(Person person);

    /** Метод удалния пользователя
     * @param person - объект класса Person
     */
    void delete(Person person);

    /** Метод вывода данных пользователя в консоль
     * @param person - объект класса Person
     */
    void printPerson(Person person);

    Person[] search(Predicate<Person> filter);
}
