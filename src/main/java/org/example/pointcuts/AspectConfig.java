package org.example.pointcuts;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;
@Aspect
public class AspectConfig {

//    @Pointcut("execution(void org.example.pointcuts.*.*())")
//    private void myPointcutMethod(){}

//    @Pointcut("execution(* *.print*(..))")
//    private void printPointcut(){}
//
//    @Pointcut("execution(* *.display*(..))")
//    private void displayPointcut(){}
//
//    @Pointcut("execution(* *.get*(..))")
//    private void getterPointcut(){}
//
//    @Pointcut("within(org.example.pointcuts.ItemList)")
//    private void itemListAllMethodsPointcut(){}
//
//    @Pointcut("printPointcut() || displayPointcut()")
//    private void printOrDisplayMethodsPointcut(){}
//
//    @Pointcut("printPointcut() && itemListAllMethodsPointcut()")
//    private void printMethodsFromItemListPointcut(){}
//
//    @Pointcut("!(printOrDisplayMethodsPointcut() || getterPointcut())")
//    private void doesNotPublicOrGet(){}

    @Pointcut("@annotation(org.example.pointcuts.DetailPublisher)")
    private void detailPublisherPointcut(){}


    @Before("detailPublisherPointcut()")
    public void printLogo(JoinPoint jp){

        System.out.println("\n\nLogo printed before invocation of: " + jp.getSignature().getName());

        System.out.println("\n**********************************\n" +
                           "************ Q E N E L *********\n" +
                           "**********************************");
    }


//    @Before("printMethodsFromItemListPointcut()")
//    public void printFromItemList(JoinPoint jp){
//
//        System.out.println("\n########## Printing from ItemList ##########");
//        System.out.println("Print method called from ItemList: "
//                             + jp.getSignature().getName() + "\n");
//    }
//
//    @Before("doesNotPublicOrGet()")
//    public void doesNotPublicOrGetAdvice(JoinPoint jp){
//
//        System.out.println("A method which does not publish to the console " +
//                "or retrieve data has been called");
//    }

//    @Before("myPointcutMethod()")
//    public void printLogo(JoinPoint jp){
//        System.out.println("\n\nLogo printed before invocation: " + jp.getSignature().getName());
//        System.out.println("\n**********************************\n" +
//                            "************ Q E N E L *********\n" +
//                            "**********************************");
//    }
//
//    @Before("addPointcut()")
//    public void addMessage(JoinPoint jp){
//
//        System.out.println("########### ADD ##########");
//        System.out.println("Performing an add operation by invoking " + jp.getSignature().getName());
//        System.out.println("Arguments supplied: " + Arrays.toString(jp.getArgs())+"\n");
//    }
//
//    @Before("itemListAllMethodsPointcut()")
//    public void itemListAccessMessage(JoinPoint jp){
//
//        System.out.println("\n<<<<<<<<<<<<<< Item List accessed >>>>>>>>>>>>>>");
//        System.out.println("Method accessed: " + jp.getSignature().getName() + "\n");
//    }
//
//    @Before("anyMethodPointcut()")
//    public void anyMethodCalledMessage(JoinPoint jp){
//
//        System.out.println("\n$$$$$$$$$$ Method accessed $$$$$$$$$$");
//        System.out.println("Method accessed: " + jp.getSignature().getName() + "\n");
//    }
}
