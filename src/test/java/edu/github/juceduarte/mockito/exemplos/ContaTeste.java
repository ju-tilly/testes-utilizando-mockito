package edu.github.juceduarte.mockito.exemplos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContaTeste {

    @Spy  //está espiando a classe conta, o comportamento dos métodos da classe tmb.
    private Conta conta = new Conta(1000);

    @Test
    void validarOrdemDeChamadas(){
        conta.pagaBoleto(300);

        InOrder inOrder = Mockito.inOrder(conta);
        //inOrder.verify(conta).pagaBoleto(ArgumentMatchers.anyInt());//passando com qualquer valor inteiro - alternativa
        inOrder.verify(conta).pagaBoleto(300);
        inOrder.verify(conta).validaSaldo(300);
        inOrder.verify(conta).debita(300);
        inOrder.verify(conta).enviarCreditoParaEmissor(300);
    }
    @Test
    void validarQuantidadeDeChamadas(){ //validar quantas vezes o método foi chamado
        conta.validaSaldo(300);
        conta.validaSaldo(400);
        conta.validaSaldo(800);

        Mockito.verify(conta, Mockito.times(3)).validaSaldo(ArgumentMatchers.anyInt());
    }
}
