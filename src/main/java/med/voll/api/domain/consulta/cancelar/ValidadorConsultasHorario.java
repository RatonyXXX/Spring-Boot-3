package med.voll.api.domain.consulta.cancelar;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosCancelarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

// Desafio
@Component
public class ValidadorConsultasHorario implements ValidadorCancelarConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public void validar(DatosCancelarConsulta datos) {
        var consulta = consultaRepository.getReferenceById(datos.id());
        var ahora = LocalDateTime.now();
        var diferenciaHoras = Duration.between(ahora, consulta.getFecha()).toHours();

        if (diferenciaHoras < 24) {
            throw new ValidationException("Consulta solo puede ser cancelada antes de 24 horas");
        }

    }

}
