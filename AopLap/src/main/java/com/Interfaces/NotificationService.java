package com.Interfaces;

public interface NotificationService {

   void   sendEmail(String to, String message);
  public void sendSms(String to, String message);
}
