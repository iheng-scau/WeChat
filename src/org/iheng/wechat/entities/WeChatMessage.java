package org.iheng.wechat.entities;

/**
 * 
 * @author iheng
 *
 */
public class WeChatMessage {
	private String timestamp;
	private String usr_name;
	private String msg_content;
	
	public WeChatMessage(){
		//empty constructor
	}
	
	public WeChatMessage(String timestamp,String usr_name,String msg_content){
		this.timestamp=timestamp;
		this.usr_name=usr_name;
		this.msg_content=msg_content;
	}

	//getters and setter
	public String getUsr_name() {
		return usr_name;
	}

	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}

	public String getMsg_content() {
		return msg_content;
	}

	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
}
