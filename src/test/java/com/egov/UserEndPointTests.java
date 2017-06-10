package com.egov;

import com.egov.impl.entity.Usuario;
import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
@Ignore
public class UserEndPointTests {
	/*private String url = "http://localhost:9000/egov/usuario";
	private TestRestTemplate testRestTemplate = new TestRestTemplate();

	@Test
	public void estaPesquisandoUsuarioPorIDCorretamente() {
		ResponseEntity<Usuario> entity = testRestTemplate.getForEntity(url+"/1", Usuario.class);
		assertEquals(HttpStatus.OK,entity.getStatusCode());
	}

	@Test
	public void retornandoListaCorretamente() {
		ResponseEntity<List> entity = testRestTemplate.getForEntity(url, List.class);

		assertEquals(HttpStatus.OK,entity.getStatusCode());
	}

	@Test
	public void badRequestQuandoAlgumCampoForNulo(){
		List<Usuario> list = new ArrayList<>();
		list.add(new Usuario(0,null,"","","","","",LocalDateTime.now()));
		list.add(new Usuario(0,"",null,"","","","",LocalDateTime.now()));
		list.add(new Usuario(0,"","",null,"","","",LocalDateTime.now()));
		list.add(new Usuario(0,"","","",null,"","",LocalDateTime.now()));
		list.add(new Usuario(0,"","","","",null,"",LocalDateTime.now()));
		list.add(new Usuario(0,"","","","","",null,LocalDateTime.now()));
		list.add(new Usuario(0,"","","","","","",null));

		list.forEach(user ->{
			testPost(user);
			testPut(user);
		});
	}

	private void testPost(Usuario usuario){
		ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(url,usuario,String.class);
		System.out.println(responseEntity.toString());
		assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
	}

	private void testPut(Usuario usuario){
		HttpEntity<Usuario> entity = new HttpEntity<>(usuario);
		ResponseEntity<String> responseEntity = testRestTemplate.exchange(url, HttpMethod.PUT,entity,String.class);
		assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
	}

	@Test
	public void insereCorretamente(){
		Usuario user = new Usuario(0,"teste","teste","teste","teste","teste","teste",LocalDateTime.now());
		HttpEntity<Usuario> entity = new HttpEntity<>(user);
		ResponseEntity<String> responseEntity = testRestTemplate.exchange(url, HttpMethod.POST,entity,String.class);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
	}

	@Test
	public void atualizaCorretamente(){
		Usuario user = new Usuario(3,"update","update","update","update","update","update",LocalDateTime.now());
		HttpEntity<Usuario> entity = new HttpEntity<>(user);
		ResponseEntity<String> responseEntity = testRestTemplate.exchange(url, HttpMethod.PUT,entity,String.class);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
	}*/
}
