package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjCargo;

import model.ObjFuncionario;
import model.ObjSetor;

public class FuncionarioDAO {

    public static void inserir(ObjFuncionario fun) {

        String data = "" + fun.getNascimento().getYear() + "-" + (fun.getNascimento().getMonth() + 1) + "-" + fun.getNascimento().getDate();

        String sql = "INSERT INTO funcionarios "
                + " ( nome, sexo, cpf, rg, estado_civil, telefone, escolaridade, endereco, nacionalidade, nascimento, codCargo ) "
                + " VALUES ( "
                + " '" + fun.getNome() + "' , "
                + " '" + fun.getSexo() + "' , "
                + " '" + fun.getCpf() + "' , "
                + " '" + fun.getRg() + "' , "
                + " '" + fun.getEstado_civil() + "' , "
                + " '" + fun.getTelefone() + "' , "
                + " '" + fun.getEscolaridade() + "' , "
                + " '" + fun.getEndereco() + "' , "
                + " '" + fun.getNacionalidade() + "' , "
                + " '" + data + "' ,"
                + "  " + fun.getCargo().getCodigo()
                + " );";

        Conexao.executar(sql);
    }

    public static void editar(ObjFuncionario fun) {
        String sql = "UPDATE funcionarios SET "
                + " nome = '" + fun.getNome() + "' , "
                + " sexo = '" + fun.getSexo() + "' , "
                + " cpf = '" + fun.getCpf() + "' , "
                + " rg = '" + fun.getRg() + "' , "
                + " estado_civil = '" + fun.getEstado_civil() + "' , "
                + " telefone = '" + fun.getTelefone() + "' , "
                + " escolaridade = '" + fun.getEscolaridade() + "' , "
                + " endereco = '" + fun.getEndereco() + "' , "
                + " nacionalidade = '" + fun.getNacionalidade() + "' , "
                + " nascimento = '" + fun.getNascimento() + "' ,  "
                + " codCargo = " + fun.getCargo().getCodigo()
                + " WHERE codigo = " + fun.getCodigo();

        Conexao.executar(sql);

    }

    public static void excluir(ObjFuncionario fun) {
        String sql = "DELETE FROM funcionarios " + fun.getCodigo();
        Conexao.executar(sql);

    }
    public static List<ObjFuncionario> getMedicos(){
        List<ObjFuncionario> lista = new ArrayList<>();
        String sql = "SELECT f.codigo, f.nome, k.codigo, s.codigo "
                + "FROM funcionarios f "
                + "INNER JOIN cargos k ON f.codCargo = k.codigo "
                + "INNER JOIN setores s ON k.codSetor = s.codigo "
                + "WHERE codSetor = '1' "
                + "ORDER BY f.codigo";
        ResultSet rs = Conexao.consultar(sql);
        if(rs != null){
            try{
                while(rs.next()){
                    
                    ObjFuncionario fun = new ObjFuncionario();
                    fun.setCodigo(rs.getInt(1));
                    fun.setNome(rs.getString(2));
                    
                    ObjCargo cargo = new ObjCargo();
                    cargo.setCodigo(rs.getInt(3));
                    fun.setCargo(cargo);
                    
                    ObjSetor setor = new ObjSetor();
                    setor.setCodigo(rs.getInt(4));
                    
                    
                    
                    lista.add(fun);
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        return lista;
    }

    public static List<ObjFuncionario> getFuncionarios() {
        List<ObjFuncionario> lista = new ArrayList<>();
        String sql = "SELECT f.codigo, f.nome, "
                + " f.endereco, f.telefone, DATE_FORMAT(f.nascimento, '%d') AS DIA, DATE_FORMAT(f.nascimento, '%m') AS MES, DATE_FORMAT(f.nascimento, '%Y') AS ANO  , "
                + " f.sexo, f.cpf, f.rg, f.estado_civil, f.escolaridade, f.nacionalidade, k.codigo, k.nome    "
                + " FROM funcionarios f                                "
                + " INNER JOIN cargos k ON f.codCargo = k.codigo "
                + " ORDER BY f.nome";
        ResultSet rs = Conexao.consultar(sql);
        if (rs != null) {
            try {
                while (rs.next()) {

                    
                    

                    Date nascimento = new Date(rs.getInt(7), (rs.getInt(6) - 1), rs.getInt(5));

                    ObjFuncionario fun = new ObjFuncionario();
                    fun.setCodigo(rs.getInt(1));
                    fun.setNome(rs.getString(2));
                    fun.setTelefone(rs.getString(4));
                    fun.setEndereco(rs.getString(3));
                    fun.setNascimento(nascimento);
                    fun.setRg(rs.getString(10));
                    fun.setCpf(rs.getString(9));
                    fun.setSexo(rs.getInt(8));
                    fun.setEscolaridade(rs.getString(12));
                    fun.setEstado_civil(rs.getString(11));
                    fun.setNacionalidade(rs.getString(13));
                    
                    ObjCargo cargo = new ObjCargo();
                    cargo.setCodigo(rs.getInt(14));
                    cargo.setNome(rs.getString(15));
                    fun.setCargo(cargo);

                    lista.add(fun);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }

        return lista;
    }
    public static ObjFuncionario getSalarioByCargo(int codCargo){
        ObjFuncionario fun = new ObjFuncionario();
        String sql = "SELECT c.codigo, c.salario, f.codigo  "
                + " FROM funcionarios f "
                + " INNER JOIN cargos c ON f.codCargo = c.codigo "
                + " WHERE f.codigo = "+codCargo
                + " ORDER BY c.codigo ";
        
        System.out.println(sql);
        ResultSet rs = Conexao.consultar(sql);
        if(rs != null){
            try{
                rs.next();
                    ObjCargo cargo = new ObjCargo();
                    cargo.setCodigo(rs.getInt(1));
                    cargo.setSalario(rs.getDouble(2));
                    
                    
                    fun.setCodigo(rs.getInt(3));
                    fun.setCargo(cargo);
                
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
        return fun;
}
}

