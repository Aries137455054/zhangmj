package corejava.wymb.proxy.dynamicProxy.cglibproxy2;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyFactory implements MethodInterceptor {

	private Object target;
	
	public Object createProxy(Object target){
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		enhancer.setClassLoader(target.getClass().getClassLoader());
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		Object result = null;
		
		try{
			before();
			result = proxy.invokeSuper(obj, args);
			after();
		}catch(Exception e){
			exception();
		}finally {
			beforeReturning();
		}
		return result;
	}
	
	public void before(){
		System.out.println("前置通知");
	}
	
	public void after(){
		System.out.println("后置通知");
	}
	
	public void exception(){
		System.out.println("异常通知");
	}
	
	public void beforeReturning(){
		System.out.println("返回通知");
	}

}
