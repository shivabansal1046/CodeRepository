package dwMapMgmt;

public class TblCol_Dtl {

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
	private String	COL_ID;
	private String	LOGIC_COL_NM;
	private String	PHYS_COL_NM;
	private String	DATATYP;
	private String	SRC_TBL_NM;
	private String	SRC_COL_NM;
	private String	COL_BUS_LOGIC;
	private String	COMT;
	private String	PI;
	private String	PPI;
	private String	KEY_COLUMNS;
	private String	SCD_NON_SCD;
	private String	RI_NOT_RI;
	

	
	public String getCOL_ID() {
		return COL_ID;
	}

	public void setCOL_ID(String cOL_ID) {
		COL_ID = cOL_ID;
	}

	public String getLOGIC_COL_NM() {
		return LOGIC_COL_NM;
	}

	public void setLOGIC_COL_NM(String lOGIC_COL_NM) {
		LOGIC_COL_NM = lOGIC_COL_NM;
	}

	public String getPHYS_COL_NM() {
		return PHYS_COL_NM;
	}

	public void setPHYS_COL_NM(String pHYS_COL_NM) {
		PHYS_COL_NM = pHYS_COL_NM;
	}

	public String getDATATYP() {
		return DATATYP;
	}

	public void setDATATYP(String dATATYP) {
		DATATYP = dATATYP;
	}

	public String getSRC_TBL_NM() {
		return SRC_TBL_NM;
	}

	public void setSRC_TBL_NM(String sRC_TBL_NM) {
		SRC_TBL_NM = sRC_TBL_NM;
	}

	public String getSRC_COL_NM() {
		return SRC_COL_NM;
	}

	public void setSRC_COL_NM(String sRC_COL_NM) {
		SRC_COL_NM = sRC_COL_NM;
	}

	public String getCOL_BUS_LOGIC() {
		return COL_BUS_LOGIC;
	}

	public void setCOL_BUS_LOGIC(String cOL_BUS_LOGIC) {
		COL_BUS_LOGIC = cOL_BUS_LOGIC;
	}

	public String getCOMT() {
		return COMT;
	}

	public void setCOMT(String cOMT) {
		COMT = cOMT;
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
	
	
	
	public String getPI() {
		return PI;
	}

	public void setPI(String pI) {
		PI = pI;
	}

	public String getPPI() {
		return PPI;
	}

	public void setPPI(String pPI) {
		PPI = pPI;
	}

	public String getKEY_COLUMNS() {
		return KEY_COLUMNS;
	}

	public void setKEY_COLUMNS(String kEY_COLUMNS) {
		KEY_COLUMNS = kEY_COLUMNS;
	}

	public String getSCD_NON_SCD() {
		return SCD_NON_SCD;
	}

	public void setSCD_NON_SCD(String sCD_NON_SCD) {
		SCD_NON_SCD = sCD_NON_SCD;
	}

	public String getRI_NOT_RI() {
		return RI_NOT_RI;
	}

	public void setRI_NOT_RI(String rI_NOT_RI) {
		RI_NOT_RI = rI_NOT_RI;
	}

	@Override
	public String toString() {
		return  TBL_ID + "~~" + PH_VERS_ID
				+ "~~" + SRC +"~~" + TBL_OWN + "~~"
				+ LOGIC_TBL_NM + "~~" + PHYS_TBL_NM + "~~"
				+ VW_IND + "~~" + ETL_LYR + "~~" + ROW_QRY
				+ "~~" + TBL_SGNFC + "~~" + LD_SCNRO
				+ "~~" + SA_Desc + "~~" + COL_ID
		+ "~~" + LOGIC_COL_NM + "~~"
		+ PHYS_COL_NM + "~~" + DATATYP + "~~"
		+ SRC_TBL_NM + "~~" + SRC_COL_NM
		+ "~~" + COL_BUS_LOGIC + "~~" + COMT+ "~~"+PI+ "~~"+PPI+ "~~"+KEY_COLUMNS+ "~~"+SCD_NON_SCD+ "~~"+RI_NOT_RI;
		
	
	}
	
	public String toStringExp() {
		return  ETL_LYR+ "~~" +PH_VERS_ID+ "~~" +SA_Desc+ "~~" +SRC+ "~~" +SCD_NON_SCD+ "~~" +RI_NOT_RI+ "~~" +LD_SCNRO+ "~~" +VW_IND+ "~~" +
				PI+ "~~" +PPI+ "~~" +KEY_COLUMNS+ "~~" +LOGIC_TBL_NM+ "~~" +LOGIC_COL_NM+ "~~" +PHYS_TBL_NM+ "~~" +PHYS_COL_NM+ "~~" +
				TBL_OWN+ "~~" +DATATYP+ "~~" +SRC_TBL_NM+ "~~" +SRC_COL_NM+ "~~" +COL_BUS_LOGIC+ "~~" +ROW_QRY+ "~~" +TBL_SGNFC+ "~~" +
				COMT;
		
	
	}
	
	
}
