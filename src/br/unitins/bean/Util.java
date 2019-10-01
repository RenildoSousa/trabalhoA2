package br.unitins.bean;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.InputMismatchException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Util {

	public static void main(String[] args) {

	}
	

	
	
	

	public static void redirect(String url) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
		} catch (IOException e) {
			addMessageError("Erro ao redirecionar a página.");
			e.printStackTrace();
		}
	}
	

	public static void addMessageError(String message) {
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage(message));
	}


}
