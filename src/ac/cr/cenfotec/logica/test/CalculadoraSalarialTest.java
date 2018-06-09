package ac.cr.cenfotec.logica.test;

import static org.junit.Assert.*;
import ac.cr.cenfotec.logica.TipoEmpleado;
import org.junit.BeforeClass;
import org.junit.Test;

import ac.cr.cenfotec.logica.AnnoBisiesto;
import ac.cr.cenfotec.logica.CalculadoraSalarial;

public class CalculadoraSalarialTest {

	static CalculadoraSalarial calculadora;
	@BeforeClass
	public static void init() {
		calculadora = new CalculadoraSalarial();
	}
	
	@Test 
	public void calcularVendedorconmas1500() throws Exception {
	
		assertEquals(1360, calculadora.calculaSalarioBruto(TipoEmpleado.VENDEDOR, 2000.0f, 8.0f ), 0f);
	}
	
	@Test 
	public void calcularVendedorcon1500() throws Exception {
		assertEquals(1260, calculadora.calculaSalarioBruto(TipoEmpleado.VENDEDOR, 1500.0f, 3.0f ), 0f);
	}
	@Test 
	public void calcularEncargadoConMenos1500Y0H() throws Exception {
		assertEquals(1100, calculadora.calculaSalarioBruto(TipoEmpleado.VENDEDOR, 1499.99f, 0.0f ), 0f);
	}
	@Test 
	public void calcularEncargadoConMenos1500Y8H() throws Exception{
		assertEquals(1760, calculadora.calculaSalarioBruto(TipoEmpleado.ENCARGADO, 1250.0f, 8.0f ), 0f);
	}
	@Test 
	public void calcularEncargadoCon1000Y0H() throws Exception{
		assertEquals(1600, calculadora.calculaSalarioBruto(TipoEmpleado.ENCARGADO, 1000.0f, 0.0f ), 0f);
	}
	@Test 
	public void calcularEncargadoConMenos1000Y3H() throws Exception{
		assertEquals(1560, calculadora.calculaSalarioBruto(TipoEmpleado.ENCARGADO, 999.99f, 3.0f ), 0f);
	}
	@Test 
	public void calcularEncargadoConMenos500Y0H() throws Exception{
		assertEquals(1500, calculadora.calculaSalarioBruto(TipoEmpleado.ENCARGADO, 500.0f, 0.0f ), 0f);
	}
	@Test 
	public void calcularEncargadoConMenos0Y8H() throws Exception{
		assertEquals(1660, calculadora.calculaSalarioBruto(TipoEmpleado.ENCARGADO, 0.0f, 8.0f ), 0f);
	}
	
	@Test(expected = Exception.class)
	public void exceptionVendedorVentasNegativos() throws Exception {
		calculadora.calculaSalarioBruto(TipoEmpleado.VENDEDOR, -1.0f, 8.0f );
	}
	@Test(expected = Exception.class)
	public void exceptionVendedorHorasExtraNegativas() throws Exception {
		calculadora.calculaSalarioBruto(TipoEmpleado.VENDEDOR, 1500.0f, -1.0f );
	}
	@Test(expected = Exception.class)
	public void exceptionVendedorNull() throws Exception {
		calculadora.calculaSalarioBruto(null, 1500.0f, 8.0f );
	}
}
