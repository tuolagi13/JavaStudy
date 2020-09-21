package com.huangxw.socket.nonblocking;


import com.huangxw.DesignPattern.adapter.classadapter.Phone;

import java.lang.ref.WeakReference;

public class NonBlockingEchoServer {

    public static int DEFAULT_PORT = 7;

    public static void main(String[] args) {

        Phone phone = new Phone();
        WeakReference<Phone> weakCar = new WeakReference<Phone>(phone);
        int i = 0;
        while (true)
        {
            if(weakCar.get() != null)
            {
                i++;
                System.out.println("Object is alive for" + i + "loops");
            }
            else
            {
                System.out.println("Object has been collected");
                break;
            }
        }
//        if(phone != null)
//            System.out.println("phone is not collected");

    }
}
