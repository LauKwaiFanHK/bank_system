package myproject;

public class Main {

	public static void main(String[] args) {
		MainLogic bankSystem = new MainLogic(System.in, System.out);
		bankSystem.mainLoop(args);

	}

}
