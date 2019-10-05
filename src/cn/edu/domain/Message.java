package cn.edu.domain;

public class Message {

	private String message_sid;
	private String message_type;
	private String message_topic;
	private String message_content;
	private String message_time;
	private String email;
	private String receive_message_time;
	private String receive_message_topic;
	private String receive_message_content;
	private String show;
	
	
	public String getMessage_sid() {
		return message_sid;
	}
	public void setMessage_sid(String message_sid) {
		this.message_sid = message_sid;
	}
	public String getMessage_type() {
		return message_type;
	}
	public void setMessage_type(String message_type) {
		this.message_type = message_type;
	}
	public String getMessage_topic() {
		return message_topic;
	}
	public void setMessage_topic(String message_topic) {
		this.message_topic = message_topic;
	}
	public String getMessage_content() {
		return message_content;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	public String getMessage_time() {
		return message_time;
	}
	public void setMessage_time(String message_time) {
		this.message_time = message_time;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getReceive_message_topic() {
		return receive_message_topic;
	}
	public void setReceive_message_topic(String receive_message_topic) {
		this.receive_message_topic = receive_message_topic;
	}
	public String getReceive_message_content() {
		return receive_message_content;
	}
	public void setReceive_message_content(String receive_message_content) {
		this.receive_message_content = receive_message_content;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public String getReceive_message_time() {
		return receive_message_time;
	}
	public void setReceive_message_time(String receive_message_time) {
		this.receive_message_time = receive_message_time;
	}
	
	
}
