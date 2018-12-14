package corejava.wymb.proxy.dynamicProxy.jdkproxy;

/**
 * 被代理的实际类
 * @author Administrator
 *
 */

public class Student implements Person {

	private String name;

	public Student(String name) {
		this.name = name;
	}

	@Override
	public void giveMoney() {
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println(name+"：上交班费50元。");
	}

	@Override
	public void saveMoney() {
		// TODO Auto-generated method stub
		System.out.println(name+"：收取班费50元。");
	}
}




