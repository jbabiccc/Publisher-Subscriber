package model;

import java.io.Serializable;

public class Subscriber implements Serializable
{
   private String username;

   public Subscriber(String username)
   {
      this.username = username;
   }

   public String getUsername()
   {
      return username;
   }

   public void setUsername(String username)
   {
      this.username = username;
   }

  
   
   
   
}
