/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrocriptohash.repository;

import cadastrocriptohash.model.PessoaEntity;
import cadastrocriptohash.util.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author victor
 */
public class PessoaRep extends PessoaEntity {
    private static final String INSERT = "insert into pessoas (nome, cpf, rg, cep, endereco, numero, bairro, complemento, municipio, uf) values (?,?,?,?,?,?,?,?,?,?);";

    private static final String SELECT = "select id, nome, cpf, rg, cep, endereco, numero, bairro, complemento, municipio, uf from pessoas order by id";

    private static final String DELETE = "delete from pessoas where id = ?";

    private static final String UPDATE = "update pessoas set nome = ?, cpf = ?, rg = ?, cep = ?, endereco = ?, numero = ?, bairro = ?, complemento = ?, municipio = ?, uf  = ? where id = ?";
    
    private Connection connection = ConexaoBanco.conectarBanco();
    private PreparedStatement pstm;
    
    public void adicionar(PessoaEntity pessoas) {
        
        try {
            
            pstm = connection.prepareStatement(INSERT);
            
            pstm.setString(1, pessoas.getNome());
            pstm.setString(2, pessoas.getCpf());
            pstm.setString(3, pessoas.getRg());
            pstm.setString(4, pessoas.getCep());
            pstm.setString(5, pessoas.getEndereco());
            pstm.setString(6, pessoas.getNumero());
            pstm.setString(7, pessoas.getBairro());
            pstm.setString(8, pessoas.getComplemento());
            pstm.setString(9, pessoas.getMunicipio());
            pstm.setString(10, pessoas.getUf());
            pstm.execute();
            pstm.close();
        
            System.out.println("Concluido!");
            JOptionPane.showMessageDialog(null," Cadastrado com sucesso! ");

        }catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar Cadastrar: " + ex.getMessage());
        }
    }
    public void alterar(PessoaEntity pessoas) {
        
        try {
            
            pstm = connection.prepareStatement(UPDATE);
            
            pstm.setString(1, pessoas.getNome());
            pstm.setString(2, pessoas.getCpf());
            pstm.setString(3, pessoas.getRg());
            pstm.setString(4, pessoas.getCep());
            pstm.setString(5, pessoas.getEndereco());
            pstm.setString(6, pessoas.getNumero());
            pstm.setString(7, pessoas.getBairro());
            pstm.setString(8, pessoas.getComplemento());
            pstm.setString(9, pessoas.getMunicipio());
            pstm.setString(10, pessoas.getUf());
            pstm.setInt(11, pessoas.getId());
            pstm.execute();
            pstm.executeUpdate();
            pstm.close();
            
            
            System.out.println("Concluido!");
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");

        }catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }
    }
    public void excluir(PessoaEntity pessoas) {
        try {
            pstm = connection.prepareStatement(DELETE);
            pstm.setInt(1, pessoas.getId());
            pstm.executeUpdate();
            
            System.out.println("Concluido!");
            JOptionPane.showMessageDialog(null,"Deletado!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar deletar: " + ex.getMessage());
        }

    }

    public java.util.List<PessoaEntity> listar() {
        java.util.List<PessoaEntity> pessoas = new ArrayList<>();
        ResultSet res;
        
        try {
            pstm = connection.prepareStatement(SELECT);
            
            res = pstm.executeQuery();

            while (res.next()) {
                PessoaEntity p = new  PessoaEntity();
                p.setId(res.getInt("id"));
                p.setNome(res.getString("nome"));
                p.setCpf(res.getString("cpf"));
                p.setRg(res.getString("rg"));
                p.setCep(res.getString("cep"));
                p.setEndereco(res.getString("endereco"));
                p.setNumero(res.getString("numero"));
                p.setBairro(res.getString("bairro"));
                p.setComplemento(res.getString("complemento"));
                p.setMunicipio(res.getString("municipio"));
                p.setUf(res.getString("uf"));
                           
                pessoas.add(p);
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar buscar a lista do banco: " + ex.getMessage());
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar buscar a lista no banco: " + ex.getMessage());
        }
        return pessoas;
    }
    
    public ArrayList<PessoaEntity> listarPorNome(String nome) {
        ArrayList<PessoaEntity> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement("SELECT * FROM pessoas where nome LIKE '%"+nome+"%'");
             res = pstm.executeQuery();
             while (res.next()) {
                PessoaEntity p = new  PessoaEntity();
                p.setId(res.getInt("id"));
                p.setNome(res.getString("nome"));
                p.setCpf(res.getString("cpf"));
                p.setRg(res.getString("rg"));
                p.setCep(res.getString("cep"));
                                
                lista.add(p);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar esta pessoa no banco: " + ex.getMessage());
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar buscar esta pessoa no banco: " + ex.getMessage());
        }
        return lista;
    }
    
    public ArrayList<PessoaEntity> listarPorNomeDA(String nome) {
        ArrayList<PessoaEntity> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement("SELECT * FROM pessoas where nome LIKE '%"+nome+"%'");
             res = pstm.executeQuery();
             while (res.next()) {
                PessoaEntity p = new  PessoaEntity();
                p.setId(res.getInt("id"));
                p.setNome(res.getString("nome"));
                p.setCpf(res.getString("cpf"));
                p.setRg(res.getString("rg"));
                p.setCep(res.getString("cep"));
                p.setEndereco(res.getString("endereco"));
                p.setNumero(res.getString("numero"));
                p.setComplemento(res.getString("complemento"));
                p.setMunicipio(res.getString("municipio"));
                p.setUf(res.getString("uf"));
                p.setBairro(res.getString("bairro"));
                
                lista.add(p);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar esta pessoa no banco: " + ex.getMessage());
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar buscar esta pessoa no banco: " + ex.getMessage());
        }
        return lista;
    }
    
    public ArrayList<PessoaEntity> listarPorCPF(String cpf) {
        ArrayList<PessoaEntity> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement("SELECT * FROM pessoas where cpf LIKE '%"+cpf+"%'");
             res = pstm.executeQuery();
             while (res.next()) {
                PessoaEntity p = new  PessoaEntity();
                
                p.setId(res.getInt("id"));
                p.setNome(res.getString("nome"));
                p.setCpf(res.getString("cpf"));
                p.setRg(res.getString("rg"));
                p.setCep(res.getString("cep"));
                                               
                lista.add(p);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar Este CPF no banco: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar buscar Este CPF no banco: " + ex.getMessage());
        }
        return lista;
    }
    public ArrayList<PessoaEntity> listarPorCPFDA(String cpf) {
        ArrayList<PessoaEntity> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement("SELECT * FROM pessoas where cpf LIKE '%"+cpf+"%'");
             res = pstm.executeQuery();
             while (res.next()) {
                PessoaEntity p = new  PessoaEntity();
                
                p.setId(res.getInt("id"));
                p.setNome(res.getString("nome"));
                p.setCpf(res.getString("cpf"));
                p.setRg(res.getString("rg"));
                p.setCep(res.getString("cep"));
                p.setEndereco(res.getString("endereco"));
                p.setNumero(res.getString("numero"));
                p.setComplemento(res.getString("complemento"));
                p.setMunicipio(res.getString("municipio"));
                p.setUf(res.getString("uf"));
                p.setBairro(res.getString("bairro"));
                               
                lista.add(p);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar Este CPF no banco: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar buscar Este CPF no banco: " + ex.getMessage());
        }
        return lista;
    }
        
}
