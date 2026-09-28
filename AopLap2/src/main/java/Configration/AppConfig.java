//package Configration;
//
//import com.*;
//import org.springframework.aop.framework.ProxyFactory;
//import org.springframework.aop.framework.ProxyFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AppConfig {
//@Bean
//    public  InventoryServiceImpl inventoryService(){
//    return new InventoryServiceImpl();
//    }
//    @Bean
//    public AfterReturningAdviceDemo afterReturningAdviceDemo (){
//    return new AfterReturningAdviceDemo();
//    }
//    @Bean
//    public MethodBeforeAdvicedemo methodBeforeAdvicedemo (){
//    return new MethodBeforeAdvicedemo();
//    }
//    @Bean
//    public MethodInterceptorDemo methodInterceptorDemo() {
//    return new MethodInterceptorDemo();
//    }
//    @Bean
//    public ThrowsAdviceDemo throwsAdviceDemo () {
//        return new ThrowsAdviceDemo();
//    }
//    @Bean
//            public ProxyFactoryBean inventoryServiceProxy(){
//            ProxyFactoryBean factory = new ProxyFactoryBean();
//            factory.setTarget(inventoryService());
//            factory.setInterceptorNames("afterReturningAdviceDemo");
////            factory.setInterceptorNames("methodBeforeAdvicedemo");
////            factory.setInterceptorNames("methodInterceptorDemo");
////            factory.setInterceptorNames("throwsAdviceDemo");
//
//           return factory;
//           }
//
//}
//throwsAdviceDemo