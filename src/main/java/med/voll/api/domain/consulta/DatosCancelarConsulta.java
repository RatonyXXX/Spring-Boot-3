package med.voll.api.domain.consulta;

public record DatosCancelarConsulta(Long id,
                                    //Long idPaciente,
                                    //Long idMedico,
                                    //LocalDateTime fecha,
                                    MotivoCancelamiento motivo

) {

//    public DatosCancelarConsulta(Consulta consulta) {
//
//        this(consulta.getId(),
//                //consulta.getPaciente().getId(),
//                //consulta.getMedico().getId(),
//                //consulta.getFecha(),
//                MotivoCancelamiento.valueOf(consulta.getMotivoCancelamiento().toString())
//        );
//
//    }

}
