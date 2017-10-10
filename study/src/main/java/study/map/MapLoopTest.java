/**  
 * Project Name:study  
 * File Name:MapLoopTest.java  
 * Package Name:study.map  
 * Date:2017年10月10日上午10:14:05  
 * Copyright (c) 2017
 *  
*/  
  
package study.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**  
 * ClassName:MapLoopTest <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年10月10日 上午10:14:05 <br/>  
 * @author   YangGuangFeng  
 * @version    
 * @since    JDK 1.8  
 * @see        
 */
public class MapLoopTest {
	//loop的4个方法
	public static void main(String[] args) {
		HashMap<String,String> hashMap = new HashMap<String, String>(7);
		hashMap.put("1", "1");
		hashMap.put("2", "2");
		hashMap.put("3", "3");
		hashMap.put("4", "4");
		//1。foreach的方法entrySet
		Set<Entry<String,String>> entrySet = hashMap.entrySet();
		for (Entry<String, String> entry : entrySet) {
			System.out.println("key: " + entry.getKey() + " , value: " + entry.getValue());
		}
		//2。foreach的方法keySet
		Set<String> keySet = hashMap.keySet();
		for (String string : keySet) {
			System.out.println("key: " + string + ", value: " + hashMap.get(string));
		}
		//3。foreach的方法valueSet,只能拿到value
		Collection<String> values = hashMap.values();
		for (String string : values) {
			System.out.println(" value: " + string);
		}
		//4。while的方法iterator,迭代器只能用于集合中的set和List,而不能直接用于map
		Iterator<Entry<String, String>> iterator = hashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<java.lang.String, java.lang.String> entry = (Map.Entry<java.lang.String, java.lang.String>) iterator
					.next();
			System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
			
		}
	}

}
  
