package voll.med.api_med.domain.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("SELECT p.ativo FROM Paciente p WHERE p.id = :idPaciente")
    Boolean findAtivoById(Long idPaciente);
}
