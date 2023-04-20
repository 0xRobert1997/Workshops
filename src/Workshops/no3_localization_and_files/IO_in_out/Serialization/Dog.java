package Workshops.no3_localization_and_files.IO_in_out.Serialization;

import java.io.Serializable;

public class Dog implements Serializable {
    private static final long SerialVersionUID = 1L;

    private transient String name = "fieldName";

    private String nickName = "fieldNickName";
    static int age = 10;

    {
        this.name = "defaultName";
        this.nickName = "defaultNickName";
        System.out.println("Callin init block");
    }

    static {
        age = 100;
        System.out.println("Callin static init block");
    }

    public Dog() {
        this.name = "constructorDefaultName";
        this.nickName = "contructorDefaultNickName";
        System.out.println("callin default constructor");
    }

    public Dog(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
        System.out.println("Callin normal constructor");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
