package br.com.basis.sgp.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class AvaliacaoCadastroDTO {

    private Long id;

    @NotNull
    private LocalDate data;

    @NotNull
    private Long idCandidato;

    @NotNull
    private Long idProva;

    private BigDecimal aproveitamento;
}
