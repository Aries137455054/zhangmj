package secondriver.hessian.server.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hessian.api.bean.Person;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

public class PostDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public PostDataServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理请求
		ServletInputStream sis = request.getInputStream();
		Hessian2Input h2i = new Hessian2Input(sis);
		h2i.startMessage();
		Person pserson = (Person) h2i.readObject();
		System.out.println("receive:\n"+pserson.toString());
		System.out.println(h2i.readString());
		h2i.completeMessage();
		h2i.close();
		sis.close();
		
		//发送响应
		response.setCharacterEncoding("UTF-8");
		response.setContentType("x-application/hessian");
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Hessian2Output h2o = new Hessian2Output(bos);
		h2o.startMessage();
		h2o.writeObject(getPerson());
		h2o.writeString("Im am server.");
		h2o.completeMessage();
		h2o.close();
		
		ServletOutputStream sos = response.getOutputStream();
		sos.write(bos.toByteArray());
		sos.flush();
		bos.close();
		sos.close();
	}

	public static Person getPerson(){
		Person person = new Person();
		person.setAddress(new String[] { "ShangHai", "ShenZhen", "ChengDu" });
		person.setBrithday(new Date());
		person.setGender(true);
		person.setHeight(176.66);
		person.setId(301);
		person.setName("张明杰");
		person.setPhone(17603083280L);
		person.setWeight(55.2F);
		return person;
	}
}
