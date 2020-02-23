package com.njwb.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Financial {
		String financial_roomId;
		String financial_address;
		@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
		Date financial_rendtime;
		String financial_price; //月租
		String financial_premoney;
		String findancial_waterprice;
		String findancial_powerprice;
		String findancial_watermeter;
		public String getFindancial_watermeter() {
			return findancial_watermeter;
		}
		public void setFindancial_watermeter(String findancial_watermeter) {
			this.findancial_watermeter = findancial_watermeter;
		}
		String findancial_powermeter;
		public String getFindancial_powermeter() {
			return findancial_powermeter;
		}
		public void setFindancial_powermeter(String findancial_powermeter) {
			this.findancial_powermeter = findancial_powermeter;
		}
		public String getFinancial_roomId() {
			return financial_roomId;
		}
		public void setFinancial_roomId(String financial_roomId) {
			this.financial_roomId = financial_roomId;
		}
		public String getFinancial_address() {
			return financial_address;
		}
		public void setFinancial_address(String financial_address) {
			this.financial_address = financial_address;
		}
		public Date getFinancial_rendtime() {
			return financial_rendtime;
		}
		public void setFinancial_rendtime(Date financial_rendtime) {
			this.financial_rendtime = financial_rendtime;
		}
		public String getFinancial_price() {
			return financial_price;
		}
		public void setFinancial_price(String financial_price) {
			this.financial_price = financial_price;
		}
		public String getFinancial_premoney() {
			return financial_premoney;
		}
		public void setFinancial_premoney(String financial_premoney) {
			this.financial_premoney = financial_premoney;
		}
		public String getFindancial_waterprice() {
			return findancial_waterprice;
		}
		public void setFindancial_waterprice(String findancial_waterprice) {
			this.findancial_waterprice = findancial_waterprice;
		}
		public String getFindancial_powerprice() {
			return findancial_powerprice;
		}
		public void setFindancial_powerprice(String findancial_powerprice) {
			this.findancial_powerprice = findancial_powerprice;
		}

}
