import dominio.*;

import java.security.Principal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Curso curso1 = new Curso();
        curso1.setTitulo("curso Java");
        curso1.setDescricao("Descrição curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso Java");
        curso2.setDescricao("Descrição curso Js");
        curso2.setCargaHoraria(8);

        Conteudo conteudo = new Curso();
        Conteudo conteudo1 = new Mentoria();

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição mentoria Java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos João:" + devJoao.getConteudoInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("-");
        System.out.println("Conteudos Inscritos João:" + devJoao.getConteudoInscritos());
        System.out.println("Conteudos Concluidos João:" + devJoao.getConteudoInscritos());
        System.out.println("XP:" + devJoao.calcularTotalXp());

        System.out.println("----------");

        Dev devAna = new Dev();
        devAna.setNome("Ana");
        devAna.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos Ana:" + devAna.getConteudoInscritos());
        devAna.progredir();
        System.out.println("-");
        System.out.println("Conteudos Inscritos Ana:" + devAna.getConteudoInscritos());
        System.out.println("Conteudos Concluidos Ana:" + devAna.getConteudoInscritos());
        System.out.println("XP:" + devAna.calcularTotalXp());
    }

}
