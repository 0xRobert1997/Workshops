package Workshops.no3_localization_and_files.IO_in_out.Serialization;

import java.io.Serializable;

public class Persian extends Cat implements Serializable {

    public Persian() {
        System.out.println("Callin Persian default constructor");
    }

    public Persian(String name, String nickName) {
        super(name, nickName);
        System.out.println("Callin Persian normal constructor");

    }
}
