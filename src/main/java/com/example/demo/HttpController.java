package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class HttpController extends HttpServlet {
	
	@Autowired
	UserRepository usersRep;
	
	static ArrayList<User> l = new ArrayList<User>();
	@PostMapping("/1user")
	@ResponseBody
	public List<User> postForm(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		
		if(email == null || password == null || !password.equals("12345")) {
			response.setStatus(401);
			return null;
		}
		return usersRep.findAll();
	}
	@GetMapping("/1")
	public String mainPage(HttpServletRequest request, HttpServletResponse response) {
		response.setStatus(201);
		return "<html>"
		+"<form name='test' method='post' action='http://localhost:8080/'>"
		+ "<p><b>Фамилия:</b><br>"
		+"<input type='text' name='email' size='40'>"
		+"</p>"
		+"<p><b>Имя:</b><br>"
	    +"<input type='text' name='pwd' size='40'>"
	    +"</p>"
	    +"<p>"
	    +"<input type='submit' value='Отправить'>"
    	+"</p>"
		+"</form>"
		+"</html>";
	}
	@PutMapping("/1user")
	public void save(@RequestBody User user) {
		usersRep.save(user);
		System.out.println(user.getName() + " " + user.getLastname());
	}
}
