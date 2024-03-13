package code.shubham.demo.jms;

import code.shubham.demo.jms.message.ScheduledMessageErrorHandler;
import code.shubham.demo.jms.message.ScheduledMessageReceiver;
import code.shubham.demo.jms.message.ScheduledMessageSender;
import code.shubham.demo.jms.model.MessageObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ApplicationTests {

	@SpyBean
	ScheduledMessageSender scheduledMessageSender;

	@SpyBean
	ScheduledMessageReceiver scheduledMessageReceiver;

	@SpyBean
	ScheduledMessageErrorHandler scheduledMessageErrorHandler;

	@Test
	public void checkEnableScheduling() {
		boolean hasAnnotation = false;

		Annotation annotation = AnnotationUtils.findAnnotation(Application.class, EnableScheduling.class);
		if (annotation != null) {
			hasAnnotation = true;
		}

		assertTrue(hasAnnotation);
	}

	@Test
	public void checkScheduledAnnotation() {
		boolean hasAnnotation = false;

		for (Method method : ScheduledMessageSender.class.getDeclaredMethods()) {
			Annotation annotation = AnnotationUtils.findAnnotation(method, Scheduled.class);
			if (annotation != null) {
				hasAnnotation = true;
				break;
			}
		}

		assertTrue(hasAnnotation);
	}

	@Test
	public void checkSendingInfoMessage() {
		await().atMost(Duration.of(10, ChronoUnit.SECONDS)).untilAsserted(() -> {
			verify(scheduledMessageSender, atLeast(2)).sendingInfoMessage();
		});
	}

	@Test
	public void checkSendingTestMessage() {
		await().atMost(Duration.of(10, ChronoUnit.SECONDS)).untilAsserted(() -> {
			verify(scheduledMessageSender, atLeast(1)).sendingTestMessage();
		});
	}

	@Test
	public void checkEnableJms() {
		boolean hasAnnotation = false;

		Annotation annotation = AnnotationUtils.findAnnotation(Application.class, EnableJms.class);
		if (annotation != null) {
			hasAnnotation = true;
		}

		assertTrue(hasAnnotation);
	}

	@Test
	public void checkReceivingMessage() {
		await().atMost(Duration.of(10, ChronoUnit.SECONDS)).untilAsserted(() -> {
			verify(scheduledMessageReceiver, atLeast(2)).receiveMessage(any(MessageObject.class));
		});
	}

	@Test
	public void checkingErrorHandler() {
		await().atMost(Duration.of(10, ChronoUnit.SECONDS)).untilAsserted(() -> {
			verify(scheduledMessageErrorHandler, atLeast(1)).handleError(any());
		});
	}

}