package com.Clases;

import com.Interfaces.NotificationService;

public class NotificationServiceImpl implements NotificationService {
@Override
public void   sendEmail(String to, String message)
{
   System.out.println("heloo" + to + " " + message+"  in send Email " );
}

   @Override
   public void sendSms(String to, String message)
   {
      //System.out.println("heloo  " + to + "" + message+" in send Sms " );

   }
}
