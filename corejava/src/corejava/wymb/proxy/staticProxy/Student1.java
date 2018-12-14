package corejava.wymb.proxy.staticProxy;

public class Student1 implements Person {
	
	private String name;
	
	public Student1(String name){
		this.name = name;
	}

	@Override
	public void giveMoney() {
		System.out.println("不交");
	}

}
