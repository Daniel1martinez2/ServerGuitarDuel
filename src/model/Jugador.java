package model;

public class Jugador {
    private String jugador;
    private int score;
    private String type;
    public Jugador(String jugador,int score){

        this.jugador=jugador;
        this.score=score;
        type="Jugador";

    }

    
    
    public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
