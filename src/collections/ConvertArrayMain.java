package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertArrayMain {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(2);
        nums.add(3);

        Integer[] ints = nums.toArray(new Integer[0]);
        System.out.println(Arrays.toString(ints)+ " --- "+ ints[0]);

        Integer[] numeros = new Integer[3];

        numeros[0] = 1;
        numeros[1] = 2;
        numeros[2] = 3;

        List<Integer> arrayToList = Arrays.asList(numeros); // dessa forma o List vai ter um link com o array numeros, toda allteracao no List vai ser refletida no array
        // e se for  usado add, dará erro
//        arrayToList.add(19);
//        arrayToList.set(0, 12);

        System.out.println(arrayToList);
        System.out.println(arrayToList);

        System.out.println("------------------------------");
//        dessa forma será possível alterar o List sem alterar o array
        List<Integer> teste = new ArrayList<>(Arrays.asList(numeros));
        teste.add(19);
        System.out.println(teste);
        teste.set(0, 12);
        System.out.println(teste);

    }

}
