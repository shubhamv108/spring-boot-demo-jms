package code.shubham.demo.jms.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MessageObject {

	private String toAddress;

	private String message;

	@Override
	public String toString() {
		return String.format("Message{toAddress=%s, message=%s}", getToAddress(), getMessage());
	}

}
