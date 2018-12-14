package corejava.wymb.proxy.dynamicProxy.cglibproxy;

public class TestCgLib {

	public static void main(String[] args) {
		BookFacadeCgLib cgLib = new BookFacadeCgLib();
		BookFacadeImpl bookFacadeImpl = (BookFacadeImpl) cgLib.getInstance(new BookFacadeImpl());
		bookFacadeImpl.addBook();
	}
}
