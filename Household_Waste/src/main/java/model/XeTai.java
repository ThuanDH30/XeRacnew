/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Bravo
 */

public class XeTai {
    private int thoiGianLayRac;
    private int tienCong1gio;
    private int thoiGianDiVe;
    private int taiTrongToiDa;
    private int taiTrongHienTai;
    private int thoiGianLamViec;
    private int soLanDoRac;
    private BaiDoRac baiDoRac;
    private Tram[] tram;

    public XeTai(int taiTrongToiDa, BaiDoRac baiDoRac, Tram[] tram) {
        this.taiTrongToiDa = taiTrongToiDa;
        this.baiDoRac = baiDoRac;
        this.tram = tram;
    }

    public void setThoiGianLayRac(int thoiGianLayRac) {
        this.thoiGianLayRac = thoiGianLayRac;
    }

    public void setTienCong1gio(int tienCong1gio) {
        this.tienCong1gio = tienCong1gio;
    }

    public void setThoiGianDiVe(int thoiGianDiVe) {
        this.thoiGianDiVe = thoiGianDiVe;
    }

    public void setTaiTrongToiDa(int taiTrongToiDa) {
        this.taiTrongToiDa = taiTrongToiDa;
    }

    public void setTaiTrongHienTai(int taiTrongHienTai) {
        this.taiTrongHienTai = taiTrongHienTai;
    }

    public void setThoiGianLamViec(int thoiGianLamViec) {
        this.thoiGianLamViec = thoiGianLamViec;
    }

    public void setSoLanDoRac(int soLanDoRac) {
        this.soLanDoRac = soLanDoRac;
    }

    public void setBaiDoRac(BaiDoRac baiDoRac) {
        this.baiDoRac = baiDoRac;
    }

    public void setTram(Tram[] tram) {
        this.tram = tram;
    }

    // Getters and setters

    public int phiTraXeTai() {
        return (thoiGianLamViec * tienCong1gio) / 60;
    }

    public int getThoiGianLayRac() {
        return thoiGianLayRac;
    }

    public int getTienCong1gio() {
        return tienCong1gio;
    }

    public int getThoiGianDiVe() {
        return thoiGianDiVe;
    }

    public int getTaiTrongToiDa() {
        return taiTrongToiDa;
    }

    public int getTaiTrongHienTai() {
        return taiTrongHienTai;
    }

    public int getThoiGianLamViec() {
        return thoiGianLamViec;
    }

    public int getSoLanDoRac() {
        return soLanDoRac;
    }

    public BaiDoRac getBaiDoRac() {
        return baiDoRac;
    }

    public Tram[] getTram() {
        return tram;
    }

    public int phiTraBaiRac() {
        return soLanDoRac * baiDoRac.getTien1lanDo();
    }

    public int phiTongCong() {
        return phiTraXeTai() + phiTraBaiRac();
    }

    public void thucThiCongViec() {
        reset();
        if (tram == null) {
            return;
        }
        for (Tram tr : tram) {
            System.out.println("-------------------");
            System.out.println("so rac cua tram ke tiep: " + tr.getSoRac() + "(kg)");
            gomRac(tr);
        }
        if (taiTrongHienTai > 0) {
            doRac();
            System.out.println("-------------------");
            System.out.println("do rac lan: " + soLanDoRac);
            System.out.println("thoi gian: " + thoiGianLamViec);
        }
        System.out.println("-------------------");
    }

    private void gomRac(Tram tram) {
        while (tram.getSoRac() > 0) {
            thoiGianLamViec += thoiGianLayRac;
            if (taiTrongHienTai + tram.getSoRac() >= taiTrongToiDa) {
                int taiTrongConLai = taiTrongToiDa - taiTrongHienTai;
                tram.setSoRac(tram.getSoRac() - taiTrongConLai);
                System.out.println("So rac con lai cua tram sau khi xe tai day rac: " + tram.getSoRac() + "(kg)");
                System.out.println("Thoi gian lam viec hien tai sau khi lay rac: " + thoiGianLamViec + "(phut)");
                doRac();
                System.out.println("Do rac lan thu: " + soLanDoRac);
                System.out.println("Thoi gian lam viec hien tai sau khi do rac: " + thoiGianLamViec + "(phut)");
            } else {
                taiTrongHienTai += tram.getSoRac();
                tram.setSoRac(0);
                System.out.println("tai trong hien tai sau khi lay het rac: " + taiTrongHienTai + "(kg)");
                System.out.println("thoi gian lam viec hien tai sau khi lay het rac: " + thoiGianLamViec + "(phut)");
            }
        }
    }

    private void reset() {
        thoiGianLamViec = 0;
        soLanDoRac = 0;
        taiTrongHienTai = 0;
    }

    private void doRac() {
        thoiGianLamViec += thoiGianDiVe;
        taiTrongHienTai = 0;
        soLanDoRac += 1;
    }
}
