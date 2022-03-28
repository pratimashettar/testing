package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@Value("${coach.name}") 
	private String coachName;
	@Value("${team.name}")
	private String teamName;
	

	//expose "/" endpoint
	@GetMapping("/")
	public String sayhello()
	{
		return "Hello World!! the time on the server is :" +LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout()
	{
		return "Run 5k-devtool worked";
	}
	
	@GetMapping("/fortune")
	public String getDailyFortune()
	{
		return "Today is your lucky day!!!";
	}
	
	@GetMapping("/teaminfo")
	public String getTeamName()
	{
		return "Coach: "+coachName + " Team: " +teamName;
	}
}


