package dwMapMgmt;

public class Tbl_Dtl {

	private String	TBL_ID	;
	private String	PH_VERS_ID	;
	private String	SRC	;
	private String	TBL_OWN	;
	private String	LOGIC_TBL_NM	;
	private String	PHYS_TBL_NM	;
	private String	VW_IND	;
	private String	ETL_LYR	;
	private String	ROW_QRY	;
	private String	TBL_SGNFC	;
	private String	LD_SCNRO	;
	private String	SA_Desc	;


	
	@Override
	public String toString() {
		
		
		return  TBL_ID +"~#~" + PH_VERS_ID
				+"~#~" + SRC +"~#~" + TBL_OWN +"~#~"
				+ LOGIC_TBL_NM +"~#~" + PHYS_TBL_NM +"~#~"
				+ VW_IND +"~#~" + ETL_LYR +"~#~" + ROW_QRY
				+"~#~" + TBL_SGNFC +"~#~" + LD_SCNRO
				+"~#~" + SA_Desc;
	
	
		
		
	}

	public String getTBL_ID() {
		return TBL_ID;
	}

	public void setTBL_ID(String tBL_ID) {
		TBL_ID = tBL_ID;
	}

	public String getPH_VERS_ID() {
		return PH_VERS_ID;
	}

	public void setPH_VERS_ID(String pH_VERS_ID) {
		PH_VERS_ID = pH_VERS_ID;
	}

	public String getSRC() {
		return SRC;
	}

	public void setSRC(String sRC) {
		SRC = sRC;
	}

	public String getTBL_OWN() {
		return TBL_OWN;
	}

	public void setTBL_OWN(String tBL_OWN) {
		TBL_OWN = tBL_OWN;
	}

	public String getLOGIC_TBL_NM() {
		return LOGIC_TBL_NM;
	}

	public void setLOGIC_TBL_NM(String lOGIC_TBL_NM) {
		LOGIC_TBL_NM = lOGIC_TBL_NM;
	}

	public String getPHYS_TBL_NM() {
		return PHYS_TBL_NM;
	}

	public void setPHYS_TBL_NM(String pHYS_TBL_NM) {
		PHYS_TBL_NM = pHYS_TBL_NM;
	}

	public String getVW_IND() {
		return VW_IND;
	}

	public void setVW_IND(String vW_IND) {
		VW_IND = vW_IND;
	}

	public String getETL_LYR() {
		return ETL_LYR;
	}

	public void setETL_LYR(String eTL_LYR) {
		ETL_LYR = eTL_LYR;
	}

	public String getROW_QRY() {
		return ROW_QRY;
	}

	public void setROW_QRY(String rOW_QRY) {
		ROW_QRY = rOW_QRY;
	}

	public String getTBL_SGNFC() {
		return TBL_SGNFC;
	}

	public void setTBL_SGNFC(String tBL_SGNFC) {
		TBL_SGNFC = tBL_SGNFC;
	}

	public String getLD_SCNRO() {
		return LD_SCNRO;
	}

	public void setLD_SCNRO(String lD_SCNRO) {
		LD_SCNRO = lD_SCNRO;
	}

	public String getSA_Desc() {
		return SA_Desc;
	}

	public void setSA_Desc(String sA_Desc) {
		SA_Desc = sA_Desc;
	}
	
}
