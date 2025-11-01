package behavior;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateMain01 {
    private static List<Car> cars = List.of(
            new Car("green", 2011),
            new Car("black", 2001),
            new Car("red", 2025)
    );


    public static void main(String[] args) {

        List<Car> greens = filter(cars, new CarPredicate(){
            @Override
            public boolean test(Car car){
                return car.getColor().equals("green");
            }
        });

        System.out.println(greens);


        List<Car> reds = filter(cars, (car) -> {
            return car.getColor().equals("red");
        });

        List<Car> olds = filter(cars, car -> car.getYear() <= 2015);

        System.out.println(reds);
        System.out.println(olds);


        System.out.println("===================================");


        List<Integer> nums = List.of(1,2,3,4,5);
        List<Integer> r = genericFilterPredicate(nums, n -> n %2  == 0);
        System.out.println(r);

    }




    private static List<Car> filter(List<Car> cars, CarPredicate carPredicate){
        List<Car> greenCars = new ArrayList<>();

        for (Car car : cars) {
            if(carPredicate.test(car)){
                greenCars.add(car);
            }
        }
        return greenCars;
    }


    private static <T> List<T> genericFilterPredicate(List<T> list, Predicate<T> predicate){
        List<T> filtered = new ArrayList<>();

        for(T item : list){
            if(predicate.test(item)){
                filtered.add(item);
            }
        }

        return filtered;
    }


}
