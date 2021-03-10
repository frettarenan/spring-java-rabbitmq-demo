package br.com.renanfretta.rabbitmq.demo.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.renanfretta.rabbitmq.demo.config.MessagingConfig;
import br.com.renanfretta.rabbitmq.demo.dto.MensagemDTO;

@RestController
@RequestMapping("/pedidos")
public class PedidoPublisher {

	@Autowired
	private RabbitTemplate template;

	@GetMapping
	public String pedido() {
		MensagemDTO mensagem = new MensagemDTO("Pedido realizado com sucesso para o restaurante: Teste");
		
		template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, mensagem);

		return "Sucesso";
	}
}
