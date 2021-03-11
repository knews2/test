package com.model;

public class MessageDTO {

	private int num;
	private String send;
	private String receive;
	private String content;
	private String send_date;

	public MessageDTO(int num, String send, String receive, String content, String send_date) {
		this.num = num;
		this.send = send;
		this.receive = receive;
		this.content = content;
		this.send_date = send_date;
	}

	public MessageDTO(String send, String receive, String content) {
		this.send = send;
		this.receive = receive;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSend() {
		return send;
	}

	public void setSend(String send) {
		this.send = send;
	}

	public String getReceive() {
		return receive;
	}

	public void setReceive(String receive) {
		this.receive = receive;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSend_date() {
		return send_date;
	}

	public void setSend_date(String send_date) {
		this.send_date = send_date;
	}

}
