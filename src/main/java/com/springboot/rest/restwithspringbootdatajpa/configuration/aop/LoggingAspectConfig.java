package com.springboot.rest.restwithspringbootdatajpa.configuration.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
@Slf4j
public class LoggingAspectConfig {

	/*@Before(value = "execution(* com.springboot.rest.restwithspringbootdatajpa..*.*(..))")
	public void beforeAdvice (JoinPoint joinPoint) {
		log.info("Inside Before Advice");
	}*/
	
	/*@Before(value = "execution(* com.springboot.rest.restwithspringbootdatajpa..*.*(..)) && args(object)")
	public void beforeAdvice (JoinPoint joinPoint, Object object) {
		log.info("Request = " + object);
	}*/
	
	/*@After(value = "execution(* com.springboot.rest.restwithspringbootdatajpa..*.*(..)) && args(object)")
	public void beforeAdvice (JoinPoint joinPoint, Object object) {
		log.info("Request = " + object);
	}*/
	
	/*@AfterReturning(value = "execution(* com.springboot.rest.restwithspringbootdatajpa..*.*(..)) && args(object)",
			returning = "returningObject")
	public void beforeAdvice (JoinPoint joinPoint, Object object, Object returningObject) {
		log.info("Response = " + returningObject);
	}*/

    @Around(value = "execution(* com.springboot.rest.restwithspringbootdatajpa..*.*(..)) && args(object)")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint, Object object) {
        log.info("Request = " + object);

        Object returningObject = null;
        try {
            returningObject = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        log.info("Response = " + returningObject);
    }
}
