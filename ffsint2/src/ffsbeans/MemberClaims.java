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
public class MemberClaims {

    private String tranId;
    private String DeceasedSur;
    private String DeceasedIni;
    private String ClaimNr;
     private String ClaimDate;
      private String DateOfDeath;
      private String ClaimStatus;

    public MemberClaims() {

    }

    public MemberClaims(String tranId, String DeceasedSur, String DeceasedIni, String ClaimNr, String ClaimDate, String DateOfDeath, String ClaimStatus) {
        this.tranId = tranId;
        this.DeceasedSur = DeceasedSur;
        this.DeceasedIni = DeceasedIni;
        this.ClaimNr = ClaimNr;
        this.ClaimDate = ClaimDate;
        this.DateOfDeath = DateOfDeath;
        this.ClaimStatus = ClaimStatus;
    }

    public String gettranId() {
        return tranId;
    }

    public void settranId(String tranId) {
        this.tranId = tranId;
    }

    public String getDeceasedSur() {
        return DeceasedSur;
    }

    public void setDeceasedSur(String DeceasedSur) {
        this.DeceasedSur = DeceasedSur;
    }

    public String getDeceasedIni() {
        return DeceasedIni;
    }

    public void setDeceasedIni(String DeceasedIni) {
        this.DeceasedIni = DeceasedIni;
    }

    public String getClaimNr() {
        return ClaimNr;
    }

    public void setClaimNr(String ClaimNr) {
        this.ClaimNr = ClaimNr;
    }
    
     public String getClaimDate() {
        return ClaimDate;
    }

    public void setClaimDate(String ClaimDate) {
        this.ClaimDate = ClaimDate;
    }
     public String getDateOfDeath() {
        return DateOfDeath;
    }

    public void setDateOfDeath(String DateOfDeath) {
        this.DateOfDeath = DateOfDeath;
    }
    public String getClaimStatus() {
        return DateOfDeath;
    }

    public void setClaimStatus(String ClaimStatus) {
        this.ClaimStatus = ClaimStatus;
    }

}
