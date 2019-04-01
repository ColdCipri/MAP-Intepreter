package Domain;

import java.io.BufferedReader;
import java.util.Formatter;
import java.util.HashMap;

import Exceptions.DuplicateFileException;
import Exceptions.InvalidFileException;


public class FileTbl implements IFileTbl {

	public HashMap<Integer,BufferedReader> files;
	
	public FileTbl() {
		files = new HashMap<>();
	}
	public FileTbl(FileTbl f) {
		files = new HashMap<>(f.files);
	}
	
	@Override
	public BufferedReader getFile(int i) throws InvalidFileException {
		BufferedReader file;
		if((file = files.get(i)) == null)
			throw new InvalidFileException("No file with name \"" + i +"\"",0);
		return file;

	}

	@Override
	public void addFile(int i, BufferedReader br) throws DuplicateFileException {
		try {
			this.getFile(i);
			throw new DuplicateFileException("There is allready a file with name \"" + i +"\"",0);
		} catch (InvalidFileException e) {
			files.put(i, br);
		}

	}

	@Override
	public void removeFile(int i) throws InvalidFileException {
		this.getFile(i);
		files.remove(i);
	}
	
	@Override
	public String toString() {
		String toReturn = "";
		Formatter form = new Formatter();
		boolean empty = true;
		toReturn += "\r\nFileTable: \r\n";
		
		for(Integer k : files.keySet()) {
			try {			
				form.format("	%-5d = %b\r\n", k, files.get(k) == null);
				empty = false;
			} catch (Exception e) {
				
			}
		}
		if(empty)
			toReturn += "	Empty\r\n";
		toReturn += form.toString();
		form.close();
		return toReturn;
	}

	@Override
	public int count() {
		
		return files.size();
	}
	@Override
	public boolean contains(int key) {
		try {
			this.getFile(key);
			return true;
		} catch (InvalidFileException e) {
			return false;
		}
	}
	
}
