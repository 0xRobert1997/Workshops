package Workshops.no6_lombok.Exercises;




public final class ex4 {
    private final String name;
    private final String surname;

    public ex4(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ex4 ex4)) return false;

        if (getName() != null ? !getName().equals(ex4.getName()) : ex4.getName() != null) return false;
        return getSurname() != null ? getSurname().equals(ex4.getSurname()) : ex4.getSurname() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "ex4{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
