package entity;

public class Author {
    private String fName;
    private String lName;
    private String nif;
    private int age;

    public Author(String fName, String lName, String nif, int age) {
        this.fName = fName;
        this.lName = lName;
        this.nif = nif;
        this.age = age;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getFullName(){
        return fName + " " + lName;
    }

    public String getNif() {
        return nif;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return fName + " " + lName + " (NIF: " + nif + ", Idade: " + age + ")";
    }
}