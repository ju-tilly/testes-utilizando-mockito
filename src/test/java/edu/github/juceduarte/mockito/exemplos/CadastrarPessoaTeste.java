package edu.github.juceduarte.mockito.exemplos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {

    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro(){
        DadosLocalizacao dadosLocalicao = new   DadosLocalizacao("PE","Surubim","Rua AA","Casa","São Sebastião");
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("55750000")).thenReturn(dadosLocalicao);
        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Juce","72672637", LocalDate.now(),"55750000");

        assertEquals("Juce",pessoa.getNome());
        assertEquals("72672637",pessoa.getDocumento());
        assertEquals("PE",pessoa.getEndereco().getUf());
        assertEquals("Rua AA",pessoa.getEndereco().getLogradouro());
    }
}
