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
public class TestaConta {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    BancoList meuBanco = new BancoList(
      "Ayla's Bank",
      "123/321",
      new ArrayList<Conta>()
    );

    meuBanco.abrirConta("111.111.111-11", "222-2", "333-3", 100);
    meuBanco.abrirConta("222.222.222-22", "444-4", "444-4", 100);
    
    System.out.println(meuBanco.consultarSaldoDeConta("222-2", "333-3"));
    
    meuBanco.transferir("222-2", "333-3", "444-4", "444-4", 100);
    
    System.out.println(meuBanco.consultarSaldoDeConta("222-2", "333-3"));
    System.out.println(meuBanco.consultarSaldoDeConta("444-4", "444-4"));
        
    System.out.println(meuBanco.pesquisarContasComSaldoNegativo());
  }
}
