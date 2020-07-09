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

		HashSet points = new HashSet<>();
		points.add(p1);
		log.info("HashSet : points.contains(p2) ? {}", points.contains(p2));

	}

	@Test
	void UserTest() {
		List list = new ArrayList<>();
		list.add(new Student(1, "zhang"));
		list.add(new Student(2, "wang"));
		Student student = new Student(2, "li");
		log.info("ArrayList.indexOf");
		int index1 = list.indexOf(student);
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
