import annotations.SortingAnnotationAnalyzer;
import entity.Gender;
import entity.Person;
import org.joda.time.LocalDate;
import repository.PersonRepository;
import sorter.BubbleSort;
import sorter.SelectionSort;

public class Main {
    public static void  main(String[] args) {
        PersonRepository personRepository = new PersonRepository();
        SortingAnnotationAnalyzer.analyze(personRepository);

        Person person = new Person("Ivanov", Gender.male,new LocalDate(1993,12,1));
        Person person1 = new Person("Test", Gender.male,new LocalDate(1995,9,1));
        personRepository.create(new Person("Vasilev", Gender.male,new LocalDate(1996,3,17)));
        personRepository.create(new Person("Popova", Gender.female,new LocalDate(1997,1,6)));
        personRepository.create(new Person("Tarasova", Gender.female,new LocalDate(1996,5,13)));
        personRepository.create(new Person("Andreeva", Gender.female,new LocalDate(1977,5,21)));
        personRepository.create(person);
        personRepository.create(new Person("Petrova", Gender.female,new LocalDate(1985,11,26)));
        personRepository.delete(person);
        personRepository.delete(person1);
        personRepository.create(new Person("IvanovNew", Gender.male,new LocalDate(2007,12,12)));
        personRepository.printPerson(personRepository.get(4));


        System.out.println("------------bubbleSortName------------------");
        personRepository.sort(person.personComparatorName);
        System.out.println("------------bubbleSortId------------------");
        personRepository.sort(person.personComparatorId);
        System.out.println("------------bubbleSortAge------------------");
        personRepository.sort(person.personComparatorAge);
        System.out.println("------------bubbleSortBirthday------------------");
        personRepository.sort(person.personComparatorBirthday);
        System.out.println("------------bubbleSort------------------");
        personRepository.sort(Person::compareTo);


        System.out.println("------------bubbleSortId2------------------");
        personRepository.sortById();

        System.out.println("------------search-----------------");
        personRepository.search(x -> x.getAge() >= 41);
        //System.out.println(person);
        //personRepository.sort((Person p1, Person p2) -> { return  p1.getId() > p2.getId() && p1.getAge() > p2.getAge() ?  1 : 0; });

    }
}
