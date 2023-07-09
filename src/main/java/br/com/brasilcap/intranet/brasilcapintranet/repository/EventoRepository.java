package br.com.brasilcap.intranet.brasilcapintranet.repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.brasilcap.intranet.brasilcapintranet.entity.Evento;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Repository
@Named
public class EventoRepository {
	@PersistenceContext
	private EntityManager em;

	public EventoRepository(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<Evento> findByMonth(Date data) {
		String queryStr = "SELECT  * FROM    INTRANET.EVENTO_TB WHERE    TO_CHAR(DATA_EVENTO,'MMYYYY') LIKE :mes ORDER BY     TO_CHAR(DATA_EVENTO,'DD'), DESC_EVENTO";
		Query query = em.createNativeQuery(queryStr, Evento.class);
		SimpleDateFormat formatador = new SimpleDateFormat("MMyyyy");
		String mesAno = formatador.format(data);
		query.setParameter("mes", mesAno);
		return query.getResultList();
	}
}
