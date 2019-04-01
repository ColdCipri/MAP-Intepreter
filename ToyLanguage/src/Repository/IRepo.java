package Repository;

import java.io.IOException;

import Domain.IPrgState;

public interface IRepo {
	public void addPrgState(IPrgState st);
	public IPrgState getPrgState(int index);
	void logPrgState() throws IOException;
	public int getSize();
	public void clean();
}


