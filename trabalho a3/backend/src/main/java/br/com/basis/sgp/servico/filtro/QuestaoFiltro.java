package br.com.basis.sgp.servico.filtro;

import br.com.basis.sgp.dominio.Questao_;
import br.com.basis.sgp.dominio.Senioridade_;
import br.com.basis.sgp.dominio.TipoQuestao_;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class QuestaoFiltro implements EntityFiltro {

    private Long id;
    private String descricao;
    private Long senioridade;
    private Long tipoQuestao;

    @Override
    public Specification filter() {
        return (root, query, builder) -> builder.and(getPredicates(root, builder).toArray(new Predicate[0]));
    }

    private List<Predicate> getPredicates(Root root, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList();
        if (ObjectUtils.isNotEmpty(id)) {
            Predicate predicate = builder.equal(root.get(Questao_.id), id);
            predicates.add(predicate);
        }
        if (StringUtils.isNotEmpty(descricao)) {
            Predicate predicate = builder.like(root.get(Questao_.descricao), "%" + descricao.toLowerCase() + "%");
            predicates.add(predicate);
        }
        if (ObjectUtils.isNotEmpty(senioridade) && ObjectUtils.notEqual(senioridade, 0L)) {
            Predicate predicate = builder.equal(root.join("senioridade").get(Senioridade_.ID), senioridade);
            predicates.add(predicate);
        }
        if (ObjectUtils.isNotEmpty(tipoQuestao) && ObjectUtils.notEqual(tipoQuestao, 0L)) {
            Predicate predicate = builder.equal(root.join("tipoQuestao").get(TipoQuestao_.ID), tipoQuestao);
            predicates.add(predicate);
        }
        return predicates;
    }
}
