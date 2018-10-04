package dao;

import model.ObjSetor;

public class SetorDAO {
    public static void inserir(ObjSetor set) {
        String sql = "INSERT INTO setores "
                + " ( nome ) VALUES "
                + " ( '" + set.getNome() + "' );";
        Conexao.executar(sql);
    }
    public static void editar(ObjSetor set) {
        String sql = "UPDATE setores SET "
                + " '" + set.getNome()+        "' , "
                + " WHERE codigo = " + set.getCodigo();

        Conexao.executar(sql);
    
    }
    public static void excluir(ObjSetor set) {
        String sql = "DELETE FROM setores " + set.getCodigo();
        Conexao.executar(sql);
}
}
