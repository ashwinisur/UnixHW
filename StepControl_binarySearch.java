package HW02;
import java.util.*;

public class StepControl_binarySearch {
    public double k;
    public int[] a;
    public int index;
    public int low,high;
   
    StepControl_binarySearch() {
        initializeNumbers();
       }       
       
       public int getSearchType()
       {
           return 0;// return 0 for binary search
       }
       public int[] getArray()
       {
         return a; 
       }
       public void setKey(double key)
       {
           k = key;
       }
       public void initializeNumbers()
       {          
           for (int i = 0; i < 20; i ++)
           {
               a[i] = i+1;
           }
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
           for (int i = 0; i < 20; i ++)
           {
               a[i] = i+1;
           }
       }
       public int getLow()
       {
          low=0;
          int mid = 0;
          high=0;
            while(low<=high)
            {
                mid=(low+high)/2;
                if(a[mid]>k)
                    high=mid-1;
                else if(a[mid]<k)
                    low=mid+1;
             }
             return low;        
       }
      
       public int getHigh()
       {
           low=0;
              int mid = 0;
              high=0;
                while(low<=high)
                {
                    mid=(low+high)/2;
                    if(a[mid]>k)
                        high=mid-1;
                    else if(a[mid]<k)
                        low=mid+1;
                 }
                 return high; 
       }
       public int step()
       {
    	   low=0;
           int mid = 0;
           high=0;
             while(low<=high)
             {
                 mid=(low+high)/2;
                 if(a[mid]>k )
                 {
                     high=mid-1;
                     if(high == 19)
                    	 return -1;
                 }
                 else if(a[mid]<k)
                     low=mid+1;
                 else
                	 return 1;
                 
              }return 0;
             
       }
}