package sorter;

import entity.Person;

import java.util.Comparator;

public interface ISorting {
    void sort(Person[] persones, Comparator<Person> comparator);
}
