
package Dto;

import java.sql.Date;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;




@Entity
public class Customer 
{
	@Id
	@SequenceGenerator(initialValue = 112244, allocationSize = 1, sequenceName = "hello_moto", name = "hello_moto")
	@GeneratedValue(generator = "hello_moto")
	int cid;
	
	String cname;
	String passsword;
	long ph;
	String email;
	String gender;
	Date dob;
	
	@OneToMany
	List<Bank_account> bankaccounts;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPasssword() {
		return passsword;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

	public long getPh() {
		return ph;
	}

	public void setPh(long ph) {
		this.ph = ph;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<Bank_account> getBankaccounts() {
		return bankaccounts;
	}

	public void setBankaccounts(List<Bank_account> bankaccounts) {
		this.bankaccounts = bankaccounts;
	}
	
}
