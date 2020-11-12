/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author danielfelizardo
 */
public class Conta {

  private String cpfTitular;
  private String numeroConta;
  private String numeroAgencia;
  private double saldo;

  public Conta() {
    this("", "", "", 0.0);
  }

  public Conta(String cpf, String numC, String numAg, double saldo) {
    this.cpfTitular = cpf;
    this.numeroConta = numC;
    this.numeroAgencia = numAg;
    this.saldo = saldo;
  }

  /**
   * @return the cpfTitular
   */
  public String getCpfTitular() {
    return this.cpfTitular;
  }

  /**
   * @param cpfTitular the cpfTitular to set
   */
  public void setCpfTitular(String cpfTitular) {
    this.cpfTitular = cpfTitular;
  }

  /**
   * @return the numeroConta
   */
  public String getNumeroConta() {
    return this.numeroConta;
  }

  /**
   * @param numeroConta the numeroConta to set
   */
  public void setNumeroConta(String numeroConta) {
    this.numeroConta = numeroConta;
  }

  /**
   * @return the numeroAgencia
   */
  public String getNumeroAgencia() {
    return this.numeroAgencia;
  }

  /**
   * @param numeroAgencia the numeroAgencia to set
   */
  public void setNumeroAgencia(String numeroAgencia) {
    this.numeroAgencia = numeroAgencia;
  }

  /**
   * @return the saldo
   */
  public double getSaldo() {
    return this.saldo;
  }

  /**
   * @param saldo the saldo to set
   */
  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public double creditar(double valor) {
    this.saldo += valor;
    return this.saldo;
  }

  public double debitar(double valor) {
    if (this.saldo >= valor) {
      this.saldo -= valor;
    }

    return this.saldo;
  }

//  @Override
//  public String toString() {
//    return "CPF Titular: " + this.getCpfTitular() + "\nNúmero da Conta: "
//      + this.getNumeroConta() + "\nNúmero da Agencia: "
//      + this.getNumeroAgencia() + "\nSaldo total: " + this.getSaldo();
//  }
  @Override
  public String toString() {
    return "Conta número " + this.getNumeroConta() +
      " do cliente de CPF " + this.getCpfTitular();
  }
}
