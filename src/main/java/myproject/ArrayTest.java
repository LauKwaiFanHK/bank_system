package myproject;

import org.apache.commons.lang3.ArrayUtils;

public class ArrayTest {
public static final void main(String[] args) {
int[] array = new int[0];
array = ArrayUtils.add(array, 5);
System.out.println(ArrayUtils.toString(array));
}
}



