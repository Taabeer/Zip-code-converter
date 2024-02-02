import java.util.Scanner;

public class Zipcode 
{
	private int zipcode;
	private String barcode;
	public Zipcode(int z) 
	{
		zipcode=z;
	}
	public Zipcode(String b) 
	{
		barcode=b;
	}
	public String getZIPcode() 
	{
		while (isValidCheckDigit(barcode)==false) 
		{
			Scanner input= new Scanner (System.in);
			System.out.println("That was an invalid checkdigit. Please re-enter the barcode with a valid checkdigit");
			this.barcode= input.nextLine();
		}
		String modBarcode= barcode.substring(1, barcode.length() - 1);
		String bBarcode[]= new String [6];
		int counter=0;
		for (int i=0;i<6;i++) 
		{
			bBarcode[i]=modBarcode.substring(counter, counter+5);
			counter=counter+5;
		}
		int zipCodevalues[]= new int [5];
		String[] barCodeDigits= {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
		for (int i=0;i<5;i++) 
		{
			for (int x=0;x<10;x++) 
			{
				if (bBarcode[i].equals(barCodeDigits[x])) 
				{
					zipCodevalues[i]= x;
				}
			}
		}
		String ZIPcode= arrayToString(zipCodevalues);
		return ZIPcode;
	}
	public String getBarcode() 
	{
		String[] barCodeDigits= {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
		char[] zipCodeArray = String.valueOf(zipcode).toCharArray();
		int checkDigit=createCheckDigit();
		String[] tempBarcode=new String [8];
		tempBarcode[0]="|";
		tempBarcode[7]="|";
		tempBarcode[6]= barCodeDigits[checkDigit];
		int counter=0;
		for (int i=1;i<6;i++) 
		{
			tempBarcode[i]= barCodeDigits[Character.getNumericValue(zipCodeArray[counter])];
			counter++;
		}
		String convBarcode = arrayToString(tempBarcode);
		return convBarcode;
	}
	public int createCheckDigit() 
	{
		char[] zipCodeArray = String.valueOf(zipcode).toCharArray();
		int zipSum=0;
		int checkDigit=0;
		//add up all the values in the zip code
		for (int i=0; i<zipCodeArray.length;i++) 
		{
			zipSum= zipSum+Character.getNumericValue(zipCodeArray[i]);
		}
		if (zipSum%10!=0) 
		{
			//rounds to the nearest 10th
			int round= Math.round(zipSum/10.0f) * 10;
			// checkdigit is the amount it takes to get to the nearest 10th
			checkDigit= round-zipSum;
		}
		return checkDigit;
	}
	public String arrayToString(String[]barCode) 
	{
		String convArray=barCode[0];
		for (int i=1; i<barCode.length;i++) 
		{
			convArray=convArray+barCode[i];
		}
		return convArray;
	}
	public String arrayToString (int[]zipCode) 
	{
		String convArray= String.valueOf(zipCode[0]);
		for (int i=1; i<zipCode.length;i++) 
		{
			convArray= convArray+String.valueOf(zipCode[i]);
		}
		return convArray;
	}
	public boolean isValidCheckDigit(String barcode) 
	{
		boolean isValid=false;
		String barcodeCheckDigit= barcode.substring(26, barcode.length() - 1);
		int numericCheckDigit=0;
		String[] barCodeDigits= {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
		for (int i=0;i<10;i++) 
		{
			if (barCodeDigits[i].equals(barcodeCheckDigit)) 
			{
				numericCheckDigit=i;
			}
		}
		String modBarcode= barcode.substring(1, barcode.length() - 1);
		String bBarcode[]= new String [6];
		int counter=0;
		for (int i=0;i<6;i++) 
		{
			bBarcode[i]=modBarcode.substring(counter, counter+5);
			counter=counter+5;
		}
		int zipCodevalues[]= new int [5];
		for (int i=0;i<5;i++) 
		{
			for (int x=0;x<10;x++) 
			{
				if (bBarcode[i].equals(barCodeDigits[x])) 
				{
					zipCodevalues[i]= x;
				}
			}
		}
		int zipSum=0;
		int verifycheckDigit=0;
		//add up all the values in the zip code
		for (int i=0; i<zipCodevalues.length;i++) 
		{
			zipSum= zipSum+zipCodevalues[i];
		}
		if (zipSum%10!=0) 
		{
			//rounds to the nearest 10th
			int round= Math.round(zipSum/10.0f) * 10;
			// checkdigit is the amount it takes to get to the nearest 10th
			verifycheckDigit= round-zipSum;
		}
		if (verifycheckDigit==numericCheckDigit) 
		{
			isValid=true;
		}
		
		return isValid;
	}
	
}
