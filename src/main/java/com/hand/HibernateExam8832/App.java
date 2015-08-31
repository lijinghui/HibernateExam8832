package com.hand.HibernateExam8832;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Dao.CustomerDao;
import com.Dao.AddressDao;
import com.hand.model.Address;
import com.hand.model.Customer;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao imp = (CustomerDao) context.getBean("CustomerDaoImp");
		AddressDao adimp = (AddressDao) context.getBean("AddressDaoImp");

		Scanner sc = new Scanner(System.in);
		System.out.println("请输入FirstName(first_name):");
		String f = sc.next();
		System.out.println("请输入LastName(last_name):");
		String l = sc.next();
		System.out.println("请输入Email(email):");
		String e = sc.next();
		int a;
		while (true) {
			System.out.println("请输入AddressID:");
			a = sc.nextInt();
			if (a < 603 && a > 0) {
				break;
			} else {
				System.out.println("你输入的id不存在请重新输入");
			}
		}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String str = sdf.format(date);
		Customer cus = new Customer();
		cus.setFirstName(f);
		cus.setLastName(l);
		cus.setEmail(e);
		Address address = new Address();
		address.setAddressId((short) a);
		cus.setAddress(address);
		imp.saveCus(cus);
		System.out.println(cus.getFirstName());
		System.out.println(cus.getLastName());
		System.out.println(cus.getEmail());
		System.out.println(cus.getAddress().getAddress());
		int c;
		while (true) {
			System.out.println("请输入要删除的id:");
			c = sc.nextInt();
			if (c < 606 && c > 0) {
				Customer custom = new Customer();
				custom.setCustomerId((short) c);
				imp.delCus(custom);
				break;
			} else {
				System.out.println("你输入的id不存在请重新输入");
			}
		}
		adimp.getAd((short) 1);
	}
}
