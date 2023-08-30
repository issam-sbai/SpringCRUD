package com.coding.service;

import java.util.List;

import com.coding.entity.Personne;

public interface IpersersonneService {
	
	
	public void ajouter(Personne p);
	
	public Personne selecOne(int id);
	
	public List<Personne> selectAll();
	
	public void supprimer(int id);
	
	public void modifier(Personne p);

}
