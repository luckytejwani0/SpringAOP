package com.seed.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {							//aspect class
	
 @Pointcut("\"execution(* com.seed.service.UserService.*(..))\"")
	public void pcl() {}
	
 /*	@Before("pcl()") 
	@Before("execution(* com.seed.service.UserService.*)")	
	for above annotation advice will be applied on all methods of user service regardless of return type 
	@Before("execution(int com.seed.service.UserService.*)")	
	for above annotation advice will be applied on all methods of user service with return type int
	*/
	@Before("execution(* com.seed.service.UserService.*(..))")				//join point							
	public void beforeService() {						//this function is a advice
		System.out.println("Validation started...");
	} 
	
/*	@After("execution(* com.seed.service.UserService.*(..))")				//join point							
	public void afterService(JoinPoint jp) {						//this function is a advice
		System.out.println("Validation completed...");
		System.out.println("Signature of function : " + jp.getSignature());
	}  */
	
	/*	@AfterReturning(      // get the result in advice
			pointcut = "execution(* com.seed.service.UserService.*(..))",
			returning = "result"
			)
	public void myAdvice(Object result) {
		System.out.println("My additional concern...");
		System.out.println("Result in advice : "+ result);
		System.out.println("End of after return advice");
	} */
	
/*	@Around("execution(* com.seed.service.UserService.*(..))")
	public Object measureExectutionTime(ProceedingJoinPoint pjp) throws Throwable {
		
		//before
		System.out.println("Before add()");
		long start = System.currentTimeMillis();
		
		Object result = pjp.proceed();
		
		//after
		System.out.println("After add()");
		long end = System.currentTimeMillis();
		System.out.println("Execution time of " + pjp.getSignature() + " : " + (end-start) + "ms");
		
		return result;
	} */
	
	@AfterThrowing(pointcut="execution(* com.seed.service.UserService.*(..))",throwing = "ex")
	public void myAdvice(Exception ex) {
		System.err.println("This is the additional concern if the excetion occur");
		System.err.println("Exception is : " + ex.getMessage());
		System.err.println("End of AfterThrowing");
	}
}
