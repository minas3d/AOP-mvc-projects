package com;

import com.Clases.EmploeeImp;
import com.Interfaces.Debartment;
import com.Interfaces.Emploee;
import com.Interfaces.NotificationService;
import com.Logning.LoggingHandler;

import java.lang.reflect.Proxy;

public class Main {
    static void main() {
//1
       // ===================================================
//NotificationService notificationService = new NotificationServiceImpl();
//        NotificationService proxy = (NotificationService) Proxy.newProxyInstance(
//                NotificationService.class.getClassLoader(),
//                new Class[]{NotificationService.class},
//                new LoggingHandler(notificationService)
//        );
//
//        proxy.sendEmail(" mina" ,"what do you do ");

//2
        //====================================
//        test proxy = (test) Proxy.newProxyInstance(
//                test.class.getClassLoader(),
//                new Class[]{test.class},
//                new LoggingHandler());
//        proxy.print("mina");
        //3
        //=======================================
//لو 2 ميثود نفس الاسم في 2 انترفيس مختلف مش هيشتغل لان ال dinamic proxy يعمل كلاس كبير ي امبليمنت كل الميثود ف بيبقي في 2 ميثود ب نفس الاسم ق بياخد الاول 
    // DebartmentImp departmentImp = new DebartmentImp();
        EmploeeImp emploeeImp = new EmploeeImp();
        Object obj =Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                new Class[]{

                        NotificationService.class,
                        Debartment.class,
                        Emploee.class


                },
                new LoggingHandler(emploeeImp)
        );


//        Debartment department = (Debartment) obj;
//        department.print("mina");

        Emploee emploee = (Emploee) obj;
        emploee.print("mina");





//        Object proxy = Proxy.newProxyInstance(
//
//                // ClassLoader
//                PaymentService.class.getClassLoader(),
//
//                // Interfaces implemented by the generated proxy
//                new Class<?>[]{
//                        PaymentService.class,
//                        LoggingService.class
//                },
//
//                // InvocationHandler
//                handler
//        );
//        PaymentService paymentService =
//                (PaymentService) proxy;
//
//        LoggingService loggingService =
//                (LoggingService) proxy;
//
//        // Call PaymentService method
//        paymentService.pay("100 EGP");
//
//        // Call LoggingService method
//        loggingService.log("Payment completed");
    }



}

