package com.grupo.exception;

public class DiaSemanaInvalido extends Exception
{
  private static final long serialVersionUID = -1L;
  private static final String MENSAJE = "DIA DE SEMANA INVALIDO";

  public DiaSemanaInvalido()
  {
    super("DIA DE SEMANA INVALIDO");
  }
}
