/**
 *
 */
package sub;

import org.junit.Before;

/**
 * @author downey
 *
 */
public class MyFixedHashMapTest extends MyLinearMapTest {

	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		map = new MyFixedHashMap<String, Integer>();
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);
		map.put(null, 0);
	}
}
