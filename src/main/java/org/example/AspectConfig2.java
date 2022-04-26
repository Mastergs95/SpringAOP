package org.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.example.aopadvices.Order;
import org.example.pointcuts.AspectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
@Aspect
public class AspectConfig2 {

    private static final Logger log = LogManager.getLogger(AspectConfig.class);

    private Order getOrder(){
        ApplicationContext context = AppContextWrapper.getContext();

        return (Order) context.getBean("orderBean");
    }

    @Around("execution(* org.example.aopadvices.Order.displayOrderItems())")
    public void printLogo(ProceedingJoinPoint pjp) throws Throwable{

        log.info("Logo printed before invocation of: " + pjp.getSignature().getName());

        System.out.println("\n\nLogo printed before invocation of: " + pjp.getSignature().getName());

        System.out.println("\n**********************************\n" +
                            "************ Q E N E L *********\n" +
                            "**********************************");

        Order order = getOrder();
        pjp.proceed();

        System.out.println("\nThe number of items in your order: " + order.getOrderItems().size());

    }

//    @After("execution(* org.example.aopadvices.Order.displayOrderItems())")
//    public void printOrderValue(){
//
//        Order order = getOrder();
//        System.out.println("\n=============================");
//        System.out.println("Order Total: $" + order.getOrderValue());
//        System.out.println("=============================");
//    }

    @AfterThrowing(pointcut = "execution(* org.example.aopadvices.Order.*(..))", throwing = "ex")
    public void logException(JoinPoint jp, Throwable ex){

        log.error("An exception has been throw when running " + jp.getSignature());
        log.error("Exception message: " + ex.getMessage() + "\n\n");
    }

    @AfterReturning(pointcut = "execution(* org.example.aopadvices.Order.displayOrderItems())")
    public void applyDiscount(){

        Order order = getOrder();

        System.out.println("\n===================================");
        System.out.println("Order value: $" +order.getOrderValue());
        System.out.println("===================================\n");

        log.info("Order total calculated and displayed as " + order.getOrderValue());

        if(order.getOrderValue()>25){

            System.out.println("\n++++++++++++++++++++++++++");
            System.out.println("Congratulations! You qualify for a discount!");
            System.out.println("Discounted Total: " + (0.9 * order.getOrderValue()));
            System.out.println("\n++++++++++++++++++++++++++");

            log.info("Discounted total calculated and displayed as " + (0.9 * order.getOrderValue()));
        }
    }
}
