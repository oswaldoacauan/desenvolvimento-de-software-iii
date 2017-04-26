package com.egov;

import com.egov.impl.database.SolicitacaoData;
import com.egov.impl.entity.Usuario;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EgovApplicationTests {
	private String url = "http://localhost:9000/egov/usuario";
	private TestRestTemplate testRestTemplate = new TestRestTemplate();

	@Test
	public void estaPesquisandoUsuarioPorIDCorretamente() {
		ResponseEntity<Usuario> entity = testRestTemplate.getForEntity(url+"/1", Usuario.class);
		assertEquals(HttpStatus.OK,entity.getStatusCode());
	}

	@Test
	public void badRequestQuandoAlgumCampoForNulo(){
		List<Usuario> list = new ArrayList<>();
		list.add(new Usuario(0,null,"","","","","", LocalDateTime.now()));
		list.add(new Usuario(0,"",null,"","","","", LocalDateTime.now()));
		list.add(new Usuario(0,"","",null,"","","", LocalDateTime.now()));
		list.add(new Usuario(0,"","","",null,"","", LocalDateTime.now()));
		list.add(new Usuario(0,"","","","",null,"", LocalDateTime.now()));
		list.add(new Usuario(0,"","","","","",null, LocalDateTime.now()));
		list.add(new Usuario(0,"","","","","","", null));
		
		list.forEach(user ->{
			testPost(user);
			testPut(user);
		});
	}

	private void testPost(Usuario usuario){
		ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(url,usuario,String.class);
		assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
	}

	private void testPut(Usuario usuario){
		HttpEntity<Usuario> entity = new HttpEntity<>(usuario);
		ResponseEntity<String> responseEntity = testRestTemplate.exchange(url, HttpMethod.PUT,entity,String.class);
		assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
	}
}
