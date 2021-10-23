package com.jsfcourse.kredyt;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
//@SessionScoped
public class KredytBB {
	private Double x, y, z ;
	
	private Double result;
	private Double resultt;

	@Inject
	FacesContext ctx;

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}
	public Double getZ() {
		return z;
	}

	public void setZ(Double z) {
		this.z= z;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}
	public Double getResultt() {
		return resultt;
	}

	public void setResultt(Double resultt) {
		this.resultt = resultt;
	}

	public boolean doTheMath() {
		try {
			
			

			result = x*y*z*0.01;
			resultt = (x*y*z*0.01)+x;

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false;
		}
	}

	// Go to "showresult" if ok
	public String calc() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}

	

	public String info() {
		return "info";
	}
}
