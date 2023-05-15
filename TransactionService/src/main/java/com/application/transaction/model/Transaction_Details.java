package com.application.transaction.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserInfo")
public class Transaction_Details {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long transactionId;
	
	@Column(name="TransferFrom")
	private long account_transfer_from;
	private long account_transfer_to;
	private float transfer_amount;
	private boolean status; 
	private String Mode;
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public long getAccount_transfer_from() {
		return account_transfer_from;
	}
	public void setAccount_transfer_from(int account_transfer_from) {
		this.account_transfer_from = account_transfer_from;
	}
	public long getAccount_transfer_to() {
		return account_transfer_to;
	}
	public void setAccount_transfer_to(int account_transfer_to) {
		this.account_transfer_to = account_transfer_to;
	}
	public float getTransfer_amount() {
		return transfer_amount;
	}
	public void setTransfer_amount(float transfer_amount) {
		this.transfer_amount = transfer_amount;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMode() {
		return Mode;
	}
	public void setMode(String mode) {
		Mode = mode;
	}
	
	
	
	
	

	

}
