/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.ArrayList;

/**
 *
 * @author danielfelizardo
 */
public class BancoList {

  private String nome;
  private String cnpj;
  private ArrayList<Conta> contas;

  public BancoList(String nome, String cnpj, ArrayList<Conta> contas) {
    this.nome = nome;
    this.cnpj = cnpj;
    this.contas = contas;
  }

  public double consultarSaldoDeConta(String numConta, String numAgencia) {
    double saldo = 0;
    for (Conta conta : this.contas) {
      if (conta.getNumeroConta().equals(numConta) &&
          conta.getNumeroAgencia().equals(numAgencia)
      ) {
        saldo = conta.getSaldo();
      }
    }
    return saldo;
  }
  
  public void transferir(
    String numContaO,
    String numAgO,
    String numContaD,
    String numAgD,
    double valor
  ) {
    Conta contaOrigin = null;
    Conta contaDestino = null;
    
    for (Conta conta: this.contas) {
      if (conta.getNumeroConta().equals(numContaO) &&
          conta.getNumeroAgencia().equals(numAgO)
      ) {
        contaOrigin = conta;
      }
      if (conta.getNumeroConta().equals(numContaD) &&
          conta.getNumeroAgencia().equals(numAgD)
      ) {
        contaDestino = conta;
      }
    }
    
    if (contaOrigin != null && contaDestino != null &&
        contaOrigin.getSaldo() >= valor
    ) {
      contaOrigin.debitar(valor);
      contaDestino.creditar(valor);
    }
  }
  
  public void abrirConta(
    String cpfTitular,
    String numConta,
    String numAgencia,
    double saldoInicial
  ) {
    Conta conta = new Conta(cpfTitular, numConta, numAgencia, saldoInicial);
    this.contas.add(conta);
  }

  public ArrayList<Conta> pesquisarContasComSaldoNegativo() {
    ArrayList<Conta> contasSaldoNegativo = new ArrayList<Conta>();
    
    for (Conta conta: this.contas) {
      if (conta.getSaldo() < 0) {
        contasSaldoNegativo.add(conta);
      }
    }
    
    return contasSaldoNegativo;
  }
  
  public double sacarDeConta(
    String numConta,
    String numAgencia,
    double valor
  ) {
    double saque = 0.0;

    for (Conta conta: this.contas) {
      if (
        conta.getNumeroConta().equals(numConta) &&
        conta.getNumeroAgencia().equals(numAgencia) &&
        conta.getSaldo() >= valor
      ) {
          conta.setSaldo(saque);
          saque = valor;
      }
    }
    
    return saque;
  }
  
  public double depositarEmConta(
    String numConta,
    String numAgencia,
    double valor
  ) {
    double deposito = 0.0;

    for (Conta conta: this.contas) {
      if (
        conta.getNumeroConta().equals(numConta) &&
        conta.getNumeroAgencia().equals(numAgencia)
      ) {
          conta.setSaldo(deposito);
          deposito = valor;
      }
    }
    
    return deposito;
  }
  
  public ArrayList<Conta> pesquisarContasDoCliente(String cpf) {
    ArrayList<Conta> contasCliente = new ArrayList<Conta>();
    
    for (Conta conta: this.contas) {
      if (conta.getCpfTitular().equals(cpf)) {
        contasCliente.add(conta);
      }
    }
    
    return contasCliente;
  }

  @Override
  public String toString() {
    return "Nome: " + this.nome + "\nCNPJ: " + this.cnpj;
  }
}
