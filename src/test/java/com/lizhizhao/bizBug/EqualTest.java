package com.lizhizhao.bizBug;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
class EqualTest {

	@Test
	void IntegerTest() {
		Integer a = 127; //Integer.valueOf(127)
		Integer b = 127; //Integer.valueOf(127)
		log.info("\nInteger a = 127;\n" +
				"Integer b = 127;\n" +
				"a == b ? {}",a == b); // true
		Integer c = 128; //Integer.valueOf(128)
		Integer d = 128; //Integer.valueOf(128)
		log.info("\nInteger c = 128;\n" +
				"Integer d = 128;\n" +
				"c == d ? {}", c == d); //false
		Integer e = 127; //Integer.valueOf(127)
		Integer f = new Integer(127); //new instance
		log.info("\nInteger e = 127;\n" +
				"Integer f = new Integer(127);\n" +
				"e == f ? {}", e == f); //false
		Integer g = new Integer(127); //new instance
		Integer h = new Integer(127); //new instance
		log.info("\nInteger g = new Integer(127);\n" +
				"Integer h = new Integer(127);\n" +
				"g == h ? {}", g == h); //false
		Integer i = 128; //unbox
		int j = 128;
		log.info("\nInteger i = 128;\n" +
				"int j = 128;\n" +
				"i == j ? {}", i == j); //true
	}

	@Test
	void StringTest() {
		String a = "1";
		String b = "1";
		log.info("\nString a = \"1\";\n" +
				"String b = \"1\";\n" +
				"a == b ? {}", a == b); //true
		String c = new String("2");
		String d = new String("2");
		log.info("\nString c = new String(\"2\");\n" +
				"String d = new String(\"2\");" +
				"c == d ? {}", c == d); //false
		String e = new String("3").intern();
		String f = new String("3").intern();
		log.info("\nString e = new String(\"3\").intern();\n" +
				"String f = new String(\"3\").intern();\n" +
				"e == f ? {}", e == f); //true
		String g = new String("4");
		String h = new String("4");
		log.info("\nString g = new String(\"4\");\n" +
				"String h = new String(\"4\");\n" +
				"g.equals(h) ? {}", g.equals(h)); //true
	}
}
