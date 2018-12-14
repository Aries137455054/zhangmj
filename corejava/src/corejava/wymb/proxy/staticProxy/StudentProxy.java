package corejava.wymb.proxy.staticProxy;

public class StudentProxy implements Person {

	Person stu;
	
	public StudentProxy(Person stu){
		if(stu.getClass() == Student.class){
			this.stu = (Student) stu;
		}else{
			this.stu = (Student1) stu;
		}
	}
	
	@Override
	public void giveMoney() {
		stu.giveMoney();
	}

	public static void main(String[] args) {
		Person p = new StudentProxy(new Student1("张三"));
		p.giveMoney();
	}
}
