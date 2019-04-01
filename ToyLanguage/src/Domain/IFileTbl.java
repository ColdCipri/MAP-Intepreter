package Domain;

import java.io.BufferedReader;
import Exceptions.DuplicateFileException;
import Exceptions.InvalidFileException;

public interface IFileTbl {
	BufferedReader getFile(int i) throws InvalidFileException;
	void addFile(int i, BufferedReader br) throws DuplicateFileException;
	void removeFile(int i) throws InvalidFileException;
	String toString();
	int count();
	boolean contains(int key);
}
