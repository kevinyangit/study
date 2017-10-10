/**  
 * Project Name:study  
 * File Name:DateUtils.java  
 * Package Name:study.concurrency.nothreadsafeclass  
 * Date:2017年10月9日下午5:53:02  
 * Copyright (c) 2017
 *  
*/  
  
package study.concurrency.nothreadsafeclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**  
 * ClassName:DateUtils <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年10月9日 下午5:53:02 <br/>  
 * @author   YangGuangFeng  
 * @version    
 * @since    JDK 1.8  
 * @see        
 */
public class DateUtils {
	//同步锁
	private static final Object objLock = new Object();
	//保存不同的patter的sdf对象的map
	private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();
	
	private static SimpleDateFormat getSdf(final String pattern){
		ThreadLocal<SimpleDateFormat> threadLocal = sdfMap.get(pattern);
		//如果没有，将把sdf添加在map中，为了防止重复添加，双重判断，并加锁
		if(null == threadLocal){
			//加锁
			synchronized (objLock) {
				//有一种可能，因为他是多线程的，如果他还没有在synchronized语句的时候，已经添加过一个sdf，那下面的会导致重复添加，所以在添加之前，还要做一次判断，双重判断
				threadLocal = sdfMap.get(pattern);
				if (null == threadLocal) {
					   System.out.println("put new sdf of pattern " + pattern + " to map");
					   //有点像线程，匿名类
					   threadLocal = new ThreadLocal<SimpleDateFormat>(){
						@Override
						protected SimpleDateFormat initialValue() {
							 System.out.println("thread: " + Thread.currentThread() + " init pattern: " + pattern);
	                            return new SimpleDateFormat(pattern);
						}
					};
					sdfMap.put(pattern, threadLocal);
				}
			}
		}
		return threadLocal.get();
	}
	
	//通过ThreadLocal来获取SimpleDateFormat，每个线程只能一个sdf
	public static Date parse(String pattern, String dateStr) throws ParseException{
		Date parse = getSdf(pattern).parse(dateStr);
		return parse;
	}
	
	public static String format(String pattern, Date date){
		return getSdf(pattern).format(date);
	}

}
  
