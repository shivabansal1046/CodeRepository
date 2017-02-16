package dwMapMgmt;

public class Col_Dtl {
	
	private String	TBL_ID;
	private String	PHYS_TBL_NM;
	private String	LOGIC_TBL_NM;
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
	
	         
	
	public String getPHYS_TBL_NM() {
		return PHYS_TBL_NM;
	}
	public void setPHYS_TBL_NM(String pHYS_TBL_NM) {
		PHYS_TBL_NM = pHYS_TBL_NM;
	}
	
	
	public String getLOGIC_TBL_NM() {
		return LOGIC_TBL_NM;
	}
	public void setLOGIC_TBL_NM(String lOGIC_TBL_NM) {
		LOGIC_TBL_NM = lOGIC_TBL_NM;
	}
	public String getTBL_ID() {
		return TBL_ID;
	}
	public void setTBL_ID(String tBL_ID) {
		TBL_ID = tBL_ID;
	}
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
		return TBL_ID + "~#~" + COL_ID
				+ "~#~" + LOGIC_COL_NM + "~#~"
				+ PHYS_COL_NM + "~#~" + DATATYP + "~#~"
				+ SRC_TBL_NM + "~#~" + SRC_COL_NM
				+ "~#~" + COL_BUS_LOGIC + "~#~" + COMT+ "~#~"+PI+ "~#~"+PPI+ "~#~"+KEY_COLUMNS+ "~#~"+SCD_NON_SCD+ "~#~"+RI_NOT_RI;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((COL_BUS_LOGIC == null) ? 0 : COL_BUS_LOGIC.hashCode());
		result = prime * result + ((COL_ID == null) ? 0 : COL_ID.hashCode());
		result = prime * result + ((COMT == null) ? 0 : COMT.hashCode());
		result = prime * result + ((DATATYP == null) ? 0 : DATATYP.hashCode());
		result = prime * result
				+ ((LOGIC_COL_NM == null) ? 0 : LOGIC_COL_NM.hashCode());
		result = prime * result
				+ ((PHYS_COL_NM == null) ? 0 : PHYS_COL_NM.hashCode());
		result = prime * result
				+ ((PHYS_TBL_NM == null) ? 0 : PHYS_TBL_NM.hashCode());
		result = prime * result
				+ ((SRC_COL_NM == null) ? 0 : SRC_COL_NM.hashCode());
		result = prime * result
				+ ((SRC_TBL_NM == null) ? 0 : SRC_TBL_NM.hashCode());
		result = prime * result + ((TBL_ID == null) ? 0 : TBL_ID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Col_Dtl other = (Col_Dtl) obj;
		if (COL_BUS_LOGIC != null && other.COL_BUS_LOGIC!=null && !COL_BUS_LOGIC.equals(other.COL_BUS_LOGIC))
			return false;
		if (COL_ID != null && other.COL_ID != null && !COL_ID.equals(other.COL_ID))
			return false;
		if (COMT != null && other.COMT != null && !COMT.equals(other.COMT))
			return false;
		if (DATATYP != null && other.DATATYP != null && !DATATYP.equals(other.DATATYP))
			return false;
		if (LOGIC_COL_NM != null && other.LOGIC_COL_NM != null && !LOGIC_COL_NM.equals(other.LOGIC_COL_NM))
			return false;
		if (PHYS_COL_NM != null && other.PHYS_COL_NM != null && !PHYS_COL_NM.equals(other.PHYS_COL_NM))
			return false;
		/*if (PHYS_TBL_NM == null && other.PHYS_TBL_NM != null && !PHYS_TBL_NM.equals(other.PHYS_TBL_NM))
			return false;*/
		if (SRC_COL_NM != null && other.SRC_COL_NM != null &&!SRC_COL_NM.equals(other.SRC_COL_NM))
			return false;
		if (SRC_TBL_NM != null && other.SRC_TBL_NM != null && !SRC_TBL_NM.equals(other.SRC_TBL_NM))
			return false;
		if (TBL_ID != null && other.TBL_ID != null &&!TBL_ID.equals(other.TBL_ID))
			return false;
		if (PI != null && other.PI!=null && !PI.equals(other.PI))
			return false;
		if (PPI != null && other.PPI!=null && !PPI.equals(other.PPI))
			return false;
		if (KEY_COLUMNS != null && other.KEY_COLUMNS!=null && !KEY_COLUMNS.equals(other.KEY_COLUMNS))
			return false;
		if (SCD_NON_SCD != null && other.SCD_NON_SCD!=null && !SCD_NON_SCD.equals(other.SCD_NON_SCD))
			return false;
		
		if (RI_NOT_RI != null && other.RI_NOT_RI!=null && !RI_NOT_RI.equals(other.RI_NOT_RI))
			return false;
		
		return true;
	}

	
}
