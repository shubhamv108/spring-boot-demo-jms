package code.shubham.demo.jms.message;

import code.shubham.demo.jms.model.MessageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ScheduledMessageReceiver {

	@Autowired
	private JmsTemplate jmsTemplate;

	@JmsListener(destination = "mailbox", containerFactory = "jmsListenerContainerFactory")
	public void receiveMessage(MessageObject message) {
		switch (message.getToAddress()) {
			case "info@example.com":
				System.out.println(message.getMessage());
				break;
			case "test@example.com":
				throw new RuntimeException(message.getMessage());
		}
	}

}
