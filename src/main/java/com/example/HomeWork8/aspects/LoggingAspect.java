package com.example.HomeWork8.aspects;

import com.example.HomeWork8.model.Task;
import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

@Aspect
@Log
public class LoggingAspect {

    @Around(value = "@annotation(TrackUserAction)")
    public ResponseEntity<Task> logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        ResponseEntity<Task> response = (ResponseEntity<Task>) joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        log.info("LoggingAspect\nВызван метод: " + joinPoint.getSignature().getName() +
                "\nПередаваемые параметры: " + Arrays.toString(joinPoint.getArgs()) +
                "\nВозвращаемые параметры: " + response.getStatusCode() + response.getBody() +
                "\nВремя обработки запроса: " + executionTime);
        return response;
    }

}
