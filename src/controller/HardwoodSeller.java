/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.*;
import java.io.*;
/**
 * 
 */


/**
 * @author Esteban
 *
 */
public class HardwoodSeller {

	/**
	 * @param args
	 */
	
	int size = 0;// size of array of WoodItem
	
	WoodItem w[];
	String amount; // BF purchased
	int flag = 0; // for checking if the BF is valid.
	
	public static void main(String[] args) {
	
        HardwoodSeller hs = new HardwoodSeller();
        double totalprice = 0.0;
        hs.readInputFile("info.txt");
        
        if(hs.flag==1){
        	System.out.println();
        	System.out.println("**********ERROR**********");
        	System.out.println("Enter Valid BF from 0 upto 1000 and try again");
        }
        
        if(hs.flag==0){
        
        System.out.println("List of ordered wood:");
        System.out.println();
        
        for(int i=0;i<hs.w.length;i++){
        	
        	
        	System.out.println("Wood Type:"+" "+hs.w[i].getType());
        	System.out.println("BF purchased:"+" "+hs.w[i].getAmount());
        	System.out.println("Price:"+" "+hs.w[i].getPrice());
        	System.out.println();
        	totalprice = totalprice + hs.w[i].getPrice();
        	
        	
        }
        
        
        
        System.out.println("Estimated Delivery time:"+" "+hs.deliveryTime());
        System.out.println("Total price of the purchase is:"+" "+totalprice);
        
        
        }

	}
	
	public void readInputFile(String inputFilePath){
            
            try{
            
            
            FileInputStream fis = new FileInputStream(inputFilePath);
	
            InputStreamReader is = new InputStreamReader(fis);
            
            BufferedReader br = new BufferedReader(is);
            
            String x1 = br.readLine();
            
            int i1 = x1.indexOf(';');
            
            String name = x1.substring(0,i1);
            
            System.out.println("Name of the buyer:"+" "+name);
            
           String x2 = x1.substring(i1 + 1);
            
            int i2 = x2.indexOf(';');
            
            String address = x2.substring(0, i2);
            
            System.out.println("Address of delivery:"+" "+address);

            String date = x2.substring(i2+1);

            System.out.println("Date of order:"+" "+date);
            
            
            String x3 = br.readLine();
            
            String s1 = x3;
            
           
            int a1 = x3.lastIndexOf(';');
            
           
           //Finds out the size of array of WoodItem. 
            while(s1.lastIndexOf(';')>0){
            	
            	int y = s1.indexOf(';');
            	s1 = s1.substring(y+1);
            	
            	
            	if(s1.lastIndexOf(';')<0){
            		
            		size++;
            		break;
            		}
            	
            	size++;
            }
            
            size++;
            
            
            w = new WoodItem[size];
            WoodItem wi;
            double baseDeliveryTime = 0.0;
            double price = 0.0;
            int counter = 0;
            s1 = x3;
            
            while(s1.lastIndexOf(';')>0){
            	
            	int y = s1.indexOf(';');
            	int z = s1.indexOf(':');
            	
            	String woodtype = s1.substring(0,y).substring(0,z);
            	
            	
                amount = s1.substring(0,y).substring(z+1);
            	
                
                if(Double.parseDouble(amount)>=0 && Double.parseDouble(amount)<=1000){
                	
                	
                	flag =0;
                }
                else{
                	flag = 1;
                	break;
                }
            	
            	if(woodtype.equals("Cherry")){
            		baseDeliveryTime = 2.5;
            		price = Double.parseDouble(amount)*5.95;
            	}
            	
            	if(woodtype.equals("Curly Maple")){
            		baseDeliveryTime = 1.5;
            		price = Double.parseDouble(amount)*6.00;
            	}
            	
            	if(woodtype.equals("Genuine Mahogany")){
            		baseDeliveryTime = 3;
            		price = Double.parseDouble(amount)*9.60;
            	}
            	
            	if(woodtype.equals("Wenge")){
            		baseDeliveryTime = 5;
            		price = Double.parseDouble(amount)*22.35;
            	}
            	
            	if(woodtype.equals("white")){
            		baseDeliveryTime = 2.3;
            		price = Double.parseDouble(amount)*6.70;
            	}
            	
            	if(woodtype.equals("Sawdust")){
            		baseDeliveryTime = 1;
            		price = Double.parseDouble(amount)*1.5;
            	}
            	
            	wi = new WoodItem(woodtype,baseDeliveryTime,price,Double.parseDouble(amount));
            	
            	w[counter] = wi;
            	
            	counter++;
            	
            	s1 = s1.substring(y+1);
            	
            	if(s1.lastIndexOf(';')<0){
            		
            		z = s1.indexOf(':');
            		
            		woodtype = s1.substring(0,z);
            		
            		
            		amount = s1.substring(z+1);
            		
            		
            		if(Double.parseDouble(amount)>=0 && Double.parseDouble(amount)<=1000){
                    	
                    	
                    	flag =0;
                    }
                    else{
                    	flag = 1;
                    	break;
                    }
            		
            		if(woodtype.equals("Cherry")){
                		baseDeliveryTime = 2.5;
                		price = Double.parseDouble(amount)*5.95;
                	}
                	
                	if(woodtype.equals("Curly Maple")){
                		baseDeliveryTime = 1.5;
                		price = Double.parseDouble(amount)*6.00;
                	}
                	
                	if(woodtype.equals("Genuine Mahogany")){
                		baseDeliveryTime = 3;
                		price = Double.parseDouble(amount)*9.60;
                	}
                	
                	if(woodtype.equals("Wenge")){
                		baseDeliveryTime = 5;
                		price = Double.parseDouble(amount)*22.35;
                	}
                	
                	if(woodtype.equals("White Oak")){
                		baseDeliveryTime = 2.3;
                		price = Double.parseDouble(amount)*6.70;
                	}
                	
                	if(woodtype.equals("Sawdust")){
                		baseDeliveryTime = 1;
                		price = Double.parseDouble(amount)*1.5;
                	}
            		
            		wi = new WoodItem(woodtype,baseDeliveryTime,price,Double.parseDouble(amount));
                	w[counter] = wi;
            		
            		
            		
            	}
            	
            	
            	
            	
            }
            
	
            }
            catch(Exception e){
               System.out.println(e);
            }
		
	}
	
