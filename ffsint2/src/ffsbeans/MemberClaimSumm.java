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
public class MemberClaimSumm {

    private String tranId;
    private String taskEnq;
    private String taskClaim;
    private String taskPay;    

    public MemberClaimSumm() {

    }

    public MemberClaimSumm(String tranId, String taskEnq, String taskClaim, String taskPay) {    
        this.tranId = tranId;
        this.taskEnq = taskEnq;
        this.taskClaim = taskClaim;
        this.taskPay = taskPay;

    }

    public String gettranId() {
        return tranId;
    }

    public void settranId(String tranId) {
        this.tranId = tranId;
    }

    public String gettaskEnq() {
        return taskEnq;
    }

    public void settaskEnq(String taskEnq) {
        this.taskEnq = taskEnq;
    }

    public String gettaskClaim() {
        return taskClaim;
    }

    public void settaskClaim(String taskClaim) {
        this.taskClaim = taskClaim;
    }

    public String gettaskPay() {
        return taskPay;
    }

    public void settaskPay(String taskPay) {
        this.taskPay = taskPay;
    }

}
