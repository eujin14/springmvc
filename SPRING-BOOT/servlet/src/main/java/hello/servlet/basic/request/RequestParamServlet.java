package hello.servlet.basic.request;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
* 1. 파라미터 전송 기능
* http://localhost:8080/request-param?username=hello&age=20
* <p>
* 2. 동일한 파라미터 전송 가능
* http://localhost:8080/request-param?username=hello&username=kim&age=20
*/
@WebServlet(name = "requesParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
	
	@Override
	 protected void service(HttpServletRequest request, HttpServletResponse
	response) throws ServletException, IOException {
	 System.out.println("[전체 파라미터 조회] - start");
	 /*
	 Enumeration<String> parameterNames = request.getParameterNames();
	 while (parameterNames.hasMoreElements()) {
	 String paramName = parameterNames.nextElement();
	 System.out.println(paramName + "=" + 
	request.getParameter(paramName));
	 }
	 */
	 request.getParameterNames().asIterator()
	 .forEachRemaining(paramName -> System.out.println(paramName +
	"=" + request.getParameter(paramName)));
	 System.out.println("[전체 파라미터 조회] - end");
	 
	 
	 System.out.println("[단일 파라미터 조회] - start");
	 String username = request.getParameter("username");
	 String age = request.getParameter("age");
	 System.out.println("request.getParameter(username) = " + username);
	 System.out.println("request.getParameter(age) = " + age);
	 System.out.println("[단일 파라미터 조회] - end");
	 
	 // 파라미터 이름을 중복해서 넘어갈 수 있다. 이런경우 내부 우선순위에 의해서 먼저 잡히는것이 나오게된다.
	 System.out.println("[이름이 같은 복수 파라미터 조회]-start");
	 System.out.println("request.getParameterValues(username)");
	 String[] usernames = request.getParameterValues("username");
	 for (String name : usernames) {
	 System.out.println("username=" + name); 
	 }
	 
	 System.out.println("[이름이 같은 복수 파라미터 조회]-end");
	 response.getWriter().write("ok");
	 }
	}