	public Double deliveryTime(){
		
	
		double dtimes[] = new double[size];
		double j = 0;
		
		for(int i=0;i<size;i++){
			
			if(w[i].getAmount()>=1 && w[i].getAmount()<=100){
				
				j = 1;
			}
			
             if(w[i].getAmount()>=101 && w[i].getAmount()<=200){
				
				j = 2;
	        }
			
             if(w[i].getAmount()>=201 && w[i].getAmount()<=300){
            	 
            	 
            	j = 3;
             }
			
             if(w[i].getAmount()>=301 && w[i].getAmount()<=400){
            	 
            	 j = 4;
             }
			
             if(w[i].getAmount()>=401 && w[i].getAmount()<=500){
            	 
            	 
            	 j = 5;
            	 
             }
             
             
             if(w[i].getAmount()>=501 && w[i].getAmount()<=1000){
            	 
            	 
            	 j = 5.5;
             }
             
             
			dtimes[i] = w[i].getBaseDeliveryTime()*j;
			
			
			
		}
		
		//Calculating max value in dtimes array.
		
		
		double max = 0.0;
		double temp;
		for(int i=0;i<dtimes.length;i++){
			
			for(int k=i+1;k<dtimes.length;k++){
				
				if(dtimes[i]<dtimes[k]){
					
					temp = dtimes[i];
					dtimes[i] = dtimes[k];
					dtimes[k] = temp;
				}
				
			}
			
			
			
			
		}
		
		
		Double deliveryETA = dtimes[0];
		return deliveryETA;
	}
	
}


