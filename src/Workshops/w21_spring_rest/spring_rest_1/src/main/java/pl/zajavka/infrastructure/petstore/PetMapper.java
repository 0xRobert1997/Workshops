package pl.zajavka.infrastructure.petstore;

import org.springframework.stereotype.Component;
import pl.zajavka.infrastructure.petstore.model.Category;

import java.util.Optional;

@Component
public class PetMapper {

                    // przyjmuje Pet z folderu który znajduje się w build/generated-sources/openapi/src/main...
                    // który jest wygenerowany przez swaggera
    public Pet map(pl.zajavka.infrastructure.petstore.model.Pet pet) {
        return Pet.builder()
                .id(pet.getId())
                .name(pet.getName())
                .category(Optional.ofNullable(pet.getCategory()).map(Category::getName).orElse(null))
                .build();
    }
}
