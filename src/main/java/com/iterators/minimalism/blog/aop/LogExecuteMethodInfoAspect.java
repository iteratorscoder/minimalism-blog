package com.iterators.minimalism.blog.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * AOP 统计service包下的每个方法的执行信息，包括方法参数，返回值，执行时间
 * 不需要对service包下的方法做任何的修改，利用切面可以完成方法执行信息的统计，所以AOP称为对源代码是无侵入的
 * @author iterators
 * @time 2020.06.06
 */
@Aspect
@Slf4j
@Component
public class LogExecuteMethodInfoAspect {

    /**
     * "* com.iterators.minimalism.blog..service.*.*(..)" 表示对com.iterators.minimalism.blog及其子包下的service包下的所有类的所有方法（方法具有任意参数）进行拦截
     * 第一个 * 表示对任意的返回值
     * com.iterators.minimalism.blog 表示要拦截的包名
     * 两个点 ..service 表示 当前包及其子包
     * 第一个 .* 表示类名，* 表示对包下所有的类
     * 第二个 .* 表示方法，* 表示对所有的方法
     * 最后的 (..) 表示参数，..表示对任意参数
     *
     * "* com.iterators.minimalism.blog.service.*.*(..)" 表示对com.iterators.minimalism.blog.service包下的所有类的所有方法进行拦截
     */
    @Pointcut(value = "execution(* com.iterators.minimalism.blog.service.*.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        // 方法参数
        Object[] args = joinPoint.getArgs();
        String kind = joinPoint.getKind();
        String targetName = joinPoint.toString();
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            log.info("exception: {}", throwable.toString());
        } finally {
            log.info("type={}, {} with time {}ms, args={}",
                    kind, targetName, System.currentTimeMillis() - startTime, Arrays.toString(args));
        }
        return null;
    }

    @AfterReturning(value = "pointcut()", returning = "returnObject")
    public void afterReturning(JoinPoint joinPoint, Object returnObject) {
        log.info("type={}, {} with return values={}", joinPoint.getKind(), joinPoint.toString(), returnObject.toString());
    }

    @AfterThrowing(value = "pointcut()", throwing = "throwableObject")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwableObject) {
        log.info("type={}, {} with throwable values={}", joinPoint.getKind(), joinPoint.toString(), throwableObject.toString());
    }
}
