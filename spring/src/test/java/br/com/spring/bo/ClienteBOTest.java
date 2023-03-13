package br.com.spring.bo;

import br.com.spring.model.Cliente;
import br.com.spring.model.Sexo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClienteBOTest {
    @Autowired
    private ClienteBO bo;

    @Test
    @Order(1)
    public void insere(){
        Cliente cliente = new Cliente();
        cliente.setNome("João Barbosa");
        cliente.setCpf("43155900000");
        cliente.setCelular("11994537464");
        cliente.setTelefone("1140028922");
        cliente.setEmail("contato@contato.com");
        cliente.setSexo(Sexo.MASCULINO);
        cliente.setDataDeNascimento(LocalDate.of(1993,1,27));
        cliente.setAtivo(true);
        bo.insere(cliente);

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Francisco");
        cliente2.setCpf("43155900000");
        cliente2.setCelular("11997184239");
        cliente2.setTelefone("1140028922");
        cliente2.setEmail("cliente2.contato@contato.com");
        cliente2.setSexo(Sexo.MASCULINO);
        cliente2.setDataDeNascimento(LocalDate.of(1993,1,27));
        cliente2.setAtivo(true);
        bo.insere(cliente2);
    }
    @Test
    @Order(2)
    public void pesquisaPorId(){
        Cliente cliente = bo.pesquisaPeloId(1L);
        System.out.println(cliente);
    }
    @Test
    @Order(3)
    public void atualiza(){
        Cliente cliente = bo.pesquisaPeloId(1L);
        cliente.setCpf("12345868841");
        bo.atualiza(cliente);
    }




}
