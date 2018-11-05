package model;

import java.util.ArrayList;

public class SubscriberList
{
   private ArrayList<Subscriber> subscribers;

   public SubscriberList()
   {
      this.subscribers = new ArrayList<>();
   }
   
   public boolean addSubsriber(Subscriber sub)
   {
      if(subscribers.add(sub))
      {
         return true;
      }
      
      else 
         return false;
   }
   
   
   public Subscriber getLastestSubscriber()
   {
      return subscribers.get(subscribers.size()-1);
   }
   
   
   public Subscriber [] getSubscribersList()
   {
      Subscriber [] newsub = new Subscriber[subscribers.size()];
      
      newsub = subscribers.toArray(newsub);
      
      return newsub;
      
   }
   
   public boolean checkSubscriberOnList(Subscriber s)
   {
      for(Subscriber sub : subscribers)
      {
         
         if(sub.getUsername().equals(s.getUsername()))
         {
            return true;
         }
         
      }
      
      return false;
      
   }
}
