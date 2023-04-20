package Workshops.no3_localization_and_files.IO_in_out.Serialization;

public class Door {

    private static final Long serialBersionUID = 1L;

    private final String which;

    public Door(String which) {
        this.which = which;
    }

    public String getWhich() {
        return which;
    }

    @Override
    public String toString() {
        return "Door{" +
                "which='" + which + '\'' +
                '}';
    }
}
