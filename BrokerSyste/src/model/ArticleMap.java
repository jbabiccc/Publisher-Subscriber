package model;

import java.util.HashMap;


public class ArticleMap
{
   
   HashMap<String, SubscriberList> map = new HashMap<>();
   
   
   
   //get list of people who are signed on specific category
   public SubscriberList getListOfPeople(String category)
   {
       return map.get(category);
   }
   
  public Subscriber addSubscriberToList(Subscriber sub, String category)
  {
     if(map.containsKey(category)) {
        // gea
        SubscriberList subList = map.get(category);
              subList.addSubsriber(sub);
        
     }
     else {
        SubscriberList subList = new SubscriberList();
        subList.addSubsriber(sub);
        //add a list which containes a new sub
        map.put(category, subList);
     }
     //return sub list of specific category 
     //getting last subscriber is to check if i am added on a list of subscribers
     return map.get(category).getLastestSubscriber();
  }
  
  
   
}
