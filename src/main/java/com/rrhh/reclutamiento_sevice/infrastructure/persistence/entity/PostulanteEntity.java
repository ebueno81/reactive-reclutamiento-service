package com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Accessors(chain = true, fluent = false)
@Table("postulante")
public class PostulanteEntity {

    @Id
    private Long id;

    @Column("nombres")              private String nombres;
    @Column("apellidos")            private String apellidos;

    @Column("tipodocumentoid")      private Long tipoDocumentoId;
    @Column("numerodocumento")      private String numeroDocumento;
    @Column("fechanacimiento")      private LocalDate fechaNacimiento;

    @Column("nacionalidad")         private String nacionalidad;
    @Column("estadocivilid")        private Long estadoCivilId;
    @Column("sexoid")               private Long sexoId;

    @Column("telefono")             private String telefono;
    @Column("celular")              private String celular;
    @Column("correo")               private String correo;

    @Column("direccion")            private String direccion;
    @Column("distrito")             private String distrito;
    @Column("provincia")            private String provincia;
    @Column("departamento")         private String departamento;
    @Column("pais")                 private String pais;

    @Column("sistemaprevisionalid") private Long sistemaPrevisionalId;
    @Column("afpid")                private Long afpId;
    @Column("numeroseguro")         private String numeroSeguro;
    @Column("gradoinstruccionid")   private Long gradoInstruccionId;
    @Column("institucioneducativa") private String institucionEducativa;
    @Column("nombreconyuge")        private String nombreConyuge;
    @Column("numerohijos")          private Integer numeroHijos;
}
