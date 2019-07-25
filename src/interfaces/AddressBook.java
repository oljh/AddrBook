package interfaces;

import objects.Person;

public interface AddressBook {

    //Добавить
    void add(Person person);

    //Изменить запись
    void update(Person person);

    // Удалить запись
    void delete(Person person);

}
