package corejava.wymb.proxy.dynamicProxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		//创建一个被代理的实例对象
		Person zhangsan = new Student("张三");
		//创建一个与代理对象相关联的InvocationHandler对象
		InvocationHandler stuHandler = new StuInvocationHandler<Person>(zhangsan);
		//1:指定当前目标对象使用类加载器   2:目标对象实现的接口的类型  
		// 3:事件处理,执行目标对象的方法时,会触发事件处理器的方法,会把当前执行目标对象的方法作为参数传入
		Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);
		stuProxy.giveMoney();
		
		Person zhangsan1 = new Student1();
		InvocationHandler stuHandler1 = new StuInvocationHandler<Person>(zhangsan1);
		Person stuProxy1 = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler1);
		stuProxy1.giveMoney();
	}
}
