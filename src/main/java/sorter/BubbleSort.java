package sorter;

import entity.Person;
import repository.PersonRepository;

import java.util.Comparator;

public class BubbleSort implements ISorting {

    public void sort(Person[] persones, Comparator<Person> comparator) {
        for(int i = persones.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( comparator.compare(persones[j],persones[j+1]) > 0){
                    Person tmp = persones[j];
                    persones[j] = persones[j+1];
                    persones[j+1] = tmp;
                }
            }
        }
    }
}
