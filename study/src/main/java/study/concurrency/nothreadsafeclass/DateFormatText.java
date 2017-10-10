/**  
 * Project Name:study  
 * File Name:DateFormatText.java  
 * Package Name:study  
 * Date:2017年10月9日下午4:14:00  
 * Copyright (c) 2017
 *  
*/  
  
package study.concurrency.nothreadsafeclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**  
 * ClassName:DateFormatText <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年10月9日 下午4:14:00 <br/>  
 * @author   YangGuangFeng  
 * @version    
 * @since    JDK 1.8  
 * @see        
 */
public class DateFormatText extends Thread {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	
	private String name;
	private String dateStr;
	private boolean sleep;
	
	public DateFormatText(String name, String dateStr, boolean sleep) {
		super();
		this.name = name;
		this.dateStr = dateStr;
		this.sleep = sleep;
	}
	@Override
	public void run() {
		if(sleep){
			try {
				TimeUnit.MILLISECONDS.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();  
			}
		}
		Date parse = null ;
		try {
			parse = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();  
		}
		System.out.println(name + " date " + parse);
	}
	
	public static void main(String[] args) {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		newCachedThreadPool.submit(new DateFormatText("线程A","2001-02-11", true));
		newCachedThreadPool.submit(new DateFormatText("线程b", "2017-01-01", false));
		newCachedThreadPool.shutdown();	
	}

}
  
