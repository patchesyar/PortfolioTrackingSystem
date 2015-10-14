

public class Logger{
	
	private String ID;
	private String Log = "";
	
	public Logger(String ID){
		this.ID = ID;
	}
	
	public void addLog(String line){
		this.Log += line + "\n";
	}
}