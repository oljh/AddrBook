package interfaces.impls;

import interfaces.AddressBook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import objects.Person;

public class CollectionAddressBook implements AddressBook {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {
        personList.remove(person);
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void print(){
        int number = 0;
        System.out.println();
        for(Person person: personList){
            number++;
            System.out.println(number + ")  fio = " + person.getFio() + "; phone =" + person.getPhone());
        }
    }


    public void fillTestData(){
        personList.add(new Person("Иван", "78456487543"));
        personList.add(new Person("Петр", "7845345587543"));
        personList.add(new Person("Света", "72343"));
        personList.add(new Person("Катя", "782345543"));
        personList.add(new Person("Антон", "34557543"));
        personList.add(new Person("Лена", "34587543"));

    }
}

