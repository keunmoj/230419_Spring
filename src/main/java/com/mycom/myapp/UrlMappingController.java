package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mvc")
public class UrlMappingController {
	
	@RequestMapping("/hello")
	public void m1() {
		System.out.println("/hello");
	}
	
//	@RequestMapping("/hello/ssafy")
	@RequestMapping(value = "/hello/ssafy")
	public void m2() {
		System.out.println("/hello/ssafy");
	}
	
	@RequestMapping(value = {"/url1", "url2"})
	public void m3() {
		System.out.println("/url1, /url2");
	}
	
//	@RequestMapping(value = "/method", method = RequestMethod.GET)
//	public void m4() {
//		System.out.println("/get");
//	}
	
	// post방식으로 /method 경로로 요청하면 이 메소드가 호출된다.
	// get이 없는데 get방식으로 받는 매핑 주소가 없다면 WARN : org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver - Resolved [org.springframework.web.HttpRequestMethodNotSupportedException: Request method 'GET' not supported]
	
	@RequestMapping(value = "/method", method = RequestMethod.POST)
	public void m5() {
		System.out.println("/post");
	}
	
	// put은 url 매핑에 값을 {}안에 싸서 전달할 수 있다.
	@RequestMapping(value = "/method/{num}/and/{num2}", method = RequestMethod.PUT)
	public void m6(@PathVariable int num, @PathVariable int num2) {
		System.out.println("/put");
		System.out.println("num : " + num);
		System.out.println("num2 : " + num2);
	}
	
	@RequestMapping(value = "/method/{num}", method = RequestMethod.DELETE)
	public void m8(@PathVariable int num) {
		System.out.println("/delete");
		System.out.println("num : " + num);
	}
	
	@GetMapping("/getmapping")
	public void m9() {
		System.out.println("/getmapping");
	}
	
	@PostMapping("/postmapping")
	public void m10() {
		System.out.println("/postmapping");
	}
	
	@PutMapping("/putmapping")
	public void m11() {
		System.out.println("/putmapping");
	}
	
	@DeleteMapping("/deletemapping")
	public void m12() {
		System.out.println("/deletemapping");
	}
	// "/subtest/*" *이 1개일 때!!
	// http://localhost:8080/myapp/subtest으로 보내면 못받는다.
	// http://localhost:8080/myapp/subtest/abc으로 보내면 받는다.
	// http://localhost:8080/myapp/subtest/abc/def 못받는다!!
//	@RequestMapping(value="/subtest/*")
//	public void m13() {
//		System.out.println("/subtest/*");
//		
//	}
	
	// "/subtest/**" *이 2개일 때!!
	// postman으로 보낼 때 http://localhost:8080/myapp/subtest/abc/def으로 보내도 받고
	// http://localhost:8080/myapp/subtest으로 보내도 받고
	// http://localhost:8080/myapp/subtest/abc으로 보내도 받는다.
	@RequestMapping(value="/subtest/**")
	public void m14() {
		System.out.println("/subtest/**");
		
	}
	
	
	// @RequestMapping("/mvc")을 컨트롤러 밖에 선언을 하면 
	// /mcv/aaa/** -> 여기서 mvc를 빼도 된다.
	// 대신 요청할 때 http://localhost:8080/myapp/mvc/hello 다음과 같이 /mvc를 붙여야함
	@RequestMapping(value="/aaa/**")
	public void m15() {
		System.out.println("/aaa/**");
		
	}
	
	@RequestMapping(value="/bbb/**")
	public void m16() {
		System.out.println("/bbb/**");
		
	}
	// 아래 계속 반복...
	
	
}
