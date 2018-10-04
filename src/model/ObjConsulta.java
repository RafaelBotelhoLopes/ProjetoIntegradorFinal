package model;

import java.util.Date;

public class ObjConsulta {
    
    private int codigo;
    private Date data_consulta;
    private ObjPaciente paciente;
    private ObjFuncionario funcionario;
    private String laudo;

    public String getLaudo() {
        return laudo;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }

    public ObjFuncionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(ObjFuncionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getCodigo() {
        return codigo;
    }

    public ObjPaciente getPaciente() {
        return paciente;
    }

    public void setPaciente(ObjPaciente paciente) {
        this.paciente = paciente;
    }

    

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData_consulta() {
        return data_consulta;
    }

    public void setData_consulta(Date data_consulta) {
        this.data_consulta = data_consulta;
    }
}

