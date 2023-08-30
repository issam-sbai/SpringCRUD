package com.coding.dao;

import java.util.List;

import com.coding.entity.Personne;

public interface IpersonneDao {
	
	public void inserer(Personne p);
	public Personne selectById(int id);
	public List<Personne> selectAll();
	public void delete(int id);
	public void update(Personne p);
	

}
