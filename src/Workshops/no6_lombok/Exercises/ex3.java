package Workshops.no6_lombok.Exercises;

public class ex3 {

    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ex3 ex3)) return false;

        if (getName() != null ? !getName().equals(ex3.getName()) : ex3.getName() != null) return false;
        return getSurname() != null ? getSurname().equals(ex3.getSurname()) : ex3.getSurname() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ex3{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

}
