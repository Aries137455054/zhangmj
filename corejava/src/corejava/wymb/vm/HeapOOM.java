package corejava.wymb.vm;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<>();
		Runtime myRun = Runtime.getRuntime();
		System.out.println("已用内存" + myRun.totalMemory()/(1024*1024)+"MB");
		System.out.println("最大内存" + myRun.maxMemory());
		System.out.println("可用内存" + myRun.freeMemory());
		for (int i = 0; i < 900; i++) {
			list.add(new OOMObject());
		}
	}

	static class OOMObject{
		
	}
}
