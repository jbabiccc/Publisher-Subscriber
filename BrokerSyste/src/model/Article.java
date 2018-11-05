package model;

import java.io.Serializable;

public class Article implements Serializable
{
   private String title;
   private String body;
   private String category;
   
   
   public Article(String title, String body, String category)
   {
      this.title = title;
      this.body = body;
      this.category = category;
   }


   public String getTitle()
   {
      return title;
   }


   public String getBody()
   {
      return body;
   }


   public String getCategory()
   {
      return category;
   }


   public void setTitle(String title)
   {
      this.title = title;
   }


   public void setBody(String body)
   {
      this.body = body;
   }


   public void setCategory(String category)
   {
      this.category = category;
   }
   
   
}
