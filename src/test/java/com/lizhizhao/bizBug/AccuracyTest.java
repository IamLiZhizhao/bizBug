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
		System.out.println("0=0 values is:"+zero.compareTo(zero1));
		System.out.println("0=0 values is:"+zero.compareTo(BigDecimal.ZERO));
		System.out.println("0.0=0 values is:"+zero.compareTo(BigDecimal.ZERO));
	}

	@Test
	void BigDecimalDivideTest() {
		int a = 3;
		BigDecimal b =new BigDecimal("10");
		System.out.println("b/10 values is:"+ b.divide(BigDecimal.TEN));
//		System.out.println("b/10 values is:"+ b.divide(BigDecimal.ZERO));
		System.out.println("a/b values is:"+ b.divide(new BigDecimal(a)));
	}

}
