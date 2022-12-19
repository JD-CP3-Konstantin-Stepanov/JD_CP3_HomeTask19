package Singleton;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    private final int filterMax;

    public Filter(int filterMax) {
        this.filterMax = filterMax;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем фильтрацию");

        List<Integer> result = new ArrayList<>();
        int cnt = 0;
        for (Integer integer : source) {
            if (integer >= filterMax) {
                logger.log("Элемент " + integer + " проходит");
                result.add(integer);
                cnt++;
            } else {
                logger.log("Элемент " + integer + " не проходит");
            }
        }
        logger.log("Прошло фильтр " + cnt + " элемента из " + source.size());
        return result;
    }
}
