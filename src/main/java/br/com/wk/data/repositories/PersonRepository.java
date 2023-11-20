package br.com.wk.data.repositories;

import br.com.wk.core.dto.PersonBloodTypeByAvgAge;
import br.com.wk.core.dto.PersonBloodTypeReceptorsAmount;
import br.com.wk.core.dto.PersonCounterByEstadoDto;
import br.com.wk.core.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, String> {

    @Query("SELECT new br.com.wk.core.dto.PersonCounterByEstadoDto(p.estado, COUNT(p)) FROM PersonEntity p GROUP BY p.estado")
    List<PersonCounterByEstadoDto> countByEstado();

    @Query("SELECT MAX(FUNCTION('TIMESTAMPDIFF', YEAR, p.dataNascimento, CURRENT_DATE)) FROM PersonEntity p")
    Optional<Integer> findMaxAge();

    @Query("SELECT SUM(p.peso / (p.altura * p.altura)) / COUNT(p) FROM PersonEntity p WHERE FUNCTION('TIMESTAMPDIFF', YEAR, p.dataNascimento, CURRENT_DATE) > :startAge and FUNCTION('TIMESTAMPDIFF', YEAR, p.dataNascimento, CURRENT_DATE) < :endAge")
    Optional<Float> avgImcByAgeRange(@Param("startAge") Integer startAge, @Param("endAge") Integer endAge);


    @Query("SELECT (CAST(COUNT(p) AS FLOAT) / (SELECT CAST(COUNT(p2) AS FLOAT) FROM PersonEntity p2 WHERE p2.sexo = 'Feminino')) FROM PersonEntity p WHERE p.sexo = 'Feminino' AND (p.peso / (p.altura * p.altura)) > 30 UNION SELECT (CAST(COUNT(p) AS FLOAT) / (SELECT CAST(COUNT(p2) AS FLOAT) FROM PersonEntity p2 WHERE p2.sexo = 'Masculino')) FROM PersonEntity p WHERE p.sexo = 'Masculino' AND (p.peso / (p.altura * p.altura)) > 30")
    List<Float> findOverweightGender();

    @Query("SELECT new br.com.wk.core.dto.PersonBloodTypeByAvgAge(p.tipoSanguinio, CAST((SUM(FUNCTION('TIMESTAMPDIFF', YEAR, p.dataNascimento, CURRENT_DATE)) / COUNT(p)) AS INTEGER)) FROM PersonEntity p GROUP BY p.tipoSanguinio")
    List<PersonBloodTypeByAvgAge> findBloodTypeByAgeAverage();

    @Query("SELECT new br.com.wk.core.dto.PersonBloodTypeReceptorsAmount(p.tipoSanguinio, (SELECT CAST((COUNT(p2) - 1) AS INTEGER) FROM PersonEntity p2 WHERE p2.peso > 50 AND (FUNCTION('TIMESTAMPDIFF', YEAR, p2.dataNascimento, CURRENT_DATE) >= 16 AND FUNCTION('TIMESTAMPDIFF', YEAR, p2.dataNascimento, CURRENT_DATE) <= 69) AND (p.tipoSanguinio = 'A+' AND (p2.tipoSanguinio IN ('A+', 'A-', 'O+', 'O-'))) OR (p.tipoSanguinio = 'A-' AND (p2.tipoSanguinio IN ('A-', 'O-'))) OR (p.tipoSanguinio = 'B+' AND (p2.tipoSanguinio in ('B+', 'B-', 'O+', 'O-'))) OR (p.tipoSanguinio = 'B-' AND (p2.tipoSanguinio in ('B-', 'O-'))) OR (p.tipoSanguinio = 'AB+' AND (p2.tipoSanguinio in ('A+', 'B+', 'O+', 'AB+', 'A-', 'B-', 'O-', 'AB-'))) OR (p.tipoSanguinio = 'AB-' and (p2.tipoSanguinio in ('A-', 'B-', 'O-', 'AB-'))) OR (p.tipoSanguinio = 'O+' and (p2.tipoSanguinio in ('O+', 'O-'))) OR (p.tipoSanguinio = 'O-' and (p2.tipoSanguinio in ('O-'))))) FROM PersonEntity p GROUP BY p.tipoSanguinio ORDER BY p.tipoSanguinio")
    List<PersonBloodTypeReceptorsAmount> findBloodTypeReceptorsAmount();
}
