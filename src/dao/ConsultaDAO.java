
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjConsulta;
import model.ObjFuncionario;
import model.ObjLaudo;
import model.ObjPaciente;


public class ConsultaDAO {
    public static void inserir(ObjConsulta con) {
        
        String data = "" + con.getData_consulta().getYear() + "-" + (con.getData_consulta().getMonth() + 1) + "-" + con.getData_consulta().getDate();
        String sql = "INSERT INTO consultas "
                + " ( data_consulta, codPaciente, codFuncionario ) "
                + " VALUES ( "
                + " '" + data +        "' , "
                + "  " + con.getPaciente().getCodigo()+             " , "
                + "  " + con.getFuncionario().getCodigo()+          "  "
                       
                + " );";
        
        Conexao.executar(sql);
        
        
}
    public static void editar(ObjConsulta con) {
        String sql = "UPDATE consultas SET "
                + " data_consulta = " + con.getData_consulta()+   " , "
                + " codPaciente = " + con.getPaciente().getCodigo()+             "  , "
                + " codFuncionario = " + con.getFuncionario().getCodigo()+       "  , "
                + " laudo = '" + con.getLaudo() +                   "'    "                
                + " WHERE codigo = "+con.getCodigo();
        Conexao.executar(sql);
}
    
    public static void editarLaudo(ObjConsulta con) {
        String sql = "UPDATE consultas SET "
                + " laudo = '" + con.getLaudo() + "'    "                
                + " WHERE codigo = "+con.getCodigo();
        Conexao.executar(sql);
}
    public static void excluir(ObjConsulta con) {
        String sql = "delete from consultas where codigo = " + con.getCodigo();
        Conexao.executar(sql);

    }
    public static List<ObjConsulta> getConsultas() {
        List<ObjConsulta> lista = new ArrayList<>();
        String sql = "SELECT c.codigo, p.codigo, f.codigo, c.laudo, "
                + " DATE_FORMAT(c.data_consulta, '%d') AS DIA, DATE_FORMAT(c.data_consulta, '%m') AS MES, DATE_FORMAT(c.data_consulta, '%Y') AS ANO  ,  "
                + " p.nome, p.sexo, p.plano_saude, f.nome "
                + " FROM consultas c                                "
                + " INNER JOIN pacientes p ON c.codPaciente = p.codigo "
                + " INNER JOIN funcionarios f ON c.codFuncionario = f.codigo "
//                + " INNER JOIN laudos l ON c.codLaudo = l.codigo "
                + " ORDER BY p.nome";
        ResultSet rs = Conexao.consultar(sql);

        if (rs != null) {

            try {
                ObjConsulta con = new ObjConsulta();
                con.setCodigo(rs.getInt(1));
                
                ObjFuncionario fun = new ObjFuncionario();
                fun.setCodigo(rs.getInt(3));
                fun.setNome(rs.getString(11));
                con.setFuncionario(fun);
                
                ObjPaciente pac = new ObjPaciente();
                pac.setCodigo(rs.getInt(2));
                pac.setNome(rs.getString(8));
                pac.setSexo(rs.getInt(9));
                pac.setPlano_saude(rs.getString(10));
                con.setPaciente(pac);
                
//                ObjLaudo lau = new ObjLaudo();
//                lau.setCodigo(rs.getInt(4));
//                con.setLaudo(lau);

                con.setLaudo(rs.getString(4));
                
                Date data_consulta = new Date(rs.getInt(7), (rs.getInt(6) - 1), rs.getInt(5)); 
                con.setData_consulta(data_consulta);
                
                
                
                
                lista.add(con);
                

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        return lista;
    }    
    
    
    public static List<ObjConsulta> getConsultasByMedicoID(int codMedico) {
        List<ObjConsulta> lista = new ArrayList<>();
        String sql = "SELECT c.codigo, p.codigo, f.codigo, c.codigo, "
                + " DATE_FORMAT(c.data_consulta, '%d') AS DIA, DATE_FORMAT(c.data_consulta, '%m') AS MES, DATE_FORMAT(c.data_consulta, '%Y') AS ANO  ,  "
                + " p.nome, p.sexo, p.plano_saude, f.nome, "
                + " DATE_FORMAT(f.nascimento, '%d') AS DIA, DATE_FORMAT(f.nascimento, '%m') AS MES, DATE_FORMAT(f.nascimento, '%Y') AS ANO "
                + " FROM consultas c                                "
                + " INNER JOIN pacientes p ON c.codPaciente = p.codigo "
                + " INNER JOIN funcionarios f ON c.codFuncionario = f.codigo "
//                + " INNER JOIN laudos l ON c.codLaudo = l.codigo "
                + " WHERE c.codFuncionario = " + codMedico
                + " ORDER BY p.nome";
        ResultSet rs = Conexao.consultar(sql);
        System.out.println(sql);
        if (rs != null) {

            try {
                rs.next();
                ObjConsulta con = new ObjConsulta();
                con.setCodigo(rs.getInt(1));
                
                ObjFuncionario fun = new ObjFuncionario();
                fun.setCodigo(rs.getInt(3));
                fun.setNome(rs.getString(11));
                con.setFuncionario(fun);
                
                ObjPaciente pac = new ObjPaciente();
                pac.setCodigo(rs.getInt(2));
                pac.setNome(rs.getString(8));
                pac.setSexo(rs.getInt(9));
                pac.setPlano_saude(rs.getString(10));
                Date nascimento = new Date(rs.getInt(14), (rs.getInt(13) - 1), rs.getInt(12));
                pac.setNascimento(nascimento);
                con.setPaciente(pac);
                
//                ObjLaudo lau = new ObjLaudo();
//                lau.setCodigo(rs.getInt(4));
//                con.setLaudo(lau);
                
                Date data_consulta = new Date(rs.getInt(7), (rs.getInt(6) - 1), rs.getInt(5)); 
                con.setData_consulta(data_consulta);
                
                
                
                
                lista.add(con);
                

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        return lista;
    } 
    
//    public static ObjConsulta getLaudoByConsulta (int codigo){
//        ObjConsulta con = new ObjConsulta();
//        String sql = "SELECT c.codigo, p.nome, l.codigo, l.diagnostico "
//                + " DATE_FORMAT(c.data_consulta, '%d') AS DIA, DATE_FORMAT(c.data_consulta, '%m') AS MES, DATE_FORMAT(c.data_consulta, '%Y') AS ANO  ,  "
//                + " FROM consultas c "
//                + " INNER JOIN laudos l ON c.codLaudo = l.codigo "
//                + " INNER JOIN pacientes p ON c.codPaciente = p.codigo "
//                + " WHERE c.codigo = " + codigo
//                ;
//        ResultSet rs = Conexao.consultar(sql);
//        
//        if (rs != null){
//            try{
//                rs.first();
//                con.setCodigo(rs.getInt(1));
//                
//                ObjLaudo lau = new ObjLaudo();
//                lau.setCodigo(rs.getInt(3));
//                lau.setDiagnostico(rs.getString(4));
//                con.setLaudo(lau);
//                
//                ObjPaciente pac = new ObjPaciente();
//                pac.setNome(rs.getString(2));
//                con.setPaciente(pac);
//                
//                        
//                Date data_consulta = new Date(rs.getInt(7), (rs.getInt(6) - 1), rs.getInt(5)); 
//                con.setData_consulta(data_consulta);        
//                
//                
//            }catch( Exception e){
//                JOptionPane.showMessageDialog(null, e.toString());
//            }
//        }
//        return con;
//    }
    
    public static ObjConsulta getConsultaByCodigo (int codigo){
        ObjConsulta con = new ObjConsulta();
        String sql = "SELECT c.codigo, p.nome, c.laudo , "
                + " DATE_FORMAT(c.data_consulta, '%d') AS DIA, DATE_FORMAT(c.data_consulta, '%m') AS MES, DATE_FORMAT(c.data_consulta, '%Y') AS ANO    "
                + " FROM consultas c "
                + " INNER JOIN pacientes p ON c.codPaciente = p.codigo "
                + " WHERE c.codigo = " + codigo
                ;
        ResultSet rs = Conexao.consultar(sql);
        
        if (rs != null){
            try{
                rs.first();
                con.setCodigo(rs.getInt(1));
                con.setLaudo( rs.getString(3));
               
                
                ObjPaciente pac = new ObjPaciente();
                pac.setNome(rs.getString(2));
                con.setPaciente(pac);
                
                
                
                        
                Date data_consulta = new Date(rs.getInt(6), (rs.getInt(5) - 1), rs.getInt(4)); 
                con.setData_consulta(data_consulta);        
                
                
            }catch( Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        return con;
    }
    
}


