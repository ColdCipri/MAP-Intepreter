package Domain;

import java.util.ArrayList;
import java.util.List;



public class Output implements IOutput {

	ArrayList<Integer> out;
	
	public Output() {
		out = new ArrayList<>();
	}
	
	public Output(Output o) {
		out = new ArrayList<>(o.out);
	}
	
	@Override
	public void addOutput(int s) {
		out.add(s);
	}
	@Override
	public List<Integer> getIterator() {
		return out;
	}
	
	public String toString() {
		String toReturn = "Output: \r\n\t";
		for(int i : out) {
			toReturn += i + ", " ;
		}
		if(out.size() == 0)
				toReturn += "Empty\r\n";
		return toReturn;
	}
	
}
