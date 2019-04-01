package Command;

import Domain.PrintCallBack;


public abstract class Command {
	private String description;
	private String key;
	public PrintCallBack callback;
	public Command(String key,String description) {
		this.description = description;
		this.setKey(key);
	}
	
	public void setCallBack(PrintCallBack callback) {
		this.callback = callback;
	}
	public abstract void execute();

	public String getDescription() {
		return description;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
