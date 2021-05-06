/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrocriptohash.repository;

import cadastrocriptohash.model.UsuarioEntity;
import cadastrocriptohash.util.ConexaoBanco;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author victor
 */
public class UsuarioRep extends UsuarioEntity{
    private static final String INSERT = "insert into usuarios (login, senha) values (?,?);";

    private static final String SELECT = "select id, login, senha from usuarios order by id";

    private static final String DELETE = "delete from usuarios where id = ?";

    private static final String UPDATE = "update usuarios set login = ?, senha  = ? where id = ?";
    
    private Connection connection = ConexaoBanco.conectarBanco();
    private PreparedStatement pstm;
    
    public void adicionar(UsuarioEntity usuarios) {
        String senha = usuarios.getSenha();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));
                
            StringBuilder sb = new StringBuilder();
            
            for (byte b : messageDigest) {
                sb.append(String.format("%02X", 0xFF & b));
            }
            String senhaHex = sb.toString();
            usuarios.setSenha(senhaHex);
            pstm = connection.prepareStatement(INSERT);
            
            pstm.setString(1, usuarios.getLogin());
            pstm.setString(2, usuarios.getSenha());
            
            pstm.execute();
            pstm.close();
        
            System.out.println("Concluido!");
            JOptionPane.showMessageDialog(null,"Usuario Cadastrado!");

        }catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar cadastrar o usuario: " + ex.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioRep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UsuarioRep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void alterar(UsuarioEntity usuarios) {
        
        try {
            
            pstm = connection.prepareStatement(UPDATE);
            
            pstm.setString(1, usuarios.getLogin());
            pstm.setString(2, usuarios.getSenha());
            pstm.setInt(11, usuarios.getId());
            pstm.execute();
            pstm.executeUpdate();
            pstm.close();
            
            
            System.out.println("Concluido!");
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");

        }catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar alterar: " + ex.getMessage());
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar Alterar: " + ex.getMessage());
        }
    }
    public void excluir(UsuarioEntity usuarios) {
        try {
            pstm = connection.prepareStatement(DELETE);
            pstm.setInt(1, usuarios.getId());
            pstm.executeUpdate();
            
            System.out.println("Concluido!");
            JOptionPane.showMessageDialog(null,"Deletado!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar Deletar o usuario: " + ex.getMessage());
        }

    }

    public ArrayList<UsuarioEntity> listar() {
        ArrayList<UsuarioEntity> usuarios = new ArrayList<>();
        ResultSet res;
        
        try {
            pstm = connection.prepareStatement(SELECT);
            
            res = pstm.executeQuery();

            while (res.next()) {
                UsuarioEntity u = new  UsuarioEntity();
                u.setId(res.getInt("id"));
                u.setLogin(res.getString("login"));
                u.setSenha(res.getString("senha"));
    
                usuarios.add(u);
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os usuarios no banco: " + ex.getMessage());
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar buscar o usuario: " + ex.getMessage());
        }
        return usuarios;
    }
    
    public ArrayList<UsuarioEntity> listarPorID(int id) {
        ArrayList<UsuarioEntity> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement("SELECT * FROM usuarios where id LIKE '%"+id+"%'");
             res = pstm.executeQuery();
             while (res.next()) {
                UsuarioEntity u = new  UsuarioEntity();
                u.setId(res.getInt("id"));
                u.setLogin(res.getString("login"));
                u.setSenha(res.getString("senha"));

                lista.add(u);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar o usuario no banco: " + ex.getMessage());
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar buscar o usuario: " + ex.getMessage());
        }
        return lista;
    }
    
    public UsuarioEntity checarLogin(String Login,String Senha) {    
    
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;
        UsuarioEntity usuario = new UsuarioEntity();
        String senha = Senha;    
        try {
            
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));
                
            StringBuilder sb = new StringBuilder();
            
            for (byte b : messageDigest) {
                sb.append(String.format("%02X", 0xFF & b));
            }
            String senhaHex = sb.toString();
            
            stmt = connection.prepareStatement("SELECT * FROM usuarios WHERE login = ? and senha = ?");
            stmt.setString(1, Login);
            stmt.setString(2, senhaHex);

            rs = stmt.executeQuery();

            if (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setLogin(rs.getString("login"));
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar encontrar o usuario: " + ex.getMessage());
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar buscar o usuario: " + ex.getMessage());
        } catch (NoSuchAlgorithmException ex) { 
            Logger.getLogger(UsuarioRep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UsuarioRep.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
}
