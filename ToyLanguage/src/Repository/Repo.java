package Repository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Domain.IPrgState;

public class Repo implements IRepo {
	public ArrayList<IPrgState> list;
	public String logFilePath;
	public Repo(String logFilePath) {
		list = new ArrayList<>();
		this.logFilePath = logFilePath;
	}
	
	@Override
	public void addPrgState(IPrgState state) {
		list.add(state);		
	}

	@Override
	public IPrgState getPrgState(int index) {
		return list.get(index);
	}

	@Override
	public void logPrgState() throws IOException {
		//logs the program states to the log file
		PrintWriter printWriter;	
		printWriter = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
		printWriter.print(list.get(list.size() - 1).toString());
		printWriter.close();
	}

	@Override
	public int getSize() {
		//returns length of the array
		return list.size();
	}

	@Override
	public void clean() {
		//empty the repository
		for(int i = 1 ; i < list.size(); i++)
			list.remove(i);
	}

}
