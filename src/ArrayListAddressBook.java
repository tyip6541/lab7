
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * An implementation of the AddressBook interface that uses an array list to
 * store the data.
 */
public class ArrayListAddressBook implements AddressBook
{

   private ArrayList<Item> items = new ArrayList<Item>();
   private String source;
   private boolean modified;

   public void load(String sourceName)
   {
      source = sourceName;
      try
      {
         Scanner in = new Scanner(new File(source));
         items = new ArrayList<Item>();
         while (in.hasNextLine())
         {
            items.add(new Item(in.nextLine(), in.nextLine(), in.nextLine()));
         }
      }
      catch (IOException ex)
      {
         ex.printStackTrace();
         source = null;
         items = new ArrayList<Item>();
      }
   }

   public String get(String name, String key)
   {
      for (Item it : items)
      {
         if (name.equals(it.getName()) && key.equals(it.getKey()))
         {
            return it.getValue();
         }
      }
      return null;
   }

   public String put(String name, String key, String value)
   {
      modified = true;
      for (Item it : items)
      {
         if (name.equals(it.getName()) && key.equals(it.getKey()))
         {
            String oldValue = it.getValue();
            it.setValue(value);
            return oldValue;
         }
      }
      items.add(new Item(name, key, value));
      return null;
   }

   public void save()
   {
      if (!modified)
      {
         return;
      }
      try
      {
         PrintWriter out = new PrintWriter(source);
         for (Item it : items)
         {
            out.println(it.getName());
            out.println(it.getKey());
            out.println(it.getValue());
         }
         out.close();
         modified = false;
      }
      catch (Exception ex)
      {
         ex.printStackTrace();
      }
   }

   /*@Override
   public String remove(String name, String key)
   {
      throw new UnsupportedOperationException("Not supported yet.");
   }  */
   
   @Override
   public String remove(String name, String key)
   {
      boolean flag = false;
      for (int i = 0; i < items.size(); i++)
      {
          Item element = items.get(i);
          Item lastElement = items.get(items.size() - 1);
          /*if ((items.get(name, key)) == null)
          {
              throw new NoSuchElementException("Non-existent entry");
          }*/
          if (name.equals(element.getName()) && key.equals(element.getKey()))
          {
             items.remove(element);
             items.add(i, lastElement);
             flag = true;
          }
          else
          {
             throw new NoSuchElementException("Non-existent entry");
          }
      }
      if (!flag)
      {
          return null;
      }
      else
      {
          throw new NoSuchElementException();
      }
      
   }  
}
