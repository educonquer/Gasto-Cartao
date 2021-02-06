package luan.melo.conquer.conquerprojectp2.dao.impl;

import luan.melo.conquer.conquerprojectp2.dao.GastoDao;
import luan.melo.conquer.conquerprojectp2.domain.Gasto;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class GastoDaoImpl extends AbstractDao<Gasto, Integer> implements GastoDao {


    @Override
    public List<Gasto> findByMounth(String mes) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        CriteriaQuery<Gasto> q = cb.createQuery(Gasto.class);
        Root<Gasto> c = q.from(Gasto.class);
        q.select(c);
        ParameterExpression<String> p = cb.parameter(String.class);
        q.where(cb.equal(c.get("mesExtrato"), mes));
        TypedQuery<Gasto> query = getEntityManager().createQuery(q);

        return query.getResultList();
    }
}