package br.com.renanfretta.rabbitmq.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.renanfretta.rabbitmq.demo.config.MessagingConfig;
import br.com.renanfretta.rabbitmq.demo.dto.MensagemDTO;

@Component
public class MensagemListener {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consomeMensagemDaFila(MensagemDTO mensagem) {
        System.out.println("Mensagem recebida da fila : " + mensagem);
        try {
        	// Só vai receber outra mensagem quando terminar o processamento da mensagem atual
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
}
