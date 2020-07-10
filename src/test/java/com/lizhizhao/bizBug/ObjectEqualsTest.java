package com.lizhizhao.bizBug;

import com.lizhizhao.bizBug.entity.Employee;
import com.lizhizhao.bizBug.entity.Person;
import com.lizhizhao.bizBug.entity.Point;
import com.lizhizhao.bizBug.entity.PointWrong;
import com.lizhizhao.bizBug.entity.Student;
import com.lizhizhao.bizBug.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
@Slf4j
class ObjectEqualsTest {

	@Test
	void PointTest() {
		Point p1 = new Point(1, 2, "a");
		Point p2 = new Point(1, 2, "b");
		Point p3 = new Point(1, 2, "a");
		log.info("p1.equals(p2) ? {}", p1.equals(p2));
		log.info("p1.equals(p3) ? {}", p1.equals(p3));
	}

	@Test
	void PointWrongTest() {
		PointWrong p1 = new PointWrong(1, 2, "a");
		try {
			log.info("p1.equals(null) ? {}", p1.equals(null));
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		Object o = new Object();
		try {
			log.info("p1.equals(expression) ? {}", p1.equals(o));
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		PointWrong p2 = new PointWrong(1, 2, "b");
		log.info("p1.equals(p2) ? {}", p1.equals(p2));
	}

	@Test
	void PointWrongSetTest() {
		PointWrong p1 = new PointWrong(1, 2, "a");
		PointWrong p2 = new PointWrong(1, 2, "b");

		List<PointWrong> pointList = new ArrayList<>();
		pointList.add(p1);
		log.info("List : pointList.contains(p2) ? {}", pointList.contains(p2));
//		1、List的contains(obj)方法
//		实际上，List调用contains(Object obj)方法时，会遍历List中的每一个元素，然后再调用每个元素的equals()方法去跟contains()方法中的参数进行比较，
//		如果有一个元素的equals()方法返回true则contains()方法返回true，
//		否则所有equals()方法都不返回true，则contains()方法则返回false。

		HashSet points = new HashSet<>();
		points.add(p1);
		log.info("HashSet : points.contains(p2) ? {}", points.contains(p2));
//		2、HashSet的Contains(obj)方法
//		当调用HashSet的contains(Object obj)方法时，其实是先调用每个元素的hashCode()方法来返回哈希码，如果哈希码的值相等的情况下再调用equals(obj)方法去判断是否相等，
//		只有在这两个方法所返回的值都相等的情况下，才判定这个HashSet包含某个元素。

	}

	@Test
	void UserTest() {
		List list = new ArrayList<>();
		list.add(new Student(1, "zhang"));
		list.add(new Student(2, "wang"));
		Student student = new Student(2, "li");
		log.info("ArrayList.indexOf");
		int index1 = list.indexOf(student);

		// binarySearch 方法内部调用了元素的 compareTo 方法进行比较；
		Collections.sort(list);
		log.info("Collections.binarySearch");
		int index2 = Collections.binarySearch(list, student);
		log.info("index1 = " + index1);
		log.info("index2 = " + index2);
	}


	@Test
	void PersonTest() {
		// 认为identity相同就是同一个人
		Person person1 = new Person("zhuye","001");
		Person person2 = new Person("Joseph","001");
		log.info("person1.equals(person2) ? {}", person1.equals(person2));


	}

	@Test
	void EmployeeTest() {
		// 同属一家公司，但不是同一个人
		Employee employee1 = new Employee("zhuye","001", "bkjk.com");
		Employee employee2 = new Employee("Joseph","002", "bkjk.com");
		log.info("employee1.equals(employee2) ? {}", employee1.equals(employee2));
	}


}
