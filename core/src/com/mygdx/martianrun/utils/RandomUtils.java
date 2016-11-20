package com.mygdx.martianrun.utils;

import com.mygdx.martianrun.enums.EnemyType;

import java.util.Random;

/**
 * Created by hiro on 19/11/16.
 *
 *  to obtain random value from an enum
 *  RandomEnum class that  return a random value from a given enum
 */
public class RandomUtils {

    public static EnemyType getRandomEnemyType() {
        RandomEnum<EnemyType> randomEnum = new RandomEnum<EnemyType>(EnemyType.class);
        return randomEnum.random();
    }

    /**
     * @See [Stack Overflow](http://stackoverflow.com/a/1973018)
     * @param <E>
     */
    private static class RandomEnum<E extends Enum> {

        private static final Random RND = new Random();
        private final E[] values;

        public RandomEnum(Class<E> token){
            values = token.getEnumConstants();
        }

        public E random() {
            return  values[RND.nextInt(values.length)];
        }
    }
}
