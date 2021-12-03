package ru.alishev.springcourse.dao;

import org.springframework.stereotype.Controller;
import ru.alishev.springcourse.people.Person;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonDAO {
    private static int PEOPLE_COUNT;
    public List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom"  , "Tom@email.com" , 20 ));
        people.add(new Person(++PEOPLE_COUNT, "Dod" , "Dod@email.com", 50));
        people.add(new Person(++PEOPLE_COUNT,"Vladik", "Vladik@email.com", 30 ));
        people.add(new Person(++PEOPLE_COUNT,"Alina", "Alina@email.com", 28 ));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
    public  void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public  void updata(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }
    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }
}
