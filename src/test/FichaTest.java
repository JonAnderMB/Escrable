package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Juego.Ficha;

public class FichaTest {

	Ficha miFicha;
	
	@Before
	public void setUp() throws Exception {
		miFicha = new Ficha('a',1);	
	}

	@After
	public void tearDown() throws Exception
	{
		miFicha = null;
	}

	@Test
	public void testFicha() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLetra() {
	
		assertEquals(miFicha.getLetra(), 'a');
	}

	@Test
	public void testGetPuntos() {
		fail("Not yet implemented");
	}

	@Test
	public void testImprimirLetra() {
		fail("Not yet implemented");
	}

}
