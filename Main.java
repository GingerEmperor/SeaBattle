package com.company;

import java.sql.Array;
import java.util.Scanner;
import java.util.Set;

public class Main {

   public static int[] map=new int[100];//карта на 100 ячеек


    public static void main(String[] args) {
    Ships Ship1=new Ships();
    Scanner in=new Scanner(System.in);
    System.out.println("Enter the cordinates of the Ship's tail");
    Ship1.SetCoord(in.nextInt());//    //Ввод координат хвоста
    System.out.println("Enter the size of the ship");
    Ship1.SetSize(in.nextInt());//Ввод размера корабля
    int record=0;
//	int[] locOfShip=new int[sizeOfShip];

	Ship1.SetLoc();

	while(!(Ship1.G())){//пока игра не закончена
	    record++;
	    System.out.println("Shoot:  ");//ввод выстрела
	    int myShot=in.nextInt();
	    Ship1.IsDead(myShot);

    }
    System.out.println("Your record is "+record);
    }


    public static class Ships{
        private int size=0;//размер корабля
        private int coordOftile=0;//координаты хвоста корабля|||  пока нет //(куда он будет направлен(8-север. 2-юг. 6-западю 4-восток))
        private String checkYouSelf; //состояние корабля
        private int DeadShoots=0;
        private boolean GameIsOver=false;

        public void SetLoc(){
            for(int i=coordOftile; i<coordOftile+size;i++){
                map[i]=1;//ячейки где есть корабль==1
            }
        }

        public void SetCheck(String sh){//ввод состояния корабля
            checkYouSelf=sh;
            System.out.println(checkYouSelf);
        }


        public void IsDead(int Shot){
            if(map[Shot]==1){//Если в ячейке есть корабль
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

        public void SetSize(int sz){
            size=sz;
        }

        public void SetCoord(int co){
            coordOftile=co;
        }

        public boolean G(){
            return GameIsOver;
        }

    }
}
