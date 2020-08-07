package com.PrimesPackage;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //ZAMBRETI ALGORITHM

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you measured pressure");
        double P=sc.nextDouble();
        System.out.println("Enter your measured Temperature in Celcius");
        double T=sc.nextDouble();
        System.out.println("Altitude in meters");;
        double h = sc.nextDouble();

        double Pf = P*(1-((0.0065*h)/(T+0.0065*h+273.15)));

        double Pfinal=Math.pow(Pf,-5.27);  //atmospheric pressure reduced to sea level
        double Z=0.0;
        if(Pfinal>P)
        {
            System.out.println("Pressure is rising");
            Z=179-((2*Pfinal)/129);
        }
        else if(Pfinal<P)
        {
            System.out.println("Pressure is falling");
            Z=130-(Pfinal/81);
        }
        else
            Z=147-(5*Pfinal/376);
        int choice1;

        System.out.println("Adjustment of value of Z based on Wind Direction");
        System.out.println("1. Northerly Winds");
        System.out.println("2.Southerly Winds");
        choice1=sc.nextInt();
        if(choice1==1)
        {
            Z=Z+1;
        }
        else if(choice1==2)
        {
            Z=Z-2;
        }
        else
            System.out.println("Wrong choice");

        System.out.println("Adjustment For Season");
        System.out.println("1..Winter");
        System.out.println("2..Summer");
        int choice2=sc.nextInt();
        if(choice2==1)
            Z=Z-1;
        else if(choice2==2)
            Z=Z+1;

        if(Z>32)
            Z=Z%32;


        if(Z==1)
        {
            System.out.println("Settled Fine");
        }
        else if(Z==2)
        {
            System.out.println("Fine Weather");
        }
        else if(Z==3)
        {

            System.out.println("Fine Becoming Less Setled");
        }
        else if(Z==4)
        {
            System.out.println("Fairly fine Showery Later");

        }
        else if(Z==5)
        {

            System.out.println("Showering Becoming More unsettled");
        }
        else if(Z==6)
        {

            System.out.println("Unsettled, Rain Later");
        }
        else if(Z==7)
        {
            System.out.println("Rain at times, Worse Later");

        }
        else if(Z==8)
        {
            System.out.println("Rain at times ,Becoming Very unsettled");

        }else if(Z==9)
        {
            System.out.println("Very Unsettled, Rain");
        }
        else if(Z==10)
        {
            System.out.println("Settled Fine");
        }
        else if(Z==11)
        {
            System.out.println("Fine Weather");
        }
        else if(Z==12)
        {
            System.out.println("Fine,Possibly Showers");
        }
        else if(Z==13)
        {
            System.out.println("Fairly Fine, Showers Likely");
        }
        else if(Z==14)
        {
            System.out.println("Showery,Bright Intervals");
        }
        else if(Z==15)
        {
            System.out.println("Changeble,Some Rain");
        }
        else if(Z==16)
        {
            System.out.println("Unsettled, Rain at times");
        }
        else if(Z==17)
        {
            System.out.println("Rain at frequent Intervals");
        }
        else if(Z==18)
        {
            System.out.println("Very Unsettled,Rain");
        }
        else if(Z==19)
        {
            System.out.println("Stormy, Much Rain");
        }
        else if(Z==20)
        {
            System.out.println("Settled,Fine");
        }
        else if(Z==21)
        {
            System.out.println("Fine Weather");
        }
        else if(Z==22)
        {
            System.out.println("Becoming Fine");
        }
        else if(Z==23)
        {
            System.out.println("Fairly Fine, Improving");
        }
        else if(Z==24)
        {
            System.out.println("Fairly Fine, Possibly Showers early");
        }
        else if(Z==25)
        {
            System.out.println("Showery Early,Improving");
        }
        else if(Z==26)
        {
            System.out.println("Changeble,Mending");
        }
        else if(Z==27)
        {
            System.out.println("Rather Unsettled, Clearing Later");
        }
        else if(Z==28)
        {
            System.out.println("Unsettled,Probably Improving");
        }
        else if(Z==29)
        {
            System.out.println("Unsettled, Short Fine Intervals");
        }
        else if(Z==30)
        {
            System.out.println("Very Unsetttled, Finer At Times");
        }
        else if(Z==31)
        {
            System.out.println("Stormy, Possibly Improving");
        }
        else if(Z==32)
        {
            System.out.println("Stormy, Much Rain");
        }
        else
            System.out.println("Unsettled,Changeble");










    }
}
