package br.com.basis.sgp.servico.mapper;

import br.com.basis.sgp.dominio.Avaliacao;
import br.com.basis.sgp.servico.dto.AvaliacaoListagemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AvaliacaoListagemMapper extends EntityMapper<AvaliacaoListagemDTO, Avaliacao> {

    @Override
    @Mapping(source = "candidato.nome", target = "nomeCandidato")
    @Mapping(source = "candidato.id", target = "idCandidato")
    @Mapping(source = "prova.titulo", target = "tituloProva")
    @Mapping(source = "prova.id", target = "idProva")
    AvaliacaoListagemDTO toDto(Avaliacao avaliacao);

    @Override
    @Mapping(source = "nomeCandidato", target = "candidato.nome")
    @Mapping(source = "idCandidato", target = "candidato.id")
    @Mapping(source = "tituloProva", target = " prova.titulo")
    @Mapping(source = "idProva", target = "prova.id")
    Avaliacao toEntity(AvaliacaoListagemDTO avaliacaoListagemDTO);
}
