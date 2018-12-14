package corejava.wymb.redis;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class MyRedis {

	public static JedisPoolConfig poolConfig = new JedisPoolConfig();
	//public static JedisPool pool = new JedisPool(poolConfig, "39.108.226.62", 6379,1000000);
	public static JedisPool pool = new JedisPool(poolConfig, "localhost", 6379,1000000);
	public static Jedis jedis = pool.getResource();
	
	public static void add(){
		long a = System.currentTimeMillis();
		for(int i= 0 ; i<50000;i++){
			jedis.set("a"+i, "张明杰"+i);
		}
		long b = System.currentTimeMillis();
		System.out.println("所用时间：" + (b - a) + "毫秒");
	}
	
	public static void query(){
		int i = 0;
		long a = System.currentTimeMillis();
		Set<String> name = jedis.keys("b*");
		Iterator iter = name.iterator();
		 while (iter.hasNext() && (++i) < 25) {
			 System.out.println(i++);
			 System.out.println(iter.next().toString());
		 }
		long b = System.currentTimeMillis();
		System.out.println("所用时间：" + (b - a) + "毫秒");
	}
	
	public static void main(String[] args) {
		//添加一千万条set数据的时间：358653毫秒
		//add();
		//query();
		
		Jedis jedis = pool.getResource();
		String result = jedis.get("REDIS_USER:1:USER_BASE_INFO");
		System.out.println(result);
	}
}
