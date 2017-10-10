/**  
 * Project Name:study  
 * File Name:FinalKeyWordTest.java  
 * Package Name:study.basic.terms  
 * Date:2017年10月10日上午9:24:35  
 * Copyright (c) 2017
 *  
*/  
  
package study.basic.terms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**  
 * ClassName:FinalKeyWordTest <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年10月10日 上午9:24:35 <br/>  
 * @author   YangGuangFeng  
 * @version    
 * @since    JDK 1.8  
 * @see        
 */
public class FinalKeyWordTest {
	
//	final static String test = "123";
	final static Map map = new HashMap<String,String>(7);
	
	public static void main(String[] args) {
//		test = "456";
		map.put("test", "value1");
		map.put("test", "value1");
		map.put("test", "value2");
		map.put("test", "value3");
		Set entrySet = map.entrySet();
			
		}

}
  
