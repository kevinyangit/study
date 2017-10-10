/**  
 * Project Name:study  
 * File Name:Test.java  
 * Package Name:study.concurrency.nothreadsafeclass  
 * Date:2017年10月9日下午7:59:29  
 * Copyright (c) 2017
 *  
*/  
  
package study.concurrency.nothreadsafeclass;

import java.text.ParseException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**  
 * ClassName:Test <br/>  
 * Date:     2017年10月9日 下午7:59:29 <br/>  
 * @author   YangGuangFeng  
 * @version    
 * @since    JDK 1.8  
 * @see        
 */
public class Test {
	private static final String PATTER1 = "yyyy-MM-dd";
	private static final String PATTER2 = "yyyy-MM";
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			@Override
			public void run() {
				try {
					DateUtils.parse(PATTER1, "2011-01-22");
				} catch (ParseException e) {
					e.printStackTrace();  
					
				}
			}
		};
		t1.setName("t1");
		Thread t2 = new Thread(){
			@Override
			public void run() {
				try {
					DateUtils.parse(PATTER2, "2011-01");
				} catch (ParseException e) {
					e.printStackTrace();  
					
				}
			}
		};
		t2.setName("t2");
		Thread t3 = new Thread(){
			@Override
			public void run() {
				try {
					DateUtils.parse(PATTER1, "2011-01-22");
				} catch (ParseException e) {
					e.printStackTrace();  
					
				}
			}
		};
		t3.setName("t3");
		Thread t4 = new Thread(){
			@Override
			public void run() {
				try {
					DateUtils.parse(PATTER2, "2011-01");
				} catch (ParseException e) {
					e.printStackTrace();  
					
				}
			}
		};
		t4.setName("t4");
		Thread t5 = new Thread(){
			@Override
			public void run() {
				try {
					DateUtils.parse(PATTER1, "2011-01-22");
				} catch (ParseException e) {
					e.printStackTrace();  
					
				}
			}
		};
		t5.setName("t5");
		Thread t6 = new Thread(){
			@Override
			public void run() {
				try {
					DateUtils.parse(PATTER2, "2011-01");
				} catch (ParseException e) {
					e.printStackTrace();  
					
				}
			}
		};
		t6.setName("t6");
		//单个线程
		System.out.println("单个线程");
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
		newFixedThreadPool.submit(t1);
		newFixedThreadPool.submit(t2);
		newFixedThreadPool.submit(t3);
		newFixedThreadPool.submit(t4);
		newFixedThreadPool.submit(t5);
		newFixedThreadPool.submit(t6);
		newFixedThreadPool.shutdown();
		//2个线程
		sleep(1000);
		System.out.println("多个线程");
		ExecutorService newFixedThreadPool2 = Executors.newFixedThreadPool(2);
		newFixedThreadPool2.submit(t1);
		newFixedThreadPool2.submit(t2);
		newFixedThreadPool2.submit(t3);
		newFixedThreadPool2.submit(t4);
		newFixedThreadPool2.submit(t5);
		newFixedThreadPool2.submit(t6);
		newFixedThreadPool2.shutdown();
		
	}
	private static void sleep(long timeout) {
		try {
			TimeUnit.MILLISECONDS.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();  
		}
		
	}

}
  
