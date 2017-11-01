package ffsbeans;

public class MemberClaims {

    private String tranId;
    private String DeceasedSur;
    private String DeceasedIni;
    private String ClaimNr;
    private String ClaimDate;
    private String DateOfDeath;
    private String ClaimStatus;
    private String ClaimSur;
    private String ClaimId;
    private String ClaimRel;
    private String BenefName;
    private String BenefId;
    

    public MemberClaims() {

    }

    public MemberClaims(String tranId, String DeceasedSur, String DeceasedIni, String ClaimNr, String ClaimDate, String DateOfDeath, String ClaimStatus, String ClaimSur, String ClaimId, String ClaimRel, String BenefName, String BenefId) {
        this.tranId = tranId;
        this.DeceasedSur = DeceasedSur;
        this.DeceasedIni = DeceasedIni;
        this.ClaimNr = ClaimNr;
        this.ClaimDate = ClaimDate;
        this.DateOfDeath = DateOfDeath;
        this.ClaimStatus = ClaimStatus;
        this.ClaimSur = ClaimSur;
        this.ClaimId = ClaimId;
        this.ClaimRel = ClaimRel;
        this.BenefName = BenefName;
        this.BenefId = BenefId;

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

        public String getClaimSur() {
        return ClaimSur;
    }

    public void setClaimSur(String ClaimSur) {
        this.ClaimSur = ClaimSur;
    }
    
    public String getClaimId() {
        return ClaimId;
    }

    public void setClaimId(String ClaimId) {
        this.ClaimId = ClaimId;
    }

        public String getClaimRel() {
        return ClaimRel;
    }

    public void setClaimRel(String ClaimRel) {
        this.ClaimRel = ClaimRel;
    }
    
    public String getBenefName() {
        return BenefName;
    }

    public void setBenefName(String BenefName) {
        this.BenefName = BenefName;
    }

        public String getBenefId() {
        return BenefId;
    }

    public void setBenefId(String BenefId) {
        this.BenefId = BenefId;
    }
    
}
