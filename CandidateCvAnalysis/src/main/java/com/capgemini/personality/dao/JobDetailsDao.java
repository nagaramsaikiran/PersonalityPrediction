package com.capgemini.personality.dao;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.capgemini.personality.entity.JobDetails;

public class JobDetailsDao implements Dao<JobDetails> {
	private EntityManager entityManager;

	@Override
	public JobDetails get(long jobId) {
		// TODO Auto-generated method stub
		return entityManager.find(JobDetails.class, jobId);
	}

	@Override
	public void save(JobDetails jobDetails) {
		executeInsideTransaction(entityManager -> entityManager.persist(jobDetails));

	}

	@Override
	public void update(JobDetails jobDetails) {
		executeInsideTransaction(entityManager -> entityManager.merge(jobDetails));
	}

	@Override
	public void delete(JobDetails jobDetails) {
		executeInsideTransaction(entityManager -> entityManager.remove(jobDetails));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JobDetails> getAll() {

		Query query = entityManager.createQuery("SELECT * FROM JobDetails ");
		return query.getResultList();
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
