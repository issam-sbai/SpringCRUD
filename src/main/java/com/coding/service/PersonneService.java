package com.coding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.coding.dao.IpersonneDao;
import com.coding.entity.Personne;

@Service
public class PersonneService implements IpersersonneService {
	
	@Autowired
	IpersonneDao dao;
	
	
	public void ajouter(Personne p)
	{
		dao.inserer(p);
	}
	
	public Personne selecOne(int id)
	{
		return dao.selectById(id);
	}
	
	public List<Personne> selectAll()
	{
		return dao.selectAll();
	}
	
	public void supprimer(int id)
	{
		dao.delete(id);
	}
	
	public void modifier(Personne p)
	{
		dao.update(p);
	}

}
