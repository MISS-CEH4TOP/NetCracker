package sorter;

import entity.Person;
import repository.PersonRepository;

import java.util.Comparator;

public class SelectionSort implements ISorting {
    public  void sort(Person[] persones, Comparator<Person> comparator){
        for (int i = 0; i < persones.length-1; i++) {
            Person min = persones[i];
            int min_i = i;
            for (int j = i+1; j < persones.length; j++) {
                if ( comparator.compare(persones[j],min) > 0) {
                    min = persones[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                Person tmp = persones[i];
                persones[i] = persones[min_i];
                persones[min_i] = tmp;
            }
        }
    }
}
