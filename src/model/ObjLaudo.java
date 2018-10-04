package model;

import java.util.Date;

public class ObjLaudo {
    private int codigo;
    private String diagnostico;
    private ObjPaciente paciente;
    private ObjFuncionario funcionario;
    private ObjConsulta consulta;

    public ObjPaciente getPaciente() {
        return paciente;
    }

    public void setPaciente(ObjPaciente paciente) {
        this.paciente = paciente;
    }

    public ObjFuncionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(ObjFuncionario funcionario) {
        this.funcionario = funcionario;
    }
//    
//    
//
//    public Date getData_consulta() {
//        return data_consulta;
//    }
//
//    public void setData_consulta(Date data_consulta) {
//        this.data_consulta = data_consulta;
//    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public ObjConsulta getConsulta() {
        return consulta;
    }

    public void setConsulta(ObjConsulta consulta) {
        this.consulta = consulta;
    }
    
}
