package main;

import java.util.LinkedList;

import processing.core.PApplet;

public class Main extends PApplet{

	private TCPConnection conectar;
	private int posx,posy,colorete;
	private String record;
	private boolean entra=false;
	private boolean creativo=false;
	private LinkedList <Recuerdame> reco;
	
	
    public static void main(String[] args) {
        PApplet.main("main.Main");


    }

    public void settings() {
        size(1000, 700);

    }

    public void setup() {
    	
    	conectar = new TCPConnection();
    	conectar.setMain(this);
    	conectar.start();
    	reco = new LinkedList<Recuerdame>();
    	

    }

    public void draw() {

    	background(255,255,255);
    	
    	for(int i=0;i<reco.size();i++) {
    		
    		int pox = Integer.parseInt(reco.get(i).getX());
    		int poy = Integer.parseInt(reco.get(i).getY());
    		
    		stroke(153);
    		fill(255,255,255);
        	rect(pox,poy,70,35);
        	
        	
        	switch(reco.get(i).getColor()) {
        	
        	case "1":
        		fill(176,0,32);
        		
        		break;
        	
        	case "2":
        		fill(102,153,0);
        		
        		break;
        	case "3":
        		fill(255,187,51);
        		
        		break;
        	}
        	
        	ellipse(pox+30,poy,20,20);
        	fill(0);
        	text(reco.get(i).getTextor(),pox+15,poy+20);
    		
    	}
    	
    	if(entra==true) {
    		
    		stroke(153);
    		fill(255,255,255);
        	rect(posx,posy,70,35);
        	
        	
        	switch(colorete) {
        	
        	case 1:
        		fill(176,0,32);
        		
        		break;
        	
        	case 2:
        		fill(102,153,0);
        		
        		break;
        	case 3:
    	
        		fill(255,187,51);
        		break;
        	}
        	
        	ellipse(posx+30,posy,20,20);
        	fill(0);
        	text(record,posx+15,posy+20);
        	
    	}
    	
    	

   
    	
    	
    	
    	
    	
    }

	public void notificar(Recordatorio rec) {
		
		posx = Integer.parseInt(rec.getX());
		posy = Integer.parseInt(rec.getY());
		record = rec.getTextor();
		colorete = Integer.parseInt(rec.getColor());
		entra = true;
		
		
	}

	public void crear(Recordatorio rec) {
		String pox = rec.getX();
		String poy = rec.getY();
		String recor = rec.getTextor();
		String coloret = rec.getColor();
		
		reco.add(new Recuerdame(pox,poy,coloret,recor));
		entra=false;
		
		
	}

}