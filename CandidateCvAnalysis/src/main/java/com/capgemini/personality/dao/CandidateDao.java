package com.capgemini.personality.dao;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.personality.entity.Candidate;

@Repository
public class CandidateDao implements Dao<Candidate> {
	@PersistenceContext 
	private EntityManager entityManager;

	@Override
	public Candidate get(long id) {
		return entityManager.find(Candidate.class,id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Candidate> getAll() {
		Query query = entityManager.createQuery("SELECT c FROM Candidate c ");
		return query.getResultList();
	}

	@Override
	public void save(Candidate candidate) {
		executeInsideTransaction(entityManager -> entityManager.persist(candidate));

	}

	@Override
	public void update(Candidate candidate) {
		executeInsideTransaction(entityManager -> entityManager.merge(candidate));
	}

	@Override
	public void delete(Candidate candidate) {
		executeInsideTransaction(entityManager -> entityManager.remove(candidate));

	}

	private void executeInsideTransaction(Consumer<EntityManager> action) {
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			action.accept(entityManager);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}

}
