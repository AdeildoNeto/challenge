package br.com.project.challenge.repository;

import br.com.project.challenge.model.Transportadora;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class TransportadoraCustomRepositoryImpl implements TransportadoraCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Transportadora> listar() {

        StringBuilder query = new StringBuilder();

        query.append("SELECT t ");
        query.append("FROM Transportadora t ");

        TypedQuery<Transportadora> typedQuery = entityManager.createQuery(query.toString(), Transportadora.class);

        return typedQuery.getResultList();
    }
}
