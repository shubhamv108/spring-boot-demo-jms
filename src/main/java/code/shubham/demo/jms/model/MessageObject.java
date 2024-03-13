package code.shubham.demo.jms.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageObject {

	private String toAddress;

	private String message;

	public MessageObject() {
	}

	public MessageObject(String toAddress, String message) {
		this.toAddress = toAddress;
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("Message{toAddress=%s, message=%s}", getToAddress(), getMessage());
	}

}
