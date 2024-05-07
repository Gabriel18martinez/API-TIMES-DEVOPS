package com.example.time;

import com.example.time.model.Times;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TimeApplicationTests {

	@Test
	public void testeEstadoEstadioNaoValido() {
		Times times = new Times();
		times.setEstadio("Maracanã");
		times.setNome("São Paulo");
		times.setEstado("São Paulo");

		Assertions.assertNotEquals("Maracanã", times.getEstadio());
	}

	@Test
	public void testeEstadoEstadioValido(){
		Times times = new Times();
		times.setEstado("Sao Paulo");
		times.setEstadio("Morumbi");
		times.setNome("Sao Paulo");

		Assertions.assertEquals("Morumbi", times.getEstadio());
	}

}
