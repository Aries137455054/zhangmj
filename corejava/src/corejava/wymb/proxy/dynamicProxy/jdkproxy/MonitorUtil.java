package corejava.wymb.proxy.dynamicProxy.jdkproxy;

public class MonitorUtil {

	private static ThreadLocal<Long> tl = new ThreadLocal<>();

	public static void start() {
		tl.set(System.currentTimeMillis());
	}
	
	public static void finished(String methodName){
		System.out.println(methodName+"：方法耗时 "+(System.currentTimeMillis()-tl.get())+"ms");
	}
}
