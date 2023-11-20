package br.com.wk.resources;

import br.com.wk.core.dto.*;
import br.com.wk.core.usecases.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonResource {

    private final IGetPersonCounterByEstado getPersonCounterByEstado;

    private final IGetPersonImcByAgeRange getPersonImcByAgeRange;

    private final IGetPercentOverweightByGender getPercentOverweightByGender;

    private final IGetPersonBloodTypeByAgeAverage getPersonBloodTypeByAgeAverage;

    private final IGetPersonBloodTypeReceptorsAmount getPersonBloodTypeReceptorsAmount;

    @GetMapping("/amount-by-estado")
    public ResponseEntity<List<PersonCounterByEstadoDto>> getAmountByEstado() {
        return ResponseEntity.ok(getPersonCounterByEstado.call());
    }

    @GetMapping("/imcs-by-age-range")
    public ResponseEntity<List<PersonImcRangeByAge>> getListImcRangeByAge() {
        return ResponseEntity.ok(getPersonImcByAgeRange.call());
    }

    @GetMapping("/percent-overweight")
    public ResponseEntity<PersonPercentOverweight> getPercentOverweight() {
        return ResponseEntity.ok(getPercentOverweightByGender.call());
    }

    @GetMapping("/blood-type-age-average")
    public ResponseEntity<List<PersonBloodTypeByAvgAge>> getBloodTypeAgeAverage() {
        return ResponseEntity.ok(getPersonBloodTypeByAgeAverage.call());
    }

    @GetMapping("/blood-type-receptors-amount")
    public ResponseEntity<List<PersonBloodTypeReceptorsAmount>> getBloodTypeReceptorsAmount() {
        return ResponseEntity.ok(getPersonBloodTypeReceptorsAmount.call());
    }
}
