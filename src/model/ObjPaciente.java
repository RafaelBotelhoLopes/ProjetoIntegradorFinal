package model;

import java.util.Date;

public class ObjPaciente {
    
    public static final int MASCULINO = 1;
    public static final int FEMININO = 2;
   
    
    private int codigo;
    private Date nascimento;

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    private ObjConsulta consulta;

    public ObjConsulta getConsulta() {
        return consulta;
    }

    public void setConsulta(ObjConsulta consulta) {
        this.consulta = consulta;
    }
        

    private String nome, endereco, rg, estado_civil, plano_saude, telefone;
    private int sexo;
    
    public ObjPaciente(){

}
    public ObjPaciente(String nome) {
        this.nome = nome;
    }

    
    public ObjPaciente(int codigo, String nome, String endereco, String telefone, String estado_civil, String plano_saude) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.estado_civil = estado_civil;
        this.plano_saude = plano_saude;
        this.nascimento = nascimento;
        this.sexo = sexo;
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    } 
    
    public String getPlano_saude() {
        return plano_saude;
    }

    public void setPlano_saude(String plano_saude) {
        this.plano_saude = plano_saude;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
