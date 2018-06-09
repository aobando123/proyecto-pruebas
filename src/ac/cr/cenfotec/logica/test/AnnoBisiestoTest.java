package ac.cr.cenfotec.logica.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import ac.cr.cenfotec.logica.AnnoBisiesto;

public class AnnoBisiestoTest {
	
	
	static AnnoBisiesto annoBi;
	@BeforeClass
	public static void init() {
		annoBi = new AnnoBisiesto();
	}
	
	

	
	@Test 
	public void isBisiestoMult4Test() {
		int testValue =  2016;
		assertTrue(annoBi.isBisiesto(testValue));
	}
	
	@Test
	public void isBisiestoMult100aAnd4Test() {
		int testValue =  1900;
		assertFalse(annoBi.isBisiesto(testValue));
	}
	@Test
	public void isBisiestoMult400Test() {
		int testValue =  800;
		assertTrue(annoBi.isBisiesto(testValue));
	}

}
