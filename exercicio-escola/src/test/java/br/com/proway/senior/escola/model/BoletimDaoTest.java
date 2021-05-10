package br.com.proway.senior.escola.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.escola.persistence.ArrayListPersistenceBoletim;

public class BoletimDaoTest {

	static BoletimDao DAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ArrayListPersistenceBoletim db = new ArrayListPersistenceBoletim();
	}
	@Test
	public void testeAdicionaBoletimDao() {
		ArrayListPersistenceBoletim db = new ArrayListPersistenceBoletim();
		Boletim boletim1 = new Boletim(null, null);
		Boletim boletim2 = new Boletim(null, null);
		db.add(boletim1);
		db.add(boletim2);
		assertEquals(2, db.getAll().size());
	}
	@Test
	public void testeRemoveTodosBoletimDao() {
		ArrayListPersistenceBoletim db = new ArrayListPersistenceBoletim();
		Boletim boletim = new Boletim(null, null);
		db.add(boletim);
		db.removeAll();
		assertEquals(0, db.getAll().size());
	}
	@Test
	public void testeRemoveUmBoletimDao()
	{

		ArrayListPersistenceBoletim db = new ArrayListPersistenceBoletim();
		Boletim boletim1 = new Boletim(null, null);
		Boletim boletim2 = new Boletim(null, null);
		db.add(boletim1);
		db.add(boletim2);
		db.remove(boletim1.getId());
		assertEquals(1, db.getAll().size());
	}
	@Test
	public void testeGetBoletimDao() {
		ArrayListPersistenceBoletim db = new ArrayListPersistenceBoletim();
		Boletim boletim1 = new Boletim(null, null);
		Boletim boletim2 = new Boletim(null, null);
		db.add(boletim1);
		db.add(boletim2);
		
		assertEquals(boletim2, db.get(1));
	}
}