package main;

public class Recordatorio {
	
	
	 private String x,y,color,textor,btn;

	    public Recordatorio(String x,String y,String color,String textor,String btn){

	    	this.x=x;
	    	this.y=y;
	    	this.color=color;
	    	this.textor=textor;
	    	this.btn=btn;
	        

	    }

		public String getY() {
			return y;
		}

		public void setY(String y) {
			this.y = y;
		}

		public String getX() {
			return x;
		}

		public void setX(String x) {
			this.x = x;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getTextor() {
			return textor;
		}

		public void setTextor(String textor) {
			this.textor = textor;
		}

		public String getBtn() {
			return btn;
		}

		public void setBtn(String btn) {
			this.btn = btn;
		}

}
