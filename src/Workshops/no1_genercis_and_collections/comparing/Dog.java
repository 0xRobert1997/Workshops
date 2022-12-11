package Workshops.no1_genercis_and_collections.comparing;

public class Dog implements Comparable<Dog>{

    private final Integer id;
    private final String name;

    public Dog(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog: " + name + "_" + id;
    }

    @Override
    public int compareTo(Dog o) {
        int result =  this.name.compareTo(o.name);
        if (result != 0) {
            return result;
        }
        return o.id - this.id;
    }
}
