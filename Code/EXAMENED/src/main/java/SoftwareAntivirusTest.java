package main.java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class SoftwareAntivirusTest {

	//Test a nivel de main.java por metodos protected.
	SoftwareAntivirus sa = new SoftwareAntivirus(10, LocalDate.now());
	
	
	@Test
	void testEsActivoOK() {
		assertTrue(sa.esActivo());
	}
	
	@Test
	void testEsActivoOKAltaMismoDia() {
		SoftwareAntivirus sa2 = new SoftwareAntivirus(10, LocalDate.now());
		assertTrue(sa2.esActivo());
	}
	
	@Test
	void testEsActivoKO() {
		SoftwareAntivirus sa3 = new SoftwareAntivirus(0, LocalDate.of(2025, 07, 20));
		assertFalse(sa3.esActivo());
	}

	@Test
	void testEsActivoEnFechaOK() {
		assertTrue(sa.esActivoEnFecha(LocalDate.now().plusDays(364)));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 5, 10, 360})
	void testEsActivoEnFechaOKParam(int dias) {
		assertTrue(sa.esActivoEnFecha(LocalDate.now().plusDays(dias)));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {390, 366, 1233, 720})
	void testEsActivoEnFechaKOParam(int dias) {
		assertFalse(sa.esActivoEnFecha(LocalDate.now().plusDays(dias)));
	}
	
	@ParameterizedTest
	@MethodSource("daysList")
	void testEsActivoEnFechaKOParam2(int dias) {
		assertTrue(sa.esActivoEnFecha(LocalDate.now().plusDays(dias)));
	}
	
	
	static int[] daysList() {
		int[] dias = new int[10];
		
		for(int i=0, j=15; i<dias.length;i++,j++) {
			dias[i]=j;
		}
		return dias;
	}
	
	@Test
	void testEsActivoEnFechaKO() {
		assertFalse(sa.esActivoEnFecha(LocalDate.now().plusDays(366)));
	}

	@Test
	void testCalcularDiasRestantesEnFechaOK() {
		assertEquals(sa.calcularDiasRestantesEnFecha(LocalDate.now()), 366);
	}
	
	@Test
	void testCalcularDiasRestantesEnFechaKO() {
		assertNotEquals(sa.calcularDiasRestantesEnFecha(LocalDate.now().plusDays(1)), 366);
	}
	
	@Test
	void testCalcularDiasRestantesEnFechaKO2() {
		assertNotEquals(sa.calcularDiasRestantesEnFecha(LocalDate.now().plusDays(-10)), 366);
	}
	
	@ParameterizedTest
	@CsvSource(value = {"1,365","3,363","10,356"})
	void testCalcularDiasRestantesEnFechaOKParam(int dias, int restantes) {
		assertEquals(sa.calcularDiasRestantesEnFecha(LocalDate.now().plusDays(dias)), restantes);
	}
	
	@ParameterizedTest
	@CsvSource(value = {"1,367","3,366","10,352"})
	void testCalcularDiasRestantesEnFechaKOParam(int dias, int restantes) {
		assertNotEquals(sa.calcularDiasRestantesEnFecha(LocalDate.now().plusDays(dias)), restantes);
	}

	@Test
	void testLicenciasRestantesOK() {
		assertEquals(sa.licenciasRestantes(), 10);
	}
	
	@Test
	void testLicenciasRestantesKO() {
		assertNotEquals(sa.licenciasRestantes(), 9);
	}

	@Test
	void testActivarLicenciaOK() {
		try {
			assertTrue(sa.activarLicencia().length()==29);
		} catch (Exception e) {
			assert(false);
		}
	}

	
	@Test
	void testActivarLicenciaKO() {
		try {
			for(int i=0;i<=10;i++) {
				sa.activarLicencia();
				
			}
		} catch (Exception e) {
			assert(true);
		}
	}
	
	@Test
	void testGenerarPaqueteDeCodigosOK() {
		//Muevo el test al paquete, ya que este metodo esta protected
		assertTrue(sa.generarPaqueteDeCodigos(10).size()==10);
		
	}
	
	@Test
	void testGenerarPaqueteDeCodigosKO() {
		//Muevo el test al paquete, ya que este metodo esta protected
		assertFalse(sa.generarPaqueteDeCodigos(10).size()==11);
		
	}

	@Test
	void testGenerarCodigoLicenciaDeUsoOK() {
		//Muevo el test al paquete, ya que este metodo esta protected

		assertTrue(sa.generarCodigoLicenciaDeUso().contains("-"));
	}
	
	@Test
	void testGenerarCodigoLicenciaDeUsoKO() {
		//Muevo el test al paquete, ya que este metodo esta protected

		assertFalse(sa.generarCodigoLicenciaDeUso().length()==32);
	}

}
