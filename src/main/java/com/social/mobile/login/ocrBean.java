package com.social.mobile.login;

import java.util.List;


public class ocrBean {
	public boolean success;


	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	private String text;

	    public String getText() {
	        return text;
	    }

	    public void setText(String text) {
	        this.text = text;
	    }
	    
	   
		
		 public List<List<String>> getTableData() {
			return tableData;
		}

		public void setTableData(List<List<String>> tableData) {
			this.tableData = tableData;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		private List<List<String>> tableData;
		    private String message;
		    
		private String excelFilePath;

		public String getExcelFilePath() {
			return excelFilePath;
		}

		public void setExcelFilePath(String excelFilePath) {
			this.excelFilePath = excelFilePath;
		}
		
		public String getPurchaseNo() {
			return purchaseNo;
		}

		public void setPurchaseNo(String purchaseNo) {
			this.purchaseNo = purchaseNo;
		}

		private String purchaseNo;
		public String getPodate() {
			return podate;
		}

		public void setPodate(String podate) {
			this.podate = podate;
		}

		private String podate;
		
		public List<TableRow> getDetailTable() {
			return detailTable;
		}

		public void setDetailTable(List<TableRow> detailTable) {
			this.detailTable = detailTable;
		}

		private  List<TableRow> detailTable;
		
		 public String getOcrid() {
				return ocrid;
			}
			public void setOcrid(String ocrid) {
				this.ocrid = ocrid;
			}
			public String getOcrmsg() {
				return ocrmsg;
			}
			public void setOcrmsg(String ocrmsg) {
				this.ocrmsg = ocrmsg;
			}
			public String getCreateddt() {
				return createddt;
			}
			public void setCreateddt(String createddt) {
				this.createddt = createddt;
			}
			public String getCreatedname() {
				return createdname;
			}
			public void setCreatedname(String createdname) {
				this.createdname = createdname;
			}
			private String ocrid;
		    private String ocrmsg;
		    private String createddt;
		    private String createdname;
		    
		   

			public List<TableRow> getAggreDetail() {
				return aggreDetail;
			}

			public void setAggreDetail(List<TableRow> aggreDetail) {
				this.aggreDetail = aggreDetail;
			}

			private  List<TableRow> aggreDetail;
			private List<ocrBean> compareData;


			public List<ocrBean> getCompareData() {
				return compareData;
			}

			public void setCompareData(List<ocrBean> compareData) {
				this.compareData = compareData;
			}
			
			public String getPartyno() {
				return partyno;
			}
			public void setPartyno(String partyno) {
				this.partyno = partyno;
			}
			public String getInvqty() {
				return invqty;
			}
			public void setInvqty(String invqty) {
				this.invqty = invqty;
			}
			public String getPoqty() {
				return poqty;
			}
			public void setPoqty(String poqty) {
				this.poqty = poqty;
			}
			public String getInvunit() {
				return invunit;
			}
			public void setInvunit(String invunit) {
				this.invunit = invunit;
			}
			public String getPounit() {
				return pounit;
			}
			public void setPounit(String pounit) {
				this.pounit = pounit;
			}
			private String partyno;
		    private String invqty;
		    private String poqty;
		    private String invunit;
		    private String pounit;
		    public String getDiffunit() {
				return diffunit;
			}
			public void setDiffunit(String diffunit) {
				this.diffunit = diffunit;
			}
			private String diffunit;
			
			public boolean isRedcolour() {
				return redcolour;
			}
			public void setRedcolour(boolean redcolour) {
				this.redcolour = redcolour;
			}
			private boolean redcolour;
}
