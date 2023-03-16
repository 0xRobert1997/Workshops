package Structural.Adapter;

public class Main {

    public static void main(String[] args) {

        Dimension dimension = new SonyTV();
        DimensionAdapter dimensionAdapter = new DimensionAdapterImpl(dimension);

        System.out.println("Original: " + dimension.getDimension());
        System.out.println("Adapted: " + dimensionAdapter.getDimension());
    }
}
