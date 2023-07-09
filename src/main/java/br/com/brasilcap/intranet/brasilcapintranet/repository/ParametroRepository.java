package br.com.brasilcap.intranet.brasilcapintranet.repository;

import org.springframework.stereotype.Repository;

import br.com.brasilcap.intranet.brasilcapintranet.entity.Parametro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

@Repository

public class ParametroRepository {

	private final EntityManager em;

	public ParametroRepository(EntityManager em) {
		this.em = em;
	}

	public Parametro findByChave(String chave) {

		String query = "SELECT * FROM INTRANET.INT_PARAMETRO_PROCESSO_TB C where C.chave = :chave";

		var q = em.createQuery(query, Parametro.class);

		q.setParameter("chave", chave);

		//tratamento para NULL caso nenhum resultado seja encontrado
		try {
			var retorno = q.getSingleResult();
			return retorno;
		} catch (NoResultException e) {

			return null;
		}
	}

}
