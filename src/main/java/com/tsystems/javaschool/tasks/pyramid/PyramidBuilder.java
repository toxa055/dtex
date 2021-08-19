package com.tsystems.javaschool.tasks.pyramid;

import java.util.Collections;
import java.util.List;

public class PyramidBuilder {

    /**
     * Builds a pyramid with sorted values (with minumum value at the top line and maximum at the bottom,
     * from left to right). All vacant positions in the array are zeros.
     *
     * @param inputNumbers to be used in the pyramid
     * @return 2d array with pyramid inside
     * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build with given input
     */
    public int[][] buildPyramid(List<Integer> inputNumbers) {
        if ((inputNumbers == null) || inputNumbers.isEmpty() || inputNumbers.contains(null)) {
            throw new CannotBuildPyramidException();
        }

        double triangularNumber = (Math.sqrt(8 * inputNumbers.size() + 1) - 1) / 2;
        if (triangularNumber % 1 != 0) {
            throw new CannotBuildPyramidException();
        }

        Collections.sort(inputNumbers);

        int innerArrayCount = (int) triangularNumber;
        int innerArraySize = innerArrayCount * 2 - 1;
        int[][] pyramid = new int[innerArrayCount][innerArraySize];

        int count = 1;
        for (int i = 1; i <= innerArrayCount; i++) {
            count += i + 1;
            pyramid[i - 1] = fillInnerArray(inputNumbers, innerArraySize, i, count);
        }

        return pyramid;
    }

    private int[] fillInnerArray(List<Integer> list, int arraySize, int elementCount, int count) {
        int[] array = new int[arraySize];
        int indexOfCentralElement = arraySize / 2;
        if (elementCount == 1) {
            array[indexOfCentralElement] = list.get(0);
        } else {
            int indexOfFirstElement = indexOfCentralElement - elementCount + 1;
            for (int i = 0, j = elementCount; (i < arraySize) && (j > 0); i += 2, j--) {
                array[indexOfFirstElement + i] = list.get(count - elementCount - j - 1);
            }
        }
        return array;
    }
}
