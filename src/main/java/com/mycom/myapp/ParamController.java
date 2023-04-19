package com.mycom.myapp;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycom.myapp.dto.CarDto;

@Controller
public class ParamController {
	
	// no return => 404가 나온다
	
	@GetMapping("/param1") // 파라미터로 seq=111이런식으로 넘어올 것이다라고 가정
	public void m1(HttpServletRequest request) {
		String seq = request.getParameter("seq");
		System.out.println("/param1 seq : " + seq);
	}
	
	@GetMapping("/param2") // 파라미터로 seq=111이런식으로 넘어올 것이다라고 가정
	public void m2(String seq) {
		System.out.println("/param2 seq : " + seq);
	}
	
	@GetMapping("/param3") // 파라미터로 seq=111이런식으로 넘어올 것이다라고 가정
	public void m3(int seq) {
		System.out.println("/param3 seq : " + seq);
	}
	
	@GetMapping("/param4") // 파라미터로 seq=111이런식으로 넘어올 것이다라고 가정
	public void m4(Integer seq) {
		System.out.println("/param4 seq : " + seq);
	}
	
	// 되도록이면 Dto를 사용하자, 그래야지 파라미터가 넘어오지 않아도 문제가 발생하지 않는다.
	
	@GetMapping("/param5") // 파라미터로 se1=111이런식으로 넘어올 것이다라고 가정
	// 이름이 달라도 쓸 수 있다.
	public void m5(@RequestParam(name = "seq", required=true) String str) {
		System.out.println("/param5 str : " + str);
	}
	
	@GetMapping("/car1") 
	public void m6(String name, int price, String owner) {
		System.out.println("/car1 name : " + name);
		System.out.println("/car1 price : " + price);
		System.out.println("/car1 owmer : " + owner);
		
	}
	
	// 파라미터를 Dto 객체로 선언을 하면 멤버변수가 primitive 타입인데도 불구하고 값이 안들어오면 0으로 만들어 준다.
	// Dto에 다 담기는 이유는 알아서 setter가 호출되기 때문이다.
	@GetMapping("/car2") 
	public void m6(CarDto carDto) {
		System.out.println(carDto);
	}
	
	@GetMapping("/car3")
	// 네이밍을 잘 맞춰주는 것이 중요하다.(네임을 맞춰주면 자동으로 해주는 부분이 많음)
	public void m7(CarDto carDto) {
		System.out.println(carDto);
	}
	
	@GetMapping("/map") // map <= RequestParam이 필요하다.
	public void m8(@RequestParam Map<String, String> params) {
		System.out.println(params.get("name"));
		System.out.println(params.get("price"));
		System.out.println(params.get("owner"));
	}
	
	@GetMapping("/header") // 헤더 정보를 얻어오는 것
	public void m9(@RequestHeader(value = "Accept") String accept,
					@RequestHeader(value = "Host") String host
					) {
		System.out.println(accept);
		System.out.println(host);
	}
	
	@GetMapping("/session") // 파라미터로 seq=111이런식으로 넘어올 것이다라고 가정
	public String m10(HttpSession session, String msg) {
		System.out.println(msg);
		session.setAttribute("msg", msg);
		
		return "sessionTest";
	}
}
