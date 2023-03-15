package com.javacore.video45;

public class Test {
  public static void main(String[] args) {
    Manufacturer mn1 = new Manufacturer("hãng 1", "nước a");
    Manufacturer mn2 = new Manufacturer("hãng 2", "nước b");
    Manufacturer mn3 = new Manufacturer("hãng 3", "nước c");
    
    Transport tr1 = new Plane("plane", mn1, "Dầu");
    Transport tr2 = new Car("car", mn2, "xăng");
    Transport tr3 = new Bicycle("bicycle", mn3);
    
    System.out.println("máy bay");
//    muốn in ra phương thức cất cánh và hạ cánh của riêng máy bay thì phải tạo ra một máy bay
//    Plane pl = new Plane(); chứ ko tạo qua abstrack class được
    
    tr1.start();
    tr1.acceleration();
    System.out.println(tr1.getSpeed());
    tr1.stop();
    System.out.println(tr1.manufactureName());
    
    System.out.println("Ô tô");
    tr2.start();
    tr2.acceleration();
    System.out.println(tr2.getSpeed());
    tr2.stop();
    System.out.println(tr2.manufactureName());
  }

}
