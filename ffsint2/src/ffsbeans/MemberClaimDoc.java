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
public class MemberClaimDoc {

    private String tranId;
    private String lidNo;
    private String claimSumm;
    private String doc1;
    private String doc1User;
    private String doc1Date;
    private String whatDoc;
    private String notNeeded;
    

    public MemberClaimDoc() {

    }

    public MemberClaimDoc(String tranId, String lidNo, String claimSumm, String doc1, String doc1User, String doc1Date, String whatDoc, String notNeeded) {
        this.tranId = tranId;
        this.lidNo = lidNo;
        this.claimSumm = claimSumm;
        this.doc1 = doc1;
        this.doc1User = doc1User;
        this.doc1Date = doc1Date;
        this.whatDoc = whatDoc;
        this.notNeeded = notNeeded;
    }

    public String gettranId() {
        return tranId;
    }

    public void settranId(String tranId) {
        this.tranId = tranId;
    }

    public String getlidNo() {
        return lidNo;
    }

    public void setlidNo(String lidNo) {
        this.lidNo = lidNo;
    }

    public String getclaimSumm() {
        return claimSumm;
    }

    public void setclaimSumm(String claimSumm) {
        this.claimSumm = claimSumm;
    }

    public String getdoc1() {
        return doc1;
    }

    public void setdoc1(String doc1) {
        this.doc1 = doc1;
    }
    
    public String getdoc1User() {
        return doc1User;
    }

    public void setdoc1User(String doc1User) {
        this.doc1User = doc1User;
    }    

    public String getdoc1Date() {
        return doc1Date;
    }

    public void setdoc1Date(String doc1Date) {
        this.doc1Date = doc1Date;
    }   

    public String getwhatDoc() {
        return whatDoc;
    }

    public void setwhatDoc(String whatDoc) {
        this.whatDoc = whatDoc;
    }  

    public String getnotNeeded() {
        return notNeeded;
    }

    public void setnotNeeded(String notNeeded) {
        this.notNeeded = notNeeded;
    }      
    
}
