package br.com.basis.sgp.unitario;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Test;

import br.com.basis.sgp.dominio.Prova;
import br.com.basis.sgp.dominio.Questao;

public class ProvaTest {
@Test
    public void TesteProvaIdNull() {

        Prova prova = new Prova();
            
        prova.setTitulo("Prova Senior");
        prova.setPercentual(new BigDecimal("90.00"));
        Assert.assertNull(prova.getId());
    }
@Test
    public void TesteTituloNull() {

        Prova prova = new Prova();
            
        prova.setPercentual(new BigDecimal("90.00"));
        Assert.assertNull(prova.getTitulo());
    }
    @Test
    public void TesteTituloDiferente() {
        String titulo = "Nao Sei Criar Testes";

        Prova prova = new Prova();
        prova.setTitulo("Vou Aprender a Criar");
        Assert.assertThat(titulo,IsNot.not(IsEqual.equalTo(prova.getTitulo())));
    }
     @Test
    public void TesteTituloIgual() {
        String titulo = "Nao Sei Criar Testes";

        Prova prova = new Prova();
        prova.setTitulo("Nao Sei Criar Testes");
        Assert.assertEquals(titulo,prova.getTitulo());
    }
}
