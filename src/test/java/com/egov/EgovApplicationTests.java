package com.egov;

import com.egov.impl.database.SolicitacaoData;
import com.egov.impl.entity.Solicitacao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EgovApplicationTests {
	@Autowired
	SolicitacaoData solicitacaoData;

	@Test
	public void contextLoads() {
		Solicitacao solicitacao = solicitacaoData.selectById(1);
		System.out.println(solicitacao);

		solicitacao.setDescricao("UPDATED");
		solicitacaoData.updateSolicitacao(solicitacao);

		solicitacao = solicitacaoData.selectById(1);
		System.out.println(solicitacao);
	}

}
