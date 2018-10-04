package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjPaciente;

public class PacienteDAO {

    public static void inserir(ObjPaciente pac) {
        String data = "" + pac.getNascimento().getYear() + "-" + (pac.getNascimento().getMonth() + 1) + "-" + pac.getNascimento().getDate();
        String sql = "INSERT INTO pacientes "
                + " ( nome, telefone, endereco, nascimento, rg, sexo, estado_civil, plano_saude ) "
                + " VALUES ( "
                + " '" + pac.getNome() + "' , "
                + " '" + pac.getTelefone() + "' , "
                + " '" + pac.getEndereco() + "' , "
                + " '" + data + "' ,  "
                + " '" + pac.getRg() + "' , "
                + "  " + pac.getSexo() + " , "
                + " '" + pac.getEstado_civil() + "' , "
                + " '" + pac.getPlano_saude() + "'  "
                + " );";

        Conexao.executar(sql);
    }

    public static void editar(ObjPaciente pac) {
        String sql = "UPDATE pacientes SET "
                + " nome = '" + pac.getNome() + "' , "
                + " telefone = '" + pac.getTelefone() + "' , "
                + " endereco = '" + pac.getEndereco() + "' , "
                + " nascimento = '" + pac.getNascimento() + "' , "
                + " rg = '" + pac.getRg() + "' , "
                + " sexo = " + pac.getSexo() + " , "
                + " estado_civil = '" + pac.getEstado_civil() + "'   "
                + " WHERE codigo = " + pac.getCodigo();

        Conexao.executar(sql);
    }

    public static void excluir(ObjPaciente pac) {
        String sql = "DELETE FROM pacientes " + pac.getCodigo();
        Conexao.executar(sql);

    }

    public static List<ObjPaciente> getPaciente() {
        List<ObjPaciente> lista = new ArrayList<>();
        String sql = "SELECT p.codigo, p.nome, "
                + " p.endereco, p.telefone,   "
                + " DATE_FORMAT(p.nascimento, '%d') AS DIA, DATE_FORMAT(p.nascimento, '%m') AS MES, DATE_FORMAT(p.nascimento, '%Y') AS ANO  ,   "
                + " p.rg,    "
                + " p.estado_civil, p.plano_saude, p.sexo   "
                + " FROM pacientes p                                "
                + " ORDER BY p.nome";
        ResultSet rs = Conexao.consultar(sql);

        if (rs != null) {
            

            try {
               
                
                while (rs.next()) {
                    
                    Date nascimento = new Date(rs.getInt(7), (rs.getInt(6) - 1), rs.getInt(5));
                    
                    
                    ObjPaciente pac = new ObjPaciente();
                    pac.setCodigo(rs.getInt(1));
                    pac.setNome(rs.getString(2));
                    pac.setTelefone(rs.getString(4));
                    pac.setEndereco(rs.getString(3));
                    pac.setNascimento(nascimento);
                    pac.setRg(rs.getString(8));
                    pac.setSexo(rs.getInt(11));
                    pac.setEstado_civil(rs.getString(9));
                    pac.setPlano_saude(rs.getString(10));
                    lista.add(pac);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }

        }

        return lista;

    }

    public static Object getPacienteByCodigo(int codigo) {
        Object paciente = null;
        String sql = "SELECT p.codigo, p.nome, "
                + " p.endereco, p.telefone,   "
                + " DATE_FORMAT(p.nascimento, '%d') AS DIA, DATE_FORMAT(p.nascimento, '%m') AS MES, DATE_FORMAT(p.nascimento, '%Y') AS ANO  ,   "
                + " p.rg,    "
                + " p.estado_civil, p.plano_saude, p.sexo   "
                + " FROM pacientes p                                "
                + " WHERE p.codigo  = " + codigo
                + " ORDER BY p.nome";
        ResultSet rs = Conexao.consultar(sql);
        try {
            rs.first();

            
            Date nascimento = new Date(rs.getInt(7), (rs.getInt(6) - 1), rs.getInt(5));

            ObjPaciente pac = new ObjPaciente();
                    pac.setCodigo(rs.getInt(1));
                    pac.setNome(rs.getString(2));
                    pac.setTelefone(rs.getString(4));
                    pac.setEndereco(rs.getString(3));
                    pac.setNascimento(nascimento);
                    pac.setRg(rs.getString(8));
                    pac.setSexo(rs.getInt(11));
                    pac.setEstado_civil(rs.getString(9));
                    pac.setPlano_saude(rs.getString(10));
                    
            paciente = pac;

        } catch (Exception e) {

        }

        return paciente;
    }
}
