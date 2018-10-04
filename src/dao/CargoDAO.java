package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjCargo;
import model.ObjSetor;

public class CargoDAO {
    public static void inserir(ObjCargo car) {
        String sql = "INSERT INTO cargos "
                + " ( data_consulta, codPaciente, codFuncionario, codLaudo ) "
                + " VALUES ( "
                + " '" + car.getNome()+        "' , "
                + " '" + car.getSalario()+             "' , "
                + "  " + car.getSetor().getCodigo()+          "'  "
                + " );";
        Conexao.executar(sql);
}
    public static void editar(ObjCargo car) {
        String sql = "UPDATE cargos SET "
                + " '" + car.getNome()+        "' , "
                + " '" + car.getSalario()+             "' , "
                + " '" + car.getSetor().getCodigo()+          "' , "
                + " WHERE codigo = " + car.getCodigo();

        Conexao.executar(sql);
    
    }
    public static void excluir(ObjCargo car) {
        String sql = "DELETE FROM cargos " + car.getCodigo();
        Conexao.executar(sql);
}
    
    public static List<ObjCargo> getCargos(){
        List<ObjCargo> lista = new ArrayList<>();
        String sql = "SELECT c.codigo, s.codigo, c.nome, c.salario         "
                + "FROM cargos c                                           "
                + "INNER JOIN setores s ON c.codSetor = s.codigo           "
                + "ORDER BY c.nome ";
        ResultSet rs = Conexao.consultar(sql);
        
        if (rs != null){
            try {
                while (rs.next()){
                    ObjCargo car = new ObjCargo();
                    car.setCodigo(rs.getInt(1));
                    car.setNome(rs.getString(3));
                    car.setSalario(rs.getDouble(4));
                    ObjSetor set = new ObjSetor();
                    set.setCodigo(rs.getInt(2));
                    car.setSetor(set);
                    lista.add(car);
                            
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        return lista;
        
        }
    
//    public static List<ObjCargo> getSalarioByCargo (){
//        List<ObjCargo> lista = new ArrayList<>();
//        String sql = "SELECT codigo, salario "
//                + "FROM cargos "
//                + ""
//    }
    
    
}
