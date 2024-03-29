package code.oneToMany;

import java.util.Set;

public class OneToManyRunner {

    public static void main(String[] args) {
        OwnerRepository ownerRepository = new OwnerRepository();

        ownerRepository.deleteAll();

        Owner owner1 = ownerRepository.insertData(
                ExampleData.someOwner1(),
                Set.of(ExampleData.somePet1(), ExampleData.somePet2()));

        Owner owner2 = ownerRepository.insertData(
                ExampleData.someOwner1(),
                Set.of(ExampleData.somePet3(), ExampleData.somePet4()));

    }
}
