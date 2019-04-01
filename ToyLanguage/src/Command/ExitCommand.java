package Command;

public class ExitCommand extends Command {

    public ExitCommand(String key,String desc){
        super(key,desc);
    }
    
    @Override
    public void execute() {
    	this.callback.printCallBack("App is exiting...");
        System.exit(0);
    }

}
