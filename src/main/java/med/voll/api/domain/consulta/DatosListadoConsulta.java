package med.voll.api.domain.consulta;

import med.voll.api.domain.medico.Especialidad;

import java.time.LocalDateTime;

public record DatosListadoConsulta(Long id,
                                   Long idPaciente,
                                   Long idMedico,
                                   LocalDateTime fecha,
                                   Especialidad especialidad
) {

    public DatosListadoConsulta(Consulta consulta) {

        this(consulta.getId(),
                consulta.getPaciente().getId(),
                consulta.getMedico().getId(),
                consulta.getFecha(),
                consulta.getMedico().getEspecialidad()
        );

    }

}
