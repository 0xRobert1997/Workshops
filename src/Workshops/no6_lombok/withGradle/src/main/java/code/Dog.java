package code;

import lombok.*;


@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
// @AllArgsConstructor(staticName = "of")
@ToString(onlyExplicitlyIncluded = true)
// wywołowanie np. Equals/hashcode z klasy wyżej -> (callSuper = true)
@EqualsAndHashCode
@With

// @Data
// - jeśli pole nie jest oznaczone @NoNull albo final to @Data nie wygeneruje konstruktora z tym polem

// @Value
// sprawie że klasa jest immutable
// wszystkie pola domyślnie stają się private final
// w przypadku gdy polem jest np lista to wygenerowany geter zwraca this.list zamiast kopii <-!!!!

public class Dog {

    private final String name;

    @Getter(value = AccessLevel.NONE)
    private final Integer age;


    @EqualsAndHashCode.Exclude
    @ToString.Include
    private @NonNull Owner owner;

    private void consume(@NonNull String something) {
        System.out.println("Consuming: " + something);
    }
}
