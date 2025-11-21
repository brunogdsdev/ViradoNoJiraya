package serialization;

import java.io.*;

public class Aluno implements Serializable {
    //    ctrl shift A e busque por serializable class without serialVersionUID pra habilitar
//    alt enter e escolhe a općao que remove o warning e adiciona o uid
    @Serial
    private static final long serialVersionUID = 921371471981973800L;



    private long id;
    private String nome;
    private transient String password;
    public static final String NOME_ESCOLA = "Vicente Monteiro"; //

    private transient Turma turma;

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Serial
    private void writeObject(ObjectOutputStream oos){
        try{
            oos.defaultWriteObject();
            oos.writeUTF(turma.getNome());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Serial
    private void readObject(ObjectInputStream ois){
        try{
            ois.defaultReadObject();
            String nome = ois.readUTF();
            turma = new Turma(nome);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }





    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                ", NOME_ESCOLA='" + NOME_ESCOLA + '\'' +
                ", Turma='" + turma + '\'' +
                '}';
    }

    public Aluno(long id, String nome, String password) {
        this.id = id;
        this.nome = nome;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
