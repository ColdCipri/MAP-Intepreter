package Domain;


public class Pair<T1,T2> implements IPair<T1, T2> {

	private T1 first;
	private T2 second;
	public Pair(T1 f, T2 l) {
		
	}
	@Override
	public T1 getFirst() {
		return first;
	}
	@Override
	public void setFirst(T1 first) {
		this.first = first;
	}
	@Override
	public T2 getSecond() {
		return second;
	}
	@Override
	public void setSecond(T2 second) {
		this.second = second;
	}
	

}
