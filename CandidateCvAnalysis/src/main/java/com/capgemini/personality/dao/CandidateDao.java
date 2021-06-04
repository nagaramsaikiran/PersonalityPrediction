package com.capgemini.personality.dao;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.capgemini.personality.entity.Candidate;

public class CandidateDao implements Dao<Candidate> {
	private EntityManager entityManager;

	@Override
	public Optional<Candidate> get(long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(entityManager.find(Candidate.class,id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Candidate> getAll() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("SELECT * FROM Candidate ");
		return query.getResultList();
	}

	@Override
	public void save(Candidate candidate) {
		executeInsideTransaction(entityManager -> entityManager.persist(candidate));

	}

	@Override
	public void update(Candidate candidate, String[] params) {
		candidate.setName(Objects.requireNonNull(params[0], "Id cannot be null"));

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
