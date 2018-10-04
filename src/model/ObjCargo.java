package model;

public class ObjCargo {
    private int codigo;
    private String nome;
    private double salario;
    private ObjSetor setor;

    public ObjSetor getSetor() {
        return setor;
    }

    public void setSetor(ObjSetor setor) {
        this.setor = setor;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    public ObjCargo (){
        
    }
    public ObjCargo(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
