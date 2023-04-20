package code;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Value;

import java.util.ArrayList;

//@Data
@Value

public class Cat {


    String name;
    ArrayList<Integer> List;

    public ArrayList<Integer> getList() {
        return new ArrayList<>(this.List);
    }
}
