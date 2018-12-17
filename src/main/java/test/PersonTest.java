package test;

import entity.Person;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    private Person personTest;

    @Before
    public void PersonTest() {
        personTest = new Person();
        personTest.setBirthday(new LocalDate(2007,12,12));
    }
    @Test
    public void getAge() {
        assertEquals(10, personTest.getAge());
    }
}