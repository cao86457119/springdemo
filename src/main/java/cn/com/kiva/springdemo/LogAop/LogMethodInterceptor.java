package cn.com.kiva.springdemo.LogAop;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogMethodInterceptor {
//    @Around("execution(public * *(..)) && @annotation(log)")
//    public void interceptor(ProceedingJoinPoint pjp) {
//        MethodSignature ms = (MethodSignature) pjp.getSignature();
//        logger.info("run " + ms.getDeclaringTypeName() + " methodname"
//                + ms.getMethod().getName());
//        try {
//             pjp.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//
//        logger.info(" run successfully");
//
//    }

    private Logger logger = LoggerFactory.getLogger(LogMethodInterceptor.class);
    @Pointcut("execution(public * cn.com.kiva.springdemo.controller.*.*(..))||@annotation(log)")
public void webLog(){}

    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("方法的返回值 : " + ret);
    }

    //后置异常通知
    @AfterThrowing("webLog()")
    public void throwss(JoinPoint jp){
        logger.info("方法异常时执行.....");
    }

    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("webLog()")
    public void after(JoinPoint jp){
        logger.info("方法最后执行.....");
    }

    //环绕通知,环绕增强，相当于MethodInterceptor
    @Around("webLog()")
    public Object arround(ProceedingJoinPoint pjp) {
        logger.info("方法环绕start.....");
        try {
            Object o =  pjp.proceed();
            logger.info("方法环绕proceed，结果是 :" + o);
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

}
