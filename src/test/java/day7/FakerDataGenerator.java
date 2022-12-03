package day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {
	
	@Test
	void testGenerateDummyData() {
		Faker fake = new Faker();
		
		String firstname=fake.name().firstName();
		String emailadd= fake.internet().emailAddress();
		String lastname=fake.name().lastName();
		String password=fake.internet().password();
		String nation=fake.country().capital();
		
		System.out.println(firstname);
		System.out.println(emailadd);
		System.out.println(lastname);
		System.out.println(password);
		System.out.println(nation);
		
		
	}

}
