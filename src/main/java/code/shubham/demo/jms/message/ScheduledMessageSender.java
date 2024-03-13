package code.shubham.demo.jms.message;

import code.shubham.demo.jms.model.MessageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduledMessageSender {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Scheduled(cron = "0/5 * * ? * *")
	public void sendingInfoMessage() {
		this.jmsTemplate.convertAndSend("mailbox", new MessageObject("info@example.com", "info"));

	}

	@Scheduled(cron = "0/8 * * ? * *")
	public void sendingTestMessage() {
		this.jmsTemplate.convertAndSend("mailbox", new MessageObject("test@example.com", "test"));
	}

}
