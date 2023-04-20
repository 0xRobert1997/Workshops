package Exercises.zad9_Proxy;

public class ProxyImage implements Image {

    String image;

    Boolean isLoaded;
    public ProxyImage(String image) {
        this.image = image;
        this.isLoaded = false;
    }

    @Override
    public void display() {
        if (!this.isLoaded) {
            this.setLoaded(true);
            System.out.println("Wyświetlanie z załadowaniem z dysku");
        } else {
            System.out.println("Wyświetlanie bez ładowania z dysku");
        }

    }

    public void setLoaded(Boolean loaded) {
        isLoaded = loaded;
    }
}
