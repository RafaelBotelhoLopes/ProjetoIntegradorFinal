package dao;

import model.ObjLaudo;

public class LaudoDAO {
    public static void inserir(ObjLaudo lau) {
        
//        String data = "" + lau.getData_consulta().getYear() + "-" + (lau.getData_consulta().getMonth() + 1) + "-" + lau.getData_consulta().getDate();
        
        String sql = "INSERT INTO laudos "
                + " ( data_consulta, diagnostico, codPaciente, codFuncionario ) "
                + " VALUES ( "
                + " '" + lau.getDiagnostico()+        "' , "
//                + " '" + lau.getData_consulta()+             "' , "
                + "  " + lau.getPaciente().getCodigo()+             " , "            
                + "  " + lau.getFuncionario().getCodigo()+             "  "            
                + " );";
        Conexao.executar(sql);
}
    public static void editar(ObjLaudo lau) {
        String sql = "UPDATE laudos SET "
                + " diagnostico = '" + lau.getDiagnostico()+                    "' , "
//                + " data_consulta = '" + lau.getData_consulta()+          "' , ";
                + " codPaciente = '" + lau.getPaciente().getCodigo()+           "' , "
                + " codFuncionario = '" + lau.getFuncionario().getCodigo()+           "'  "
                + " WHERE codigo = " + lau.getCodigo();

        Conexao.executar(sql);
    
    }
    public static void excluir(ObjLaudo lau) {
        String sql = "DELETE FROM laudos " + lau.getCodigo();
        Conexao.executar(sql);

    }
}
