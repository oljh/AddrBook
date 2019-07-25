package objects;

public class Person {


    private String fio;

    public Person(String fio, String phone) {
        this.fio = fio;
        this.phone = phone;
    }

    private String phone;



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

}
