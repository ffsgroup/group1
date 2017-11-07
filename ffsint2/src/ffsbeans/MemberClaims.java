package ffsbeans;

public class MemberClaims {

    private String tranId;
    private String lidNo;
    private String summId;
    private String tombNr;
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
    private String polTipe;
    private String deceasedId;
    private String decRel;

    public MemberClaims() {

    }

    public MemberClaims(String tranId, String DeceasedSur, String DeceasedIni, String ClaimNr, String ClaimDate, String DateOfDeath, String ClaimStatus, String ClaimSur, String ClaimId, String ClaimRel, String BenefName, String BenefId, String lidNo, String summId, String tombNr, String polTipe, String deceasedId, String decRel) {
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
        this.lidNo = lidNo;
        this.summId = summId;
        this.tombNr = tombNr;
        this.polTipe = polTipe;
        this.deceasedId = deceasedId;
        this.decRel = decRel;
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

    public String getlidNo() {
        return lidNo;
    }

    public void setlidNo(String lidNo) {
        this.lidNo = lidNo;
    }

    public String getsummId() {
        return summId;
    }

    public void setsummId(String summId) {
        this.summId = summId;
    }

    public String gettombNr() {
        return tombNr;
    }

    public void settombNr(String tombNr) {
        this.tombNr = tombNr;
    }

    public String getpolTipe() {
        return polTipe;
    }

    public void setpolTipe(String polTipe) {
        this.polTipe = polTipe;
    }

    public String getdeceasedId() {
        return deceasedId;
    }

    public void setdeceasedId(String deceasedId) {
        this.deceasedId = deceasedId;
    }

        public String getdecRel() {
        return decRel;
    }

    public void setdecRel(String decRel) {
        this.decRel = decRel;
    }
    
}
