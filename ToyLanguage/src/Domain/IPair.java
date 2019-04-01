package Domain;

public interface IPair<T1,T2> {
	public T1 getFirst();
	public T2 getSecond();
	public void setFirst(T1 t);
	public void setSecond(T2 t);
	
}
