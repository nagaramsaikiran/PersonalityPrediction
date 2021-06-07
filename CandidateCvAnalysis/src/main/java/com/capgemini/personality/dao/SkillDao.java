package com.capgemini.personality.dao;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.personality.entity.Skill;

@Repository
public class SkillDao implements Dao<Skill> {
	@PersistenceContext 
	private EntityManager entityManager;


@Override
public Skill get(long skillId) {
	return entityManager.find(Skill.class,skillId);
}

@SuppressWarnings("unchecked")
@Override
public List<Skill> getAll() {
	Query query = entityManager.createQuery("SELECT s FROM Skill s ");
	return query.getResultList();
}

@Override
public void save(Skill skill) {
	executeInsideTransaction(entityManager -> entityManager.persist(skill));

}

@Override
public void update(Skill skill) {
	executeInsideTransaction(entityManager -> entityManager.merge(skill));
}

@Override
public void delete(Skill skill) {
	executeInsideTransaction(entityManager -> entityManager.remove(skill));


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
