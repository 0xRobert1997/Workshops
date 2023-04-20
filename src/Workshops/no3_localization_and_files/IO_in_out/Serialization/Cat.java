package Workshops.no3_localization_and_files.IO_in_out.Serialization;

import java.io.Serializable;

public class Cat  {
    private static final long SerialVersionUID = 1L;

    private transient String name = "fieldName";

    private String nickName = "fieldNickName";
    static int age = 10;

    {
        this.name = "defaultName";
        this.nickName = "defaultNickName";
        System.out.println("Callin CAT init block");
    }

    static {
        age = 100;
        System.out.println("Callin CAT static init block");
    }

    public Cat() {
        this.name = "constructorDefaultName";
        this.nickName = "contructorDefaultNickName";
        System.out.println("callin CAT default constructor");
    }

    public Cat(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
        System.out.println("Callin CAT normal constructor");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
