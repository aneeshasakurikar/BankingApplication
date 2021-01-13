package com.lti.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lti.entities.Transaction;

public interface TransactionDAO extends CrudRepository<Transaction, Integer>{
	List<Transaction> findAll();
}
