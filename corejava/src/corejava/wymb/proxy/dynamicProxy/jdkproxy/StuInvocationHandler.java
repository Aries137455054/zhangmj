package corejava.wymb.proxy.dynamicProxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StuInvocationHandler<T> implements InvocationHandler {

	//InvocationHandler持有的委托类对象
	T target;
	
	public StuInvocationHandler(T t){
		this.target = t;
	}
	
	/**
	 * @param proxy 动态代理对象
	 * @param method 目标方法
	 * @param args 目标方法的参数
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理执行"+method.getName()+"方法");
		MonitorUtil.start();
		Object result = method.invoke(target, args);
		MonitorUtil.finished(method.getName());
		return result;
	}
}
