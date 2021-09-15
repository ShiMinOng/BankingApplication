package com.softra.bankingapplication.models;

import java.time.Duration;
import java.time.LocalTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	public static LocalTime startTime;
	public static LocalTime endTime;
	 
	@AfterReturning(value = "execution(* UserServiceInterface.findByUsernameAndPassword(..))", returning="r") //implicitly referring to value (since only 1 attribute)
	public void afterLoggedIn(JoinPoint jp, Object r) {
		startTime = LocalTime.now();
	}
	
	@AfterReturning(value = "execution(* UserServiceInterface.logout())", returning="r")
	public void afterLoggedOut(JoinPoint jp, Object r) {
		endTime = LocalTime.now();
		Duration duration = Duration.between(startTime, endTime);
		System.out.println("Inside Banking application for a duration of " + duration.getSeconds() + " seconds");
	}
}