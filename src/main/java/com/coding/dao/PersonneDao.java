package com.coding.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.coding.entity.Personne;



@Transactional
@Repository
public class PersonneDao implements IpersonneDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void inserer(Personne p)
	{
		entityManager.persist(p);
		entityManager.close();
		
	}
	
	
	public Personne selectById(int id)
	{
		Personne p= entityManager.find(Personne.class, id);
		entityManager.close();
		return p;
	}
	
	public List<Personne> selectAll()
	{
		Query q=entityManager.createQuery("from Personne");
		List<Personne> liste=q.getResultList();
		entityManager.close();
		return liste;
	}
	
	public void delete(int id)
	{
		Personne p= entityManager.find(Personne.class, id);
		entityManager.remove(p);
		entityManager.close();
	}
	
	public void update(Personne p)
	{
		entityManager.merge(p);
		entityManager.close();
	}

}
