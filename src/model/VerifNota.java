package model;


public class VerifNota {
    private boolean isBlue,isGreen,isOrange;
    private String type;
    public VerifNota(boolean isBlue,boolean isGreen,boolean isOrange){
        this.isBlue=isBlue;
        this.isGreen=isGreen;
        this.isOrange=isOrange;
        type="Note";
    }

    
    public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public boolean isBlue() {
        return isBlue;
    }

    public void setBlue(boolean blue) {
        isBlue = blue;
    }

    public boolean isGreen() {
        return isGreen;
    }

    public void setGreen(boolean green) {
        isGreen = green;
    }

    public boolean isOrange() {
        return isOrange;
    }

    public void setOrange(boolean orange) {
        isOrange = orange;
    }
}