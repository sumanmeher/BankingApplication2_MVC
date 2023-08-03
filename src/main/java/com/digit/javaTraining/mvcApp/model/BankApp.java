package com.digit.javaTraining.mvcApp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

public class BankApp {
	int bank_id;
	String bank_name;
	String ifsc_code;
	int acc_no;
	int pin;
	int cust_id;
	String cust_name;
	int balance;
	String email;
	long phone;
	int npin;
	int cpin;
	int lid;
	String ltype;
	int tenure;
	double interest;
	String desc;

	public ResultSet resultSet;
	public static PreparedStatement pstmt;
	public static Connection con;

	public BankApp() {
		String url = "jdbc:mysql://localhost:3306/banking application";
		String user = "root";
		String pwd = "admin@12345";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getBank_id() {
		return bank_id;
	}

	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getIfsc_code() {
		return ifsc_code;
	}

	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}

	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getNpin() {
		return npin;
	}

	public void setNpin(int npin) {
		this.npin = npin;
	}

	public int getCpin() {
		return cpin;
	}

	public void setCpin(int cpin) {
		this.cpin = cpin;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLtype() {
		return ltype;
	}

	public void setLtype(String ltype) {
		this.ltype = ltype;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean register() {
		try {
			pstmt = con.prepareStatement("insert into bankapp values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, bank_id);
			pstmt.setString(2, bank_name);
			pstmt.setString(3, ifsc_code);
			pstmt.setInt(4, acc_no);
			pstmt.setInt(5, pin);
			pstmt.setInt(6, cust_id);
			pstmt.setString(7, cust_name);
			pstmt.setInt(8, balance);
			pstmt.setString(9, email);
			pstmt.setLong(10, phone);

			int x = pstmt.executeUpdate();
			if (x > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	public boolean login() {
		try {
			pstmt = con.prepareStatement("select * from bankapp where cust_id=? and pin=?");
			pstmt.setInt(1, cust_id);
			pstmt.setInt(2, pin);

			resultSet = pstmt.executeQuery();
			if (resultSet.next() == true) {
				String cust_name = resultSet.getString("cust_name");
				this.setCust_name(cust_name);
				int acc_no = resultSet.getInt("acc_no");
				this.setAcc_no(acc_no);
				return true;
			} else {
				// resp.sendRedirect("/BankingApplication/LoginFail.html");
				return false;
			}
		} catch (

		Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	public boolean checkBalance() {
		try {
			pstmt = con.prepareStatement("select balance from bankapp where acc_no=?");
			pstmt.setInt(1, acc_no);

			resultSet = pstmt.executeQuery();
			if (resultSet.next() == true) {
//			session.setAttribute("balance", resultSet.getInt("balance"));
//			resp.sendRedirect("/BankingApplication/Balance.jsp");
				int balance = resultSet.getInt("balance");
				this.setBalance(balance);
				return true;
			} else {
				// resp.sendRedirect("/BankingApplication/BalanceFail.html");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean changePin() {
		try {
			if (npin == cpin) {
				pstmt = con.prepareStatement("update bankapp set pin=? where acc_no=? and pin=?");
				pstmt.setInt(1, npin);
				pstmt.setInt(2, acc_no);
				pstmt.setInt(3, pin);

				int x = pstmt.executeUpdate();
				if (x > 0) {

					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return false;
	}

	public boolean loan() {
		try {

			pstmt = con.prepareStatement("select * from loan where l_id=? ");

			pstmt.setInt(1, lid);
			resultSet = pstmt.executeQuery();
			if (resultSet.next() == true) {
				int lid = resultSet.getInt("l_id");
				this.setLid(lid);
				// session.setAttribute("l_id",resultset.getInt(1));
				String ltype = resultSet.getString("l_type");
				this.setLtype(ltype);
				// session.setAttribute("l_type",resultset.getString(2));
				int tenure = resultSet.getInt("tenure");
				this.setTenure(tenure);
				// session.setAttribute("tenure", resultset.getInt(3));
				double interest = resultSet.getDouble("interest");
				this.setInterest(interest);
				// session.setAttribute("interest", resultset.getDouble(4));
				String desc = resultSet.getString("description");
				this.setDesc(desc);
				return true;
				// session.setAttribute("description", resultset.getString(5));
				// resp.sendRedirect("/BankingApplication/LoanDetails.jsp");
			} else {
				return false;
				// resp.sendRedirect("/BankingApplication/LoanDetailsFail.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean transfer(String r_ifsc, int r_accno, int amount) {
		try {
			int t_id = new Random().nextInt(900000) + 100000;
			pstmt = con
					.prepareStatement("select * from bankapp where cust_id=? and ifsc_code=? and acc_no=? and pin=?");
			pstmt.setInt(1, cust_id);
			pstmt.setString(2, ifsc_code);
			pstmt.setInt(3, acc_no);
			pstmt.setInt(4, pin);

			ResultSet res1 = pstmt.executeQuery();

			if (res1.next() == true) {
				pstmt = con.prepareStatement("select * from bankapp where ifsc_code=? and acc_no=?");
				pstmt.setString(1, r_ifsc);
				pstmt.setInt(2, r_accno);

				ResultSet res2 = pstmt.executeQuery();
				if (res2.next() == true) {
					pstmt = con.prepareStatement("select balance from bankapp where acc_no=?");
					pstmt.setInt(1, acc_no);

					ResultSet res3 = pstmt.executeQuery();
					res3.next();
					int bal = res3.getInt(1);
					if (bal > amount) {
						pstmt = con.prepareStatement("update bankapp set balance=balance-? where acc_no=?");
						pstmt.setInt(1, amount);
						pstmt.setInt(2, acc_no);

						int x1 = pstmt.executeUpdate();
						if (x1 > 0) {
							pstmt = con.prepareStatement("update bankapp set balance=balance+? where acc_no=?");
							pstmt.setInt(1, amount);
							pstmt.setInt(2, r_accno);

							int x2 = pstmt.executeUpdate();
							if (x2 > 0) {
								pstmt = con.prepareStatement("insert into transfer_status values(?,?,?,?,?,?,?,?) ");
								pstmt.setInt(1, cust_id);
								pstmt.setString(2, bank_name);
								pstmt.setString(3, ifsc_code);
								pstmt.setInt(4, acc_no);
								pstmt.setString(5, r_ifsc);
								pstmt.setInt(6, r_accno);
								pstmt.setInt(7, amount);
								pstmt.setInt(8, t_id);

								int x3 = pstmt.executeUpdate();
								if (x3 > 0) {
									// System.out.println("transfer success");
									// resp.sendRedirect("/BankingApplication/TransferSuccess.html");
									return true;
								} else {
									// System.out.println("store transaction detail");
									// resp.sendRedirect("/BankingApplication/TransferFail.jsp");
									return false;
								}
							} else {
								// System.out.println("credit amount to receiver");
								// resp.sendRedirect("/BankingApplication/TransferFail.jsp");
								return false;
							}
						} else {
							// System.out.println("debit amount from sender");
							// resp.sendRedirect("/BankingApplication/TransferFail.jsp");
							return false;
						}
					} else {
						// System.out.println("check sufficient balance");
						// resp.sendRedirect("/BankingApplication/TransferFail.jsp");
						return false;
					}
				} else {
					// System.out.println("receiver ifsc and accno");
					// resp.sendRedirect("/BankingApplication/TransferFail.jsp");
					return false;
				}
			} else {
				// System.out.println("sender cust_id,ifsc");
				// resp.sendRedirect("/BankingApplication/TransferFail.jsp");
				return false;
			}
		} catch (Exception e) {
		}
		return false;
	}

}
