package ct.ct360task.logging;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

    Logger logger = LoggerFactory.getLogger(LoggingAdvice.class); // this.
    // ct/ct360task/controller/MainResource.java
    // ill just specify logger to be available everywhere
    @Pointcut(value="execution(* ct.ct360task.*.*.*(..) )")
    public void loggerPointCut(){

    }

    @Around("loggerPointCut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        //basic, which method is calling from which class
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        //which inputs/parameters are coming in
        Object[] array = pjp.getArgs();
        //convert array to more readable format
        ObjectMapper mapper = new ObjectMapper();

        //output template, before execution information
        logger.info("Method " + methodName +
                "() invoked from class " + className +
                "arguments: " + mapper.writeValueAsString(array));

        //after execution information
        Object object = pjp.proceed();

        logger.info(className + " : " + methodName + "()" +
                " Response: " + mapper.writeValueAsString(object));

        return object;
    }
}
