package corejava.wymb.proxy.dynamicProxy.cglibproxy2;

public class EnhancerTest {

	public static void main(String[] args) throws Exception {
		ProxyFactory factory = new ProxyFactory();
		Hello proxy = (Hello) factory.createProxy(new Hello());
		String result = proxy.sayHello(false);
		System.out.println(result);
	}
}
