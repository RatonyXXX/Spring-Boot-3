package med.voll.api.domain.consulta;

import med.voll.api.domain.medico.Especialidad;

import java.time.LocalDateTime;

public record DatosDetallesConsulta(Long id,
                                    Long idPaciente,
                                    Long idMedico,
                                    LocalDateTime fecha
) {

    public DatosDetallesConsulta(Consulta consulta) {

        this(consulta.getId(),
                consulta.getPaciente().getId(),
                consulta.getMedico().getId(),
                consulta.getFecha()
        );

    }

}
