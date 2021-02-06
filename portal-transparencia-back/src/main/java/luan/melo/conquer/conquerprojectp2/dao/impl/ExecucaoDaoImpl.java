package luan.melo.conquer.conquerprojectp2.dao.impl;

import luan.melo.conquer.conquerprojectp2.dao.ExecucaoDao;
import luan.melo.conquer.conquerprojectp2.domain.Execucao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ExecucaoDaoImpl extends AbstractDao<Execucao, Long> implements ExecucaoDao {
}
