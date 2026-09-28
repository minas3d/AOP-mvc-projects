package com.Interfaces;

public interface test {
    public  void print (String msg );
//    import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//
//    public class DynamicProxyExample {
//
//
//        public static void main(String[] args) {
//
//            // The InvocationHandler receives every method call
//            InvocationHandler handler = new InvocationHandler() {
//
//                @Override
//                public Object invoke(
//                        Object proxy,
//                        Method method,
//                        Object[] args) {
//
//                    System.out.println("Method called: " + method.getName());
//
//                    if (method.getName().equals("pay")) {
//                        System.out.println("Processing payment: " + args[0]);
//                    }
//
//                    if (method.getName().equals("log")) {
//                        System.out.println("LOG: " + args[0]);
//                    }
//
//                    return null;
//                }
//            };
//
//            // Create ONE proxy implementing TWO interfaces
//            Object proxy = Proxy.newProxyInstance(
//
//                    // ClassLoader
//                    PaymentService.class.getClassLoader(),
//
//                    // Interfaces implemented by the generated proxy
//                    new Class<?>[]{
//                            PaymentService.class,
//                            LoggingService.class
//                    },
//
//                    // InvocationHandler
//                    handler
//            );
//
//            // The same object can be viewed as either interface
//            PaymentService paymentService =
//                    (PaymentService) proxy;
//
//            LoggingService loggingService =
//                    (LoggingService) proxy;
//
//            // Call PaymentService method
//            paymentService.pay("100 EGP");
//
//            // Call LoggingService method
//            loggingService.log("Payment completed");
//        }
   // }
}
