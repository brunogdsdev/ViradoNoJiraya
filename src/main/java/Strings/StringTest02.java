package Strings;

public class StringTest02 {
    public static void main(String[] args) {
        String nome = "Bruno";
        String nums = "012345";

        System.out.println(nome.charAt(0));
        System.out.println(nome.length());
        System.out.println(nome.replace("B","V"));
        System.out.println(nome.toLowerCase());
        System.out.println(nome.toUpperCase());
        System.out.println(nums.length());
        System.out.println(nums.substring(3));
        System.out.println(nums.substring(2,4)); // é exclusivo, entao pega o ultimo index -1
        System.out.println(nums.substring(3, nums.length())); // nao precisa do length, já pega até o fim sem informar nada
        System.out.println(nome.trim());

    }
}
