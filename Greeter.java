public class Greeter {
	String name;
	public Greeter(String name) {
	this.name = name;
	}

	public String greet() {
		return "Hello " + name + ", nice to meet you!");
	}
}
