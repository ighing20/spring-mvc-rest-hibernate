package com.ighing.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ighing.springmvc.dao.ClienteDao;
import com.ighing.springmvc.entity.Cliente;
import com.ighing.springmvc.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	// need to inject cliente dao
	@Autowired
	private ClienteDao clienteDao;

	@Override
	@Transactional
	public Cliente create(Cliente cliente) {
		clienteDao.save(cliente);
		return cliente;
	}

	@Override
	@Transactional
	public List<Cliente> getAll() {
		return clienteDao.all();
	}

	@Override
	@Transactional
	public Cliente get(Integer clienteId) {
		return clienteDao.get(clienteId);
	}

	@Override
	@Transactional
	public Cliente update(Cliente cliente) {
		clienteDao.save(cliente);
		return cliente;
	}

	@Override
	@Transactional
	public void delete(Integer clienteId) {
		clienteDao.delete(clienteId);
	}

}