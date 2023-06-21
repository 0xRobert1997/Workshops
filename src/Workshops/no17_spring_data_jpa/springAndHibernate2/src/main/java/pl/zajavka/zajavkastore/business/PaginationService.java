package pl.zajavka.zajavkastore.business;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.zajavka.zajavkastore.infrastructure.database.entity.CustomerEntity;
import pl.zajavka.zajavkastore.infrastructure.database.jpaRepositories.CustomerDatabaseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PaginationService {
    private final CustomerDatabaseRepository customerDatabaseRepository;

    public void call() {
        int pageSize = 8;
        paginate(0, pageSize);
        paginate(1, pageSize);
        paginate(2, pageSize);
        paginate(3, pageSize);
    }

    private void paginate(int pageNumber, int pageSize) {
        System.out.printf("###PAGINATION PageNum: %s, PageSize: %s", pageNumber, pageSize);

        Sort sort = Sort.by("name").ascending()
                .and(Sort.by("dateOfBirth").ascending());

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<CustomerEntity> page = customerDatabaseRepository.findAll(pageable);
        List<CustomerEntity> content = page.getContent();

        if (content.isEmpty()) {
            System.out.println("PAGE IS EMPTY");
        }

        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        System.out.println(page.getNumberOfElements());
        System.out.println(page.getSize());
        System.out.println(page.isLast());
        System.out.println(page.isFirst());

    }
}
