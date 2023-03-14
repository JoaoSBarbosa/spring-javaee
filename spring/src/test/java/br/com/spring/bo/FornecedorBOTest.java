package br.com.spring.bo;

import br.com.spring.model.Fornecedor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FornecedorBOTest {

    @Autowired
    private FornecedorBO tbo;

    @Test
    @Order(1)
    public void insere(){
        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setNomeFantasia("Fanstore");
        fornecedor.setRazaoSocial("ByFanstore");
        fornecedor.setCnpj("72659134000120");
        fornecedor.setEmail("contato@byfanstore.com");
        fornecedor.setCelular("11992942490");
        fornecedor.setTelefone("1127116259");
        fornecedor.setAtivo(true);
        tbo.insere(fornecedor);

        Fornecedor f2 = new Fornecedor();
        f2.setNomeFantasia("Renner");
        f2.setRazaoSocial("Renner teste");
        f2.setCnpj("72659134000120");
        f2.setEmail("contato@renner.com");
        f2.setCelular("11992942490");
        f2.setTelefone("1127116259");
        f2.setAtivo(true);
        tbo.insere(f2);
    }

    @Test
    @Order(2)
    public void pesquisaPorId(){
        Fornecedor fornecedor = tbo.pesquisaPeloId(1L);
        System.out.println(fornecedor);
    }

}
