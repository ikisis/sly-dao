package s.l.y.dao.util;

import static org.junit.Assert.*;

import org.junit.Test;

import s.l.y.dao.TestDomain;

public class NameUtilsTest {

	@Test
	public void test() {
		
		System.out.println(NameUtils.generateTableName(TestDomain.class));
		
		System.out.println();
		
	}

}

