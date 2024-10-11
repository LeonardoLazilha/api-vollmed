package voll.med.api_med.domain.consulta;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import voll.med.api_med.domain.consulta.validacoes.cancelamento.MotivoCancelamento;
import voll.med.api_med.domain.medico.Medico;
import voll.med.api_med.domain.paciente.Paciente;

import java.time.LocalDateTime;

@Entity(name = "Consulta")
@Table(name = "consultas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime data;

    private Boolean cancelada;

    @Enumerated(EnumType.STRING)
    MotivoCancelamento motivoCancelamento;

    public Consulta(Medico medico, Paciente paciente, LocalDateTime data) {
        this.medico = medico;
        this.paciente = paciente;
        this.data = data;
        this.cancelada = false;
    }

    public void cancelar(MotivoCancelamento motivoCancelamento) {
        this.cancelada = true;
        this.motivoCancelamento = motivoCancelamento;
    }
}
