package code.oneToMany;

public class ExampleData {

    static Owner someOwner1() {
        return Owner.builder()
                .name("Stefan")
                .surname("zajavka")
                .phone("666-666-666")
                .email("something@xd")
                .build();
    }
    static Owner someOwner2() {
        return Owner.builder()
                .name("Stefan2")
                .surname("zajavka")
                .phone("696-696-696")
                .email("something@xd")
                .build();
    }

    static Pet somePet1() {
        return Pet.builder()
                .name("Fafik")
                .breed(Breed.CAT)
                .build();
    }
    static Pet somePet2() {
        return Pet.builder()
                .name("Mafik")
                .breed(Breed.MONKEY)
                .build();
    }

    static Pet somePet3() {
        return Pet.builder()
                .name("Tofik")
                .breed(Breed.CAT)
                .build();
    }

    static Pet somePet4() {
        return Pet.builder()
                .name("Pepegacz")
                .breed(Breed.DOG)
                .build();
    }
}
