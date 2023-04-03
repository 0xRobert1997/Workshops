package Workshops.powtórki;

public class Tuple {

    private Object key;
    private Object value;

    public Tuple(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
    public Object getKey() {
        return key;
    }
    public Object getValue() {
        return value;
    }
    public void setKey(Object key) {
        this.key = key;
    }
    public void setValue(Object value) {
        this.value = value;
    }
}
