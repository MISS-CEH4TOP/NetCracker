package test;

import entity.Gender;
import entity.Person;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import repository.PersonRepository;

import static org.junit.Assert.*;

public class PersonRepositoryTest {
    private PersonRepository personRepositoryTest;
    private Person[] person = new Person[2];

    @Before
    public void PersonRepositoryTest() {
        personRepositoryTest = new PersonRepository();
        person[0] = new Person("Andreeva", Gender.female,new LocalDate(1977,5,21));
        person[1] = new Person("Popova", Gender.female,new LocalDate(1997,1,6));
        personRepositoryTest.create(person[0]);
        personRepositoryTest.create(person[1]);
    }

    @Test
    public void search() {
        assertEquals(person[0], personRepositoryTest.search(x -> x.getAge() == 41)[0]);
    }

}