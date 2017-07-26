/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ffsbeans;

/**
 *
 * @author user149
 */
public class MemberDebitOrder {

    private String tranId;
    private String lidno;
    private String REK_NAAM;
    private String REK_NO;
    private String KERE;
    private String BankName;
    private String TIPE_REK;
    private String DAT1;
    private String TAKKODE;
    private String EmpName1;
    private String EmpName2;
    private String PayerName;
    private String PayerID;
    private String SalNr;

    public MemberDebitOrder() {

    }

    public MemberDebitOrder(String tranId, String lidno, String REK_NAAM, String REK_NO, String KERE, String BankName, String TIPE_REK, String DAT1, String TAKKODE, String EmpName1, String EmpName2, String PayerName, String PayerID, String SalNr) {
        this.tranId = tranId;
        this.lidno = lidno;
        this.REK_NAAM = REK_NAAM;
        this.REK_NO = REK_NO;
        this.KERE = KERE;
        this.BankName = BankName;
        this.TIPE_REK = TIPE_REK;
        this.DAT1 = DAT1;
        this.TAKKODE = TAKKODE;
        this.EmpName1 = EmpName1;
        this.EmpName2 = EmpName2;
        this.PayerName = PayerName;
        this.PayerID = PayerID;
        this.SalNr = SalNr;
        
    }

    public String gettranId() {
        return tranId;
    }

    public void settranId(String tranId) {
        this.tranId = tranId;
    }

    public String getlidno() {
        return lidno;
    }

    public void setuser(String lidno) {
        this.lidno = lidno;
    }

    public String getREK_NAAM() {
        return REK_NAAM;
    }

    public void setREK_NAAM(String REK_NAAM) {
        this.REK_NAAM = REK_NAAM;
    }

    public String getREK_NO() {
        return REK_NO;
    }

    public void setREK_NO(String REK_NO) {
        this.REK_NO = REK_NO;
    }

    public String getKERE() {
        return KERE;
    }

    public void setKERE(String KERE) {
        this.KERE = KERE;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String BankName) {
        this.BankName = BankName;
    }

    public String getTIPE_REK() {
        return TIPE_REK;
    }

    public void setTIPE_REK(String TIPE_REK) {
        this.TIPE_REK = TIPE_REK;
    }

    public String getDAT1() {
        return DAT1;
    }

    public void setDAT1(String DAT1) {
        this.DAT1 = DAT1;
    }

    public String getTAKKODE() {
        return TAKKODE;
    }

    public void setTAKKODE(String TAKKODE) {
        this.TAKKODE = TAKKODE;
    }
    public String getEmpName1() {
        return EmpName1;
    }

    public void setEmpName1(String EmpName1) {
        this.EmpName1 = EmpName1;
    }
    public String getEmpName2() {
        return EmpName2;
    }

    public void setEmpName2(String EmpName2) {
        this.EmpName2 = EmpName2;
    }
    public String getPayerName() {
        return PayerName;
    }

    public void setPayerName(String PayerName) {
        this.PayerName = PayerName;
    }
    public String getPayerID() {
        return PayerID;
    }

    public void setPayerID(String PayerID) {
        this.PayerID = PayerID;
    }
    public String getSalNr() {
        return SalNr;
    }

    public void setSalNr(String SalNr) {
        this.SalNr = SalNr;
    }
}
