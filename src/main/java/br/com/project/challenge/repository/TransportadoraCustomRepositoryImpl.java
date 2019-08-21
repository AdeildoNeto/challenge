package br.com.project.challenge.repository;

import br.com.project.challenge.filter.FiltrosDeListagem;
import br.com.project.challenge.model.ContadorUf;
import br.com.project.challenge.model.Transportadora;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class TransportadoraCustomRepositoryImpl implements TransportadoraCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Transportadora> listar(FiltrosDeListagem filtros) {

        StringBuilder query = new StringBuilder();

        query.append("SELECT t ");
        query.append("FROM Transportadora t inner join t.endereco e ");
        query.append("where 1 = 1 ");

        if (filtros.getQ() != null)
            query.append("and upper(t.nome) like upper(concat('%', :q, '%')) ");

        if (filtros.getCidade() != null)
            query.append("and upper(e.cidade) like upper(concat('%', :cidade, '%')) ");

        if (filtros.getEstado() != null)
            query.append("and e.estado = :estado ");

        if (filtros.getModal() != null)
            query.append("and t.modal = :modal ");


        TypedQuery<Transportadora> typedQuery = entityManager.createQuery(query.toString(), Transportadora.class);

        if (filtros.getQ() != null)
            typedQuery.setParameter("q", filtros.getQ());

        if (filtros.getCidade() != null)
            typedQuery.setParameter("cidade", filtros.getCidade());

        if (filtros.getEstado() != null)
            typedQuery.setParameter("estado", filtros.getEstado());

        if (filtros.getModal() != null)
            typedQuery.setParameter("modal", filtros.getModal());

        return typedQuery.getResultList();
    }

    @Override
    public List<ContadorUf> contarUfs() {

        StringBuilder query = new StringBuilder();

        query.append("SELECT new br.com.project.challenge.model.ContadorUf(e.estado, count(e) as quantidade) ");
        query.append("FROM Endereco e ");
        query.append("GROUP BY e.estado ");
        query.append("ORDER BY e.estado ");

        TypedQuery<ContadorUf> typedQuery = entityManager.createQuery(query.toString(), ContadorUf.class);

        List<ContadorUf> resultList = typedQuery.getResultList();
        return resultList;
    }
}
