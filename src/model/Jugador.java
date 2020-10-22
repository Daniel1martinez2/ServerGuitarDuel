package model;

public class Jugador {
    private String id;
    private int score;
    private String type;
    public Jugador(String id,int score){

        this.id=id;
        this.score=score;
        type="Jugador";

    }

    
    
    public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}




    public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
