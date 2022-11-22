package edu.github.juceduarte.mockito.exemplos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* Classe para exemplificar o uso de Spy junto com as classes Mensagem e EnviarMensagemTeste
*/

public class EnviarMensagem {
    private List<Mensagem> mensagens = new ArrayList<>();

    public void adicionarMensagem(Mensagem mensagem){
        this.mensagens.add(mensagem);
    }

    public List<Mensagem> getMensagens() { //método para devolver a mensagem
        return Collections.unmodifiableList(this.mensagens); //lista não modificada
    }
}
