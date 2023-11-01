/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;
import model.BaiDoRac;
import model.Tram;
import model.XeTai;

/**
 *
 * @author Bravo
 */
public class BaiRacController {
    public void readAndRunXeTai() {
        Scanner sc = new Scanner(System.in);

        // Input for BaiDoRac
        System.out.print("Enter the cost for each landfill operation (tien1lanDo): ");
        int tien1lanDo = sc.nextInt();
        BaiDoRac bdr = new BaiDoRac(tien1lanDo);

        // Input for the number of trams and waste data for each tram
        System.out.print("Enter the number of trams: ");
        int numTrams = sc.nextInt();
        int[] soRacMoiTram = new int[numTrams];
        for (int i = 0; i < numTrams; i++) {
            System.out.print("Enter the amount of waste for tram :" );
            soRacMoiTram[i] = sc.nextInt();
        }

        Tram[] tram = new Tram[numTrams];
        for (int i = 0; i < tram.length; i++) {
            tram[i] = new Tram(soRacMoiTram[i]);
        }

        // Continue with the rest of your code as before
        XeTai xt = new XeTai(10000, bdr, tram);
        xt.setThoiGianDiVe(30);
        xt.setThoiGianLayRac(8);
        xt.setTienCong1gio(120000);
        xt.thucThiCongViec();
        System.out.println("Thoi gian lam viec: " + xt.getThoiGianLamViec() + " phut");
        System.out.println("So tien tra xe tai: " + xt.phiTraXeTai());
        System.out.println("So lan do rac: " + xt.getSoLanDoRac());
        System.out.println("So tien tra bai rac: " + xt.phiTraBaiRac());
        System.out.println("Tong so tien: " + xt.phiTongCong());
    }
}
