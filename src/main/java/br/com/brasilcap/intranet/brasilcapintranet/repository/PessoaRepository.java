package br.com.brasilcap.intranet.brasilcapintranet.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.brasilcap.intranet.brasilcapintranet.dto.PessoaDTO;
import br.com.brasilcap.intranet.brasilcapintranet.entity.Pessoa;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Named
@Transactional
public class PessoaRepository {

	@PersistenceContext
	private EntityManager em;

	public PessoaRepository(EntityManager em) {
		this.em = em;
	}

	public Pessoa findByUserName(String userName) {
		String queryStr = "SELECT  * FROM    INTRANET.IPS_PESSOAL_TB WHERE UPPER(STATUS) = 'S' AND  UPPER(USERNAME) = :username  AND ROWNUM <=1 ORDER BY NOME";
		Query query = em.createNativeQuery(queryStr, Pessoa.class);

		query.setParameter("username", userName.toUpperCase());
		Pessoa pessoa = (Pessoa) query.getSingleResult();
		if (pessoa == null) {

			queryStr = "SELECT  * FROM    INTRANET.IPS_PESSOAL_TB WHERE  UPPER(USERNAME) = :username  AND ROWNUM <=1 ORDER BY NOME";

			query = em.createNativeQuery(queryStr, Pessoa.class);
			pessoa = (Pessoa) query.getSingleResult();
			em.detach(pessoa);
		}
		return pessoa;
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> findAniversariantes(Short mes) {
		String queryStr = "SELECT * FROM INTRANET.IPS_PESSOAL_TB WHERE TO_CHAR(DT_NASC, 'MM') = :mes AND UPPER(STATUS) = 'S' AND SITUACAO <> '8' AND SITUACAO <> '0' AND EMPRESA_ID = '00002' AND CARGO_ID NOT IN ('51190', '51191', '51192') ORDER BY TO_CHAR(DT_NASC, 'DD'), NOME";
		Query query = em.createNativeQuery(queryStr, Pessoa.class);
		query.setParameter("mes", mes);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> findByName(String a) {
		String queryStr = "SELECT * FROM INTRANET.IPS_PESSOAL_TB WHERE UPPER(STATUS) = 'S' AND UPPER(NOME) LIKE UPPER(:name)";

		Query query = em.createNativeQuery(queryStr, Pessoa.class);
		query.setParameter("name", "%" + a + "%");

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> findByLetter(Character letter) {
		String queryStr = "SELECT * FROM INTRANET.IPS_PESSOAL_TB WHERE UPPER(STATUS) = 'S' AND UPPER(NOME) LIKE UPPER(:initial)";

		Query query = em.createNativeQuery(queryStr, Pessoa.class);
		query.setParameter("initial", letter + "%");

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PessoaDTO> findOtimizado() {
		String sql = "SELECT p.* "
				+ "FROM INTRANET.IPS_PESSOAL_TB p JOIN INTRANET.IPS_LOTACAO_TB l ON p.LOTACAO_ID = l.LOTACAO_ID "
				+ "WHERE p.STATUS = 'S' ORDER BY p.NOME ASC";

		Query query = em.createNativeQuery(sql, Pessoa.class);

		List<Pessoa> pessoas = query.getResultList();
		List<PessoaDTO> pessoasDto = new ArrayList<>();
		for (Pessoa pessoa : pessoas) {

			pessoasDto.add(new PessoaDTO(pessoa));
		}

		return pessoasDto;
	}

	@SuppressWarnings("unchecked")
	public List<PessoaDTO> findPorGestor(String userName) {
		String sql = "SELECT p.* "
				+ "FROM INTRANET.IPS_PESSOAL_TB p JOIN INTRANET.IPS_LOTACAO_TB l ON p.LOTACAO_ID = l.LOTACAO_ID "
				+ "WHERE p.STATUS = 'S' AND p.USERNAME = :userName ORDER BY p.NOME ASC";

		Query query = em.createNativeQuery(sql, Pessoa.class);
		query.setParameter("userName", userName);

		List<Pessoa> pessoas = query.getResultList();
		List<PessoaDTO> pessoasDto = new ArrayList<>();
		for (Pessoa pessoa : pessoas) {

			pessoasDto.add(new PessoaDTO(pessoa));
		}

		return pessoasDto;
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> findLike(String propertyValue, String propertyName) {
		String queryString = "SELECT * FROM INTRANET.IPS_PESSOAL_TB " + "WHERE UPPER(" + propertyName
				+ ") LIKE :propertyValue " + "AND STATUS = 'S' " + "ORDER BY NOME ASC";

		Query query = em.createNativeQuery(queryString, Pessoa.class);
		query.setParameter("propertyValue", "%" + propertyValue.toUpperCase() + "%");

		return query.getResultList();
	}

	public Pessoa findById(int id) {

		String queryStr = "SELECT * FROM INTRANET.IPS_PESSOAL_TB C WHERE C.PESSOAL_ID = :pessoal_id";
		Query query = em.createNativeQuery(queryStr, Pessoa.class);
		query.setParameter("pessoal_id", id);

		Pessoa pessoa = (Pessoa) query.getSingleResult();
		em.detach(pessoa);

		return pessoa;
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> findPessoasAll() {
		String queryStr = "SELECT * FROM INTRANET.IPS_PESSOAL_TB ORDER BY NOME ASC";
		Query query = em.createNativeQuery(queryStr, Pessoa.class);
		return query.getResultList();
	}
	
	public List<Pessoa> findPorGestors(Pessoa usuario) {
	    String lotacoesId = usuario.getLotacao().getCodLotacao(); // Obtém os IDs das lotações
	    
	    CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Pessoa> query = cb.createQuery(Pessoa.class);
	    Root<Pessoa> root = query.from(Pessoa.class);
	    
	    query.select(root)
	         .where(cb.equal(root.get("status"), 'S'),
	                root.get("lotacao").get("lotacaoId").in(lotacoesId))
	         .orderBy(cb.asc(root.get("nome")));
	    
	    return em.createQuery(query).getResultList();
	}

}
