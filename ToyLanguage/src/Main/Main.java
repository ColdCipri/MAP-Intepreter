package Main;

import Controller.Controller;
import Domain.PrgState;
import Exceptions.OperandException;
import Exceptions.ZeroDevisionException;
import Exp.ArithExp;
import Exp.BoolExp;
import Exp.ConstExp;
import Exp.HeapReadExp;
import Exp.VarExp;
import Command.*;
import Repository.Repo;
import Stmt.AssignStmt;
import Stmt.CloseReadFileStmt;
import Stmt.CompStmt;
import Stmt.HeapAllocationStmt;
import Stmt.HeapWritingStmt;
import Stmt.IStmt;
import Stmt.IfStmt;
import Stmt.OpenReadFileStmt;
import Stmt.PrintStmt;
import Stmt.ReadFileStmt;
import Stmt.SleepStmt;
import Stmt.WhileStmt;
import View.TextMenu;

public class Main {
	
	public static void main(String[] args) throws OperandException, ZeroDevisionException {
		// v = 1; print(v)
		Repo repo1 = new Repo("src/Logs/Repository/Problem1.txt");
		PrgState s1 = new PrgState();
		AssignStmt as1 = new AssignStmt("v",new ConstExp(1));
		PrintStmt ps1 = new PrintStmt(new VarExp("v"));
		s1.addStatement(new CompStmt(as1, ps1));
		repo1.addPrgState(s1);
		Controller c1= new Controller(repo1);
		/*
		   a=2 + 3 * 4;
		   b=a - 8 / 2 +5;
		   Print(b)
		*/
		
		Repo repo2 = new Repo("src/Logs/Repository/Problem2.txt");
		PrgState s2 = new PrgState();
		AssignStmt as2 = new AssignStmt("a",
										new ArithExp('+',
													new ConstExp(2),
													//null,
													new ArithExp('*',
															new ConstExp(3), 
															new ConstExp(4)
															)
													)
										);
		AssignStmt as3 = new AssignStmt("b",
										new ArithExp('+',
											new ArithExp('-',
													new VarExp("a"),
													new ArithExp('/',
														new ConstExp(8),
														//new ConstExp(0)
														new ConstExp(2)
													)
														
												),
											new ConstExp(5)
										)
									);
		
		PrintStmt ps2 = new PrintStmt(new VarExp("b"));
		
		s2.addStatement(new CompStmt(new CompStmt(as2,as3), ps2));
		repo2.addPrgState(s2);
		Controller c2 = new Controller(repo2);
		
		/*
		   	c = 5 - 1;
		  	If c Then 
		  		v = 1 
		  	Else 
		  		v = 2;
		  	Print(v)
		*/
		Repo repo3 = new Repo("src/Logs/Repository/Problem3.txt");
		PrgState s3 = new PrgState();
		PrintStmt ps3 = new PrintStmt(new VarExp("v"));
		IfStmt condS = new IfStmt(
				new VarExp("c"),
				new AssignStmt("v",new ConstExp(1)),
				new AssignStmt("v",new ConstExp(2))
		);
		AssignStmt as4 = new AssignStmt(
				"c",
				new ArithExp(
						'-',
						new ConstExp(5),
						new ConstExp(1)
						)
				);
		s3.addStatement(new CompStmt(as4, new CompStmt(condS, ps3)));
		repo3.addPrgState(s3);
		Controller c3 = new Controller(repo3);
		
		/*
		 * openRFile(var_f,"test.in"); readFile(var_f,var_c);print(var_c); (if var_c
		 * then readFile(var_f,var_c);print(var_c) else print(0)); closeRFile(var_f)
		 */
		
		Repo repo4 = new Repo("src/Logs/Repository/Problem4.txt");
		PrgState s4 = new PrgState();
		OpenReadFileStmt orfs1 = new OpenReadFileStmt("src/Input/input.txt", "var_f");
		//OpenReadFileStmt abc = new OpenReadFileStmt("src/Input/input.txt", "var_f");
		ReadFileStmt rfs1 = new ReadFileStmt(new VarExp("var_f"), "var_c");
		PrintStmt ps4 = new PrintStmt(new VarExp("var_c"));
		CompStmt cs1 = new CompStmt(rfs1, ps4);
		ReadFileStmt rfs2 = new ReadFileStmt(new VarExp("var_f"), "var_c");
		PrintStmt ps5 = new PrintStmt(new VarExp("var_c"));
		CompStmt cs2 = new CompStmt(rfs2, ps5);
		/*
		ReadFileStmt a = new ReadFileStmt(new VarExp("var_f"), "var_c");
		PrintStmt b = new PrintStmt(new VarExp("var_c"));
		CompStmt c = new CompStmt(a, b);
		*/
		PrintStmt ps6 = new PrintStmt(new ConstExp(0));
		IfStmt if1 = new IfStmt(new VarExp("var_c"), cs2, ps6);
		CloseReadFileStmt crfs1 = new CloseReadFileStmt(new VarExp("var_f"));

		s4.addStatement(crfs1);
		s4.addStatement(if1);
		s4.addStatement(cs1);
		//s4.addStatement(c);
		s4.addStatement(orfs1);
		repo4.addPrgState(s4);
		Controller c4 = new Controller(repo4);
		
		
		/*
		 * openRFile(var_f,"test.in"); readFile(var_f,var_c);print(var_c); (if var_c
		 * then readFile(var_f + 2,var_c);print(var_c) else print(0)); closeRFile(var_f)
		 */
		
		Repo repo5 = new Repo("src/Logs/Repository/Problem5.txt");
		PrgState s5 = new PrgState();
		OpenReadFileStmt orfs2 = new OpenReadFileStmt("src/Input/input.txt", "var_f");
		ReadFileStmt rfs3 = new ReadFileStmt(
				new ArithExp('+',new VarExp("var_f"),new ConstExp(2)), "var_c");
		PrintStmt ps7 = new PrintStmt(new VarExp("var_c"));
		CompStmt cs3 = new CompStmt(rfs3, ps7);
		ReadFileStmt rfs4 = new ReadFileStmt(new VarExp("var_f"), "var_c");
		PrintStmt ps8 = new PrintStmt(new VarExp("var_c"));
		CompStmt cs4 = new CompStmt(rfs4, ps8);
		PrintStmt ps9 = new PrintStmt(new ConstExp(0));
		IfStmt if2 = new IfStmt(new VarExp("var_c"), cs4, ps9);
		CloseReadFileStmt crfs2 = new CloseReadFileStmt(new VarExp("var_f"));

		s5.addStatement(crfs2);
		s5.addStatement(if2);
		s5.addStatement(cs3);
		s5.addStatement(orfs2);
		repo5.addPrgState(s5);
		Controller c5 = new Controller(repo5);
		
		/* 
		  v=10;
		  new(v,20);
		  new(a,22);
		  print(100+rH(v));
		  print(100+rH(a))		 *
		*/

		Repo repo6 = new Repo("src/Logs/Repository/Problem6.txt");
		PrgState s6 = new PrgState();

		IStmt st1 = new CompStmt(new AssignStmt("v", new ConstExp(10)),
				new CompStmt(new HeapAllocationStmt("v", new ConstExp(20)),
						new CompStmt(new HeapAllocationStmt("a", new ConstExp(22)),
								new CompStmt(
										new PrintStmt(new ArithExp('+', new ConstExp(100),
												new HeapReadExp("v"))),
										new PrintStmt(new ArithExp('+', new ConstExp(100),
												new HeapReadExp("a")))))));

		s6.addStatement(st1);
		repo6.addPrgState(s6);
		Controller c6 = new Controller(repo6);

		/*
		 v=10;
		 new(v,20);
		 new(a,22);
		 wH(a,30);
		 print(a);
		 print(rH(a));
		 a=0
		 */
		
		Repo repo7 = new Repo("src/Logs/Repository/Problem7.txt");
		PrgState s7 = new PrgState();

		IStmt st2 = new CompStmt(new AssignStmt("v", new ConstExp(10)),
				new CompStmt(new HeapAllocationStmt("v", new ConstExp(20)),
						new CompStmt(new HeapAllocationStmt("a", new ConstExp(22)),
								new CompStmt(new HeapWritingStmt("a", new ConstExp(30)),
										new CompStmt(new PrintStmt(new VarExp("a")),
												new CompStmt(new PrintStmt(new HeapReadExp("a")),
														new AssignStmt("a", new ConstExp(0))))))));

		s7.addStatement(st2);
		repo7.addPrgState(s7);
		Controller c7 = new Controller(repo7);

		/*
		a=10,
		new(a,20);
		print(rH(a));
		a=100;
		print(rH(a))
		*/
		
		Repo repo8 = new Repo("src/Logs/Repository/Problem8.txt");
		PrgState s8 = new PrgState();

		IStmt st3 = new CompStmt(new AssignStmt("a", new ConstExp(10)),
				new CompStmt(new HeapAllocationStmt("a", new ConstExp(20)),
						new CompStmt(new PrintStmt(new HeapReadExp("a")),
								new CompStmt(new AssignStmt("a", new ConstExp(100)),
										new PrintStmt(new HeapReadExp("a"))))));

		s8.addStatement(st3);
		repo8.addPrgState(s8);
		Controller c8 = new Controller(repo8);

		/*
		 openRFile(var_f,\"input.txt\"); 
		 readFile(var_f,var_c);
		 print(var_c); 
		 (if var_c then 
		 	readFile(var_f,var_c);
		 	print(var_c)
		else 
			print(0))
		*/
		
		Repo repo9 = new Repo("src/Logs/Repository/Problem9.txt");

		PrgState s9 = new PrgState();
		OpenReadFileStmt orfs3 = new OpenReadFileStmt("src/Input/input.txt", "var_f");
		ReadFileStmt rfs11 = new ReadFileStmt(new VarExp("var_f"), "var_c");
		PrintStmt ps12 = new PrintStmt(new VarExp("var_c"));
		CompStmt cs12 = new CompStmt(rfs11, ps12);
		ReadFileStmt rfs12 = new ReadFileStmt(new VarExp("var_f"), "var_c");
		PrintStmt ps13 = new PrintStmt(new VarExp("var_c"));
		CompStmt cs13 = new CompStmt(rfs12, ps13);
		PrintStmt ps14 = new PrintStmt(new ConstExp(0));
		IfStmt if12 = new IfStmt(new VarExp("var_c"), cs13, ps14);


		s9.addStatement(if12);
		s9.addStatement(cs12);
		s9.addStatement(orfs3);
		repo9.addPrgState(s9);
		Controller c9 = new Controller(repo9);
		
		/*a=5, 
		 while a > 0 then 
		 	a = a - 1; 
		 print(a)*/
		
		PrgState s10 = new PrgState();
		AssignStmt as12 = new AssignStmt("a", new ConstExp(5));
		CompStmt cs14= new CompStmt(new AssignStmt("a", new ArithExp('-', new VarExp("a"), new ConstExp(1))), new PrintStmt(new VarExp("a")));
		WhileStmt w1 = new WhileStmt(new BoolExp(">", new VarExp("a"), new ConstExp(0)), cs14);

		s10.addStatement(w1);
		s10.addStatement(as12);
		
		Repo repo10 = new Repo("src/Logs/Repository/Problem10.txt");
		repo10.addPrgState(s10);
		Controller c10 = new Controller(repo10);
		
		/*
		a=10+(2<6), 
		print(a)
		*/
		
		PrgState s11 = new PrgState();
		CompStmt cs15 = new CompStmt(new AssignStmt("a", new ArithExp('+', new ConstExp(10), new BoolExp("<", new ConstExp(2), new ConstExp(6)))), new PrintStmt(new VarExp("a")));
		
		s11.addStatement(cs15);
		
		Repo repo11 = new Repo("src/Logs/Repository/Problem11.txt");
		repo11.addPrgState(s11);
		Controller c11 = new Controller(repo11);
		
		/*
		 * v=10;
		 * sleep(5);
		 * print(v*10)
		 */
		PrgState s12 = new PrgState();
		AssignStmt as13 = new AssignStmt("v",new ConstExp(10));
		SleepStmt sleep1 = new SleepStmt(new ConstExp(5));
		PrintStmt pr13 = new PrintStmt(new ArithExp('*', 
													new ConstExp(10),
													new VarExp("v")));
		
		s12.addStatement(pr13);
		s12.addStatement(sleep1);
		s12.addStatement(as13);
		
		Repo repo12 = new Repo("src/Logs/Repository/Problem12.txt");
		repo12.addPrgState(s12);
		Controller c12 = new Controller(repo12);
		
		TextMenu txtMenu = new TextMenu();
		txtMenu.addCommand(new ExitCommand("0", "Exit"));
		txtMenu.addCommand(new RunExample("1", "v = 1; print(v)", c1));
		txtMenu.addCommand(new RunExample("2", "a=2+3*4; b=a-8/2+5; Print(b)", c2));
		txtMenu.addCommand(new RunExample("3", "c=5-1; If c Then v=1 Else v=2; Print(v)", c3));
		txtMenu.addCommand(new RunExample("4","openRFile(var_f,\"test.in\"); " + "readFile(var_f,var_c);print(var_c); " + "(if var_c then readFile(var_f,var_c);print(var_c) " + "else print(0)); "+ "closeRFile(var_f) ",c4));
		txtMenu.addCommand(new RunExample("5","openRFile(var_f,\"test.in\"); " + "readFile(var_f+2,var_c);print(var_c); " + "(if var_c then readFile(var_f,var_c);print(var_c) " + "else print(0)); "+ "closeRFile(var_f) ",c5));
		txtMenu.addCommand(new RunExample("6", "v=10;new(v,20);new(a,22);print(100+rH(v));print(100+rH(a))", c6));
		txtMenu.addCommand(new RunExample("7", "v=10;new(v,20);new(a,22);wH(a,30);print(a);print(rH(a));a=0", c7));
		txtMenu.addCommand(new RunExample("8", "a=10,new(a,20);print(rH(a));a=100;print(rH(a))", c8));
		txtMenu.addCommand(new RunExample("9", "openRFile(var_f,\"input.txt\"); readFile(var_f,var_c);print(var_c); (if var_c then readFile(var_f,var_c);print(var_c) else print(0))",c9));
		txtMenu.addCommand(new RunExample("10", "a=5; while a > 0 do a = a - 1; print(a)",c10));
		txtMenu.addCommand(new RunExample("11", "a=10+(2<6), print(a)",c11));
		txtMenu.addCommand(new RunExample("12", "v=10 ; sleep(5); print(v*10)",c12));
		
		txtMenu.show();
	
	}
}