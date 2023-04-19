package com.mycom.myapp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.myapp.dto.EmpDto;

@Controller
public class JsonController {
	// 요청을 받는 녀석들
	@PostMapping(value = "/emp") // Dto는 json으로 넘어오기 때문에 RequestBody를 붙여줘야 한다.
	public void m1(@RequestBody EmpDto dto) {
		System.out.println(dto);
	}

	@PostMapping(value = "/empList") // Dto는 json으로 넘어오기 때문에 RequestBody를 붙여줘야 한다.
	public void m2(@RequestBody List<EmpDto> list) {
		for (EmpDto empDto : list) {
			System.out.println(empDto);
		}
	}

	@GetMapping(value = "/empDetail/{employeeId}") // Dto는 json으로 넘어오기 때문에 RequestBody를 붙여줘야 한다.
	@ResponseBody // 프론트로 json으로 보내고 싶을 때 붙여주는 annotation 없으면 프론트에서 못받는다
	public EmpDto m3(@PathVariable int employeeId) {
		System.out.println("employeeId: " + employeeId);
		EmpDto dto = new EmpDto(2000, "승우", "이", "lee@palyer.com", "1999-04-04");
		return dto;
	}

	@GetMapping(value = "/empList") // Dto는 json으로 넘어오기 때문에 RequestBody를 붙여줘야 한다.
	@ResponseBody // 프론트로 json으로 보내고 싶을 때 붙여주는 annotation 없으면 프론트에서 못받는다
	public List<EmpDto> m4() {
		List<EmpDto> list = new ArrayList<EmpDto>();

		list.add(new EmpDto(1600, "찬호", "박", "park@hero.com", "1980-05-05"));
		list.add(new EmpDto(1601, "범근", "차", "park@hero.com", "1980-05-05"));
		list.add(new EmpDto(1602, "강인", "이", "park@hero.com", "1980-05-05"));
		
		return list;
	}
	
	@GetMapping(value = "/LocalDateTime") // Dto는 json으로 넘어오기 때문에 RequestBody를 붙여줘야 한다.
	@ResponseBody // 프론트로 json으로 보내고 싶을 때 붙여주는 annotation 없으면 프론트에서 못받는다
	public LocalDateTime m5() {
				
		return LocalDateTime.now();
	}
	
	// gson으로 날짜 보낼 때 console에 출력되는 값 -> {year: 2023, month: 4, day: 19}, time: {hour: 15, minute: 46, second: 1, nano: 36000000}
	// jackson으로 날짜 보낼 때 console에 출력되는 값 -> {"year":2023,"month":"APRIL","dayOfMonth":19,"dayOfWeek":"WEDNESDAY","dayOfYear":109,"monthValue":4,"hour":15,"minute":49,"second":55,"nano":950000000,"chronology":{"id":"ISO","calendarType":"iso8601"}}
	
}
