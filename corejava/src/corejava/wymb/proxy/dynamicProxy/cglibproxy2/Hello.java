package corejava.wymb.proxy.dynamicProxy.cglibproxy2;

public class Hello {

	public String sayHello(boolean throwException) throws Exception{
		System.out.println("Hello everyone!");
		if(throwException){
			throw new Exception("Test Exception.....");
		}
		return "123";
	}
}
