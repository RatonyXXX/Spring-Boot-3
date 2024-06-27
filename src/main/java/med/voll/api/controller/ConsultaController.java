package med.voll.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import jakarta.validation.Valid;

import med.voll.api.domain.consulta.*;

import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.DatosDetallesPaciente;
import med.voll.api.domain.paciente.DatosListadoPaciente;
import med.voll.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
@SuppressWarnings("all")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultaService service;

    @Autowired
    private ConsultaRepository consultaRepository;


    @PostMapping
    @Transactional
    @Operation(
            summary = "registra una consulta en la base de datos",
            description = "oli"
          //  tags = { "consulta", "post" }
    )
    public ResponseEntity agendar(@RequestBody @Valid DatosAgendarConsulta datos) throws ValidacionDeIntegridad {

        var response = service.agendar(datos);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(summary = "Obtiene el listado de las consultas")
    public ResponseEntity<Page<DatosListadoConsulta>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacion) {

        var page = consultaRepository.findAll(paginacion).map(DatosListadoConsulta::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    @Operation(summary = "obtiene los detalles de la consulta con el ID indicado")
    public ResponseEntity detallar(@PathVariable Long id) {

        var consulta = consultaRepository.getReferenceById(id);

        return ResponseEntity.ok(new DatosDetallesConsulta(consulta));
    }

    @DeleteMapping
    @Transactional
    @Operation(summary = "Elimina un paciente a partir del ID")
    public ResponseEntity cancelarConsulta(@RequestBody @Valid DatosCancelarConsulta datos) throws ValidacionDeIntegridad {

        service.cancelarConsulta(datos);

        return ResponseEntity.noContent().build();
    }

}