package com.company;

import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    System.out.println("Enter the cordinates of the Ship's tail");
    int tailOfShip=in.nextInt();//Ввод координат хвоста
    System.out.println("Enter the size of the ship");
    int sizeOfShip=in.nextInt();//Ввод размера корабля
    int record=0;
	int[] locOfShip=new int[sizeOfShip];
	Ships Ship1=new Ships();
	Ship1.SetLoc(locOfShip,tailOfShip);

	while(!(Ship1.G())){//пока игра не закончена
	    record++;
	    System.out.println("Shoot:  ");//ввод выстрела
	    int myS=in.nextInt();
	    Ship1.IsDead(myS,sizeOfShip);

    }
    System.out.println("Your record is "+record);
    }


    public static class Ships{
        private int[] location = new int[100]; // Карта на 100 ячеек
        private String checkYouSelf; //состояние корабля
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


        public void IsDead(int Shot, int size){
            if(location[Shot]==1){//Если в ячейке есть корабль
                DeadShoots++;
                if(DeadShoots==size) {//Если кол-во попадпний == размеру корабля
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
