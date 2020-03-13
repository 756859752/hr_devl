package pojo;

import java.io.Serializable;

public class ConfigPublicChar implements Serializable {
	private int pbcid;
	private String attributekind;
	private String attributename;

	public int getPbcid() {
		return pbcid;
	}

	public void setPbcid(int pbcid) {
		this.pbcid = pbcid;
	}

	public String getAttributekind() {
		return attributekind;
	}

	public void setAttributekind(String attributekind) {
		this.attributekind = attributekind;
	}

	public String getAttributename() {
		return attributename;
	}

	public void setAttributename(String attributename) {
		this.attributename = attributename;
	}

	@Override
	public String toString() {
		return "ConfigPublicChar [pbcid=" + pbcid + ", attributekind=" + attributekind + ", attributename="
				+ attributename + "]";
	}

}
