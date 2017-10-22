package br.com.hackindebt.hackindebt;

import br.com.hackindebt.hackindebt.service.EstudanteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HackindebtApplicationTests {

	@Autowired
	private EstudanteService estudanteService;

	@Test
	public void cientificarecommedia() {
		System.out.println(estudanteService.calcularOuro(8L,true));
	}

	@Test
	public void cientificaresemmedia() {
		System.out.println(estudanteService.calcularOuro(0L,true));
	}

	@Test
	public void semcientificarecommedia() {
		System.out.println(estudanteService.calcularOuro(9L,false));
	}


	@Test
	public void semcientificaresemmedia() {
		System.out.println(estudanteService.calcularOuro(0L,false));
	}

}
