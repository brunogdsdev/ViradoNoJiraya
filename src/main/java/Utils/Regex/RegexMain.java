package Utils.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMain {
    public static void main(String[] args) {
        // \d = todos os digitos
        // \D = tudo o que nao for digitos
        // \s = todos os espaćos em branco \t \n \f \r
        // \S = Todos os caracteres menos os em branco
        // \w = a-zA-Z, digitos,  _
        // \W = tudo o que nao for \w
        // [] = busca por range, [abc] vai buscar ou a ou b ou c
        // ? zero ou uma ocorrencia
        // * zero ou mais
        // + uma ou mais
        // {n,m} de n até m
        // () agrupamento
        // | ou o(v|c)o ovo | oco
        // $ fim da linha
        // ^ inicio da linha
        // . 1.3 = 123, 133, 103, 1A3

        String regex = "0[xX]([0-9a-fA-F])+(\\s|$)";
        String text = "12 0x 0xFFABC 0x10G 0x1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);


        while(matcher.find()){
            System.out.print(matcher.start()+" "+matcher.group() +"\n" );
        }

        System.out.println(text.matches(regex));

    }
}
