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
import com.hand.model.Store;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
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
			Address address = adimp.getAd((short) a);
			if (!address.equals(null)) {
				break;
			} else {
				System.out.println("你输入的id不存在请重新输入");
			}
		}
		Date date = new Date();
		Customer cus = new Customer();
		cus.setFirstName(f);
		cus.setLastName(l);
		cus.setEmail(e);
		Store store = new Store();
		store.setStoreId((byte) 1);
		cus.setStore(store);
		Address address = new Address();
		address.setAddressId((short) a);
		cus.setAddress(address);
		cus.setCreateDate(date);
		int i = imp.saveCus(cus);
		System.out.println("已保存数据如下");

		System.out.println("id"+"\t" + i);
		System.out.println("FirstName" + "\t" + cus.getFirstName());
		System.out.println("LastName" + "\t" + cus.getLastName());
		System.out.println("Email" + "\t" + cus.getEmail());
		System.out.println("地址" + "\t" + (adimp.getAd(cus.getAddress().getAddressId())).getAddress());

		int c ;
		try {
			while (true) {
				System.out.println("请输入要删除的id:");
				c = sc.nextInt();
				System.out.println(imp.getCus(c).getFirstName());
				if (!imp.getCus(c).equals(null)) {
					imp.delCus((short)c);
					break;
					
				} else {
					System.out.println("你输入的id不存在请重新输入");
					
				}
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		System.out.println("已删除");
		System.exit(1);
	}
}
