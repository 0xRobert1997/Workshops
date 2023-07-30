package pl.zajavka.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.zajavka.business.dao.CepikVehicleDao;
import pl.zajavka.domain.CepikVehicle;
import pl.zajavka.domain.exception.NotFoundException;
import pl.zajavka.domain.exception.ProcessingException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
@AllArgsConstructor
public class CepikService {

    private final CepikVehicleDao cepikVehicleDao;

    public CepikVehicle findRandom(final LocalDate dateFrom, final LocalDate dateTo) {
        log.debug("looking for random Cepik vehicle, first registration between: [{}] and [{}]", dateFrom, dateTo);
        List<CepikVehicle> cepikVehicles = cepikVehicleDao.getCepikVehicles(dateFrom, dateTo);
        if (cepikVehicles.isEmpty()) {
            throw new ProcessingException(
                    String.format("CEPIK returned empty list for first registration between: [%s] and [%s]", dateFrom, dateTo));
        }
        return Optional.ofNullable(cepikVehicles.get(new Random().nextInt(cepikVehicles.size())))
                .map(anyVehicle -> cepikVehicleDao.getCepikVehicle(anyVehicle.getCepikId()))
                .orElseThrow(() -> new NotFoundException("Could not find random cepik vehicle"));
    }
}
