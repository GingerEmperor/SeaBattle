package com.company;

import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
    int record=0;
	int[] locOfShip={2,3,4};
	int tailOsHhip=locOfShip[0];
	Ships Ship1=new Ships();
	Ship1.SetLoc(locOfShip,tailOsHhip);
	Scanner in=new Scanner(System.in);
	while(!(Ship1.G())){
	    record++;
	    System.out.println("Shoot:  ");
	    int myS=in.nextInt();
	    Ship1.IsDead(myS);

    }
    System.out.println("Your record is "+record);
    }


    public static class Ships{
        private int[] location = new int[10];
        private String checkYouSelf;
        private int DeadShoots=0;
        private boolean GameIsOver=false;

        public void SetLoc(int[] loc,int start){
            for(int i=start; i<start+loc.length;i++){
                location[i]=1;
            }
        }

        public void SetCheck(String sh){
            checkYouSelf=sh;
            System.out.println(checkYouSelf);
        }


        public void IsDead(int Shot){
            if(location[Shot]==1){
                DeadShoots++;
                if(DeadShoots==3) {
                    SetCheck("Убил");
                    GameIsOver = true;
                }
                else
                    SetCheck("Попал");
            }
            else
                SetCheck("Мимо");
        }

        public boolean G(){
            return GameIsOver;
        }

    }
}
