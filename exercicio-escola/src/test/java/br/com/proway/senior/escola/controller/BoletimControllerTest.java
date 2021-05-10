package br.com.proway.senior.escola.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.escola.model.Aluno;
import br.com.proway.senior.escola.model.Boletim;
import br.com.proway.senior.escola.model.Materia;
import br.com.proway.senior.escola.model.Prova;
import br.com.proway.senior.escola.persistence.ArrayListPersistenceBoletim;

public class BoletimControllerTest {

	static BoletimController controller;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Aluno aluno = new Aluno();
		Integer periodo = 202105;
		Boletim boletim = new Boletim(aluno, periodo);
		controller = new BoletimController(boletim); 
	}

	@Test
	public void testBoletimController() {
		assertNotNull(controller);
	}

	@Test
	public void testAddProva() {
		controller.removeTodasProvas();
		Materia materia = new Materia();
		Prova prova = new Prova(202105, controller.getBoletim().getAluno(), materia);
		controller.addProva(prova);
		assertEquals(1,(int) controller.getBoletim().getProvas().size());
	}
	@Test
	public void testRemoveProva() {
		ArrayListPersistenceBoletim dbBoletim = new ArrayListPersistenceBoletim();
		Prova prova1 = new Prova(null, null, null);
		Prova prova2 = new Prova(null, null, null);
		dbBoletim.add(prova1);
		dbBoletim.add(prova2);
		controller.removeProva(prova1.getId());
		
	}

	@Test (expected = Exception.class)
	public void testRemoveProvaInexistente() {
		Materia materia = new Materia();
		Boletim boletim = controller.getBoletim();
		Prova prova1 = new Prova(202105, boletim.getAluno(), materia);
		Prova prova2 = new Prova(202106, boletim.getAluno(), materia);
		controller.addProva(prova1);
		controller.addProva(prova2);
		controller.removeProva(4);
		assertEquals(2, boletim.getProvas().size());
	}

	
	@Test
	public void testRemoveTodasProvas() {
		Materia materia = new Materia();
		Boletim boletim = controller.getBoletim();
		Prova prova = new Prova(202105, boletim.getAluno(), materia);
		controller.addProva(prova);
		controller.removeTodasProvas();
		assertFalse(boletim.getProvas().size() > 0);
	}
	
}
