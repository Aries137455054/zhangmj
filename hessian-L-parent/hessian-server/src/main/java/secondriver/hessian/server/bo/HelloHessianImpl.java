package secondriver.hessian.server.bo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.hessian.api.HelloHessian;
import org.hessian.api.bean.Person;

public class HelloHessianImpl implements HelloHessian {

	private static Person[] persons = new Person[5];
	static{
		Random random = new Random();
		System.out.println(random);
		for (int i = 0; i < persons.length; i++) {
			persons[i] = new Person();
			persons[i].setId(i+1);
			persons[i].setGender(random.nextBoolean());
			persons[i].setName("aaaaaaaaaaa-" + i);
			persons[i].setPhone(random.nextLong());
			persons[i].setHeight(random.nextDouble());
			persons[i].setWeight(random.nextFloat());
			persons[i].setAddress(new String[] { "Address" + random.nextInt(),
					"Address" + random.nextInt() });

			Calendar c = Calendar.getInstance();
			c.set(Calendar.DATE, i + 1);
			persons[i].setBrithday(c.getTime());
		}
	}
	
	public String sayHello() {
		return "Hello Hessian "+ new Date().toString();
	}

	public String sayHello(String name) {
		return "Welcome "+name;
	}

	public List<Person> getPersons() {
		return Arrays.asList(persons);
	}

	public Person getPersonById(int id) {
		for (Person person : persons) {
			if(person.getId() == id){
				return person;
			}
		}
		return null;
	}

	public boolean uploadFile(String fileName, InputStream data) {
		List<String> temp;
		try {
			temp = IOUtils.readLines(data);
			String filePath = System.getProperty("user.key")+"/upload/"+fileName;
			FileUtils.writeLines(new File(filePath), temp);
			System.out.println("upload file to:"+filePath);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public byte[] downloadFile(String fileName) {
		String filePath = System.getProperty("user.key")+"/upload/"+fileName;
		InputStream data = null;
		try {
			data = new FileInputStream(filePath);
			int size = data.available();
			byte[] buffer = new byte[size];
			IOUtils.read(data, buffer);
			return buffer;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			IOUtils.closeQuietly(data);
		}
	}

}
