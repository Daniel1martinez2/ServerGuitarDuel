package model;


public class VerifNota {
    private boolean isBlue,isGreen,isOrange;
    private String type;
    private String id;
    public VerifNota(boolean isBlue,boolean isGreen,boolean isOrange,String id){
        this.isBlue=isBlue;
        this.isGreen=isGreen;
        this.isOrange=isOrange;
        this.id=id;
        type="Note";
    }

    
    
    public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
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