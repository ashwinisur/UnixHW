package HW02;
import java.util.*;

public class StepControl_linearSearch {
    public double k;
    public int[] a;
   
    StepControl_linearSearch() {
        initializeNumbers();
       }
       public int getSearchType()
       {
           return 1;//return 1
       }
      
       public int[] getArray()
       {          
           return a;
       }
      
       public int getLow()
       {
           return 0;// not useful for linear search just return 0
       }
       public int getHigh()
       {
           return 0;// not useful for linear search just return 0
       }
       public void setKey(double key)
       {
           k = key;
       }
       public void initializeNumbers()
       {
           /*Random r = new Random();
           for (int i = 0; i < 20; i ++)
           {
               a[i] = r.nextInt(19)+1;
           }*/
       }
       public int getCurrentIndex()
       {
           int num = 0;
           for(int i = 0; i <20; i++)
           {
               if(a[i] == k)
                   num = i;
           }
          
           return num;
       }
       public void reset()
       {
           Random r = new Random();
           for (int i = 0; i < 20; i ++)
           {
               a[i] = r.nextInt(19) +1;
           }
       }
      
       public int step()
       {
           int ind = getCurrentIndex();
           if(k == a[ind+1])
               return 1;
           else
           {
               if(ind+1 == 19)
                   return -1;
               return 0;
           }
       }

}


