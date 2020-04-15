package com.ighing.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ighing.springmvc.dao.ClienteDao;
import com.ighing.springmvc.entity.Cliente;

@Repository
public class ClienteDaoImpl implements ClienteDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Cliente cliente) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/update the object
		currentSession.saveOrUpdate(cliente);
	}

	@Override
	public Cliente get(Integer clienteId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Cliente cliente = currentSession.get(Cliente.class, clienteId);

		return cliente;
	}

	@Override
	public List<Cliente> all() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Cliente> theQuery = currentSession.createQuery("from Cliente", Cliente.class);

		// execute query and get result list
		List<Cliente> clientes = theQuery.getResultList();

		// return the results
		return clientes;
	}

	@Override
	public void delete(Integer clienteId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("delete from Cliente where id=:clienteId");
		theQuery.setParameter("clienteId", clienteId);

		theQuery.executeUpdate();
	}

}