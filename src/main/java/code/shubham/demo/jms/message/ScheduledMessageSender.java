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
		this.jmsTemplate.convertAndSend("mailbox", MessageObject.builder().toAddress("info@example.com").message("info"));

	}

	@Scheduled(cron = "0/8 * * ? * *")
	public void sendingTestMessage() {
		this.jmsTemplate.convertAndSend("mailbox", MessageObject.builder().toAddress("test@example.com").message("test"));
	}

}
