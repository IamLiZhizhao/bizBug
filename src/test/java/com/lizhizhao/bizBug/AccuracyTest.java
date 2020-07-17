package com.lizhizhao.bizBug;

import com.lizhizhao.bizBug.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
@Slf4j
class AccuracyTest {

	@Test
	void ShortTest() {
//		short s1 = 1;
//		s1 = s1 + 1;
//
//		short s1 = 1;
//		s1 += 1;
	}

	@Test
	void FloatTest() {
//		float f=3.4;
//		float f =(float)3.4;
//		float f =3.4F;
	}

	// region Double
	@Test
	void DoubleTest() {
		System.out.println(0.1+0.2);
		System.out.println(1.0-0.8);
		System.out.println(4.015*100);
		System.out.println(123.3/100);
		double amount1 = 2.15;
		double amount2 = 1.10;
		if (amount1 - amount2 == 1.05)
			System.out.println("amount1 - amount2 == 1.05 is true");
	}

	@Test
	void DoubleToBigDecimalTest() {
		System.out.println(new BigDecimal(0.1).add(new BigDecimal(0.2)));
		System.out.println(new BigDecimal(1.0).subtract(new BigDecimal(0.8)));
		System.out.println(new BigDecimal(4.015).multiply(new BigDecimal(100)));
		System.out.println(new BigDecimal(123.3).divide(new BigDecimal(100)));
		int compareNumber = (new BigDecimal(2.15).subtract(new BigDecimal(1.10))).compareTo(new BigDecimal(1.05));
		System.out.println(compareNumber == 0);
	}

	@Test
	void DoubleStringToBigDecimalTest() {
		System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")));
		System.out.println(new BigDecimal("1.0").subtract(new BigDecimal("0.8")));
		System.out.println(new BigDecimal("4.015").multiply(new BigDecimal("100")));
		System.out.println(new BigDecimal("123.3").divide(new BigDecimal("100")));
		int compareNumber = (new BigDecimal("2.15").subtract(new BigDecimal("1.10"))).compareTo(new BigDecimal("1.05"));
		System.out.println(compareNumber == 0);
	}

	// endregion

	// region BigDecimal

	@Test
	void StringToBigDecimalTest() {
		System.out.println(new BigDecimal("4.015").multiply(new BigDecimal("100")));
		System.out.println(new BigDecimal("4.015").multiply(new BigDecimal(Double.toString(100))));
		System.out.println(new BigDecimal("4.015").multiply(new BigDecimal(String.valueOf(100))));
		System.out.println(new BigDecimal("4.015").multiply(new BigDecimal(String.valueOf(100d))));
		//BigDecimal 有 scale 和 precision 的概念，scale 表示小数点右边的位数，而 precision 表示精度，也就是有效数字的长度。
		//调试一下可以发现，
		// new BigDecimal(Double.toString(100)) 得到的 BigDecimal 的 scale=1、precision=4；
		// 而 new BigDecimal(“100”) 得到的 BigDecimal 的 scale=0、precision=3。
	}

	@Test
	void testScale() {
		BigDecimal bigDecimal1 = new BigDecimal("100");
		BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(100d));
		BigDecimal bigDecimal3 = new BigDecimal(String.valueOf(100));
		BigDecimal bigDecimal4 = BigDecimal.valueOf(100d);
		BigDecimal bigDecimal5 = new BigDecimal(Double.toString(100));
		print(bigDecimal1); //scale 0 precision 3 result 401.500
		print(bigDecimal2); //scale 1 precision 4 result 401.5000
		print(bigDecimal3); //scale 0 precision 3 result 401.500
		print(bigDecimal4); //scale 1 precision 4 result 401.5000
		print(bigDecimal5); //scale 1 precision 4 result 401.5000
	}
	void print(BigDecimal bigDecimal){
		log.info("scale {} precision {} result {}", bigDecimal.scale(), bigDecimal.precision(), bigDecimal.multiply(new BigDecimal("4.015")));
	}

	@Test
	void BigDecimalTest() {
		BigDecimal a =new BigDecimal(0.1);
		System.out.println("a values is:"+a);
		System.out.println("=====================");
		BigDecimal b =new BigDecimal("0.1");
		System.out.println("b values is:"+b);

		BigDecimal zero =new BigDecimal(0);
		System.out.println("0 values is:"+zero);
		BigDecimal zero1 =new BigDecimal(0.0);
		System.out.println("0.0 values is:"+zero);
		System.out.println("0=0 values is:" + zero.equals(BigDecimal.ZERO));
		System.out.println("0.0=0 values is:" + zero1.equals(BigDecimal.ZERO));
		System.out.println("0=0.0 values is:" + zero.equals(zero1));

		BigDecimal one =new BigDecimal(1);
		BigDecimal one1 =new BigDecimal(1.0);
		print(one);
		print(one1);
		System.out.println("1=1 values is:" + one.equals(BigDecimal.ONE));
		System.out.println("1.0=1 values is:" + one1.equals(BigDecimal.ONE));
	}

	@Test
	void BigDecimalDivideTest() {
		int a = 3;
		BigDecimal b =new BigDecimal("10");
		System.out.println("b/10 values is:"+ b.divide(BigDecimal.TEN));
//		System.out.println("b/10 values is:"+ b.divide(BigDecimal.ZERO));
		System.out.println("a/b values is:"+ b.divide(new BigDecimal(a)));
	}

	// endregion
}
