package org.apache.java.mastering.bigo;

public class bigo {
    static String[] aarray = new String[]{"nemo", "pemo", "kemo"};
    static int[] aaray = new int[]{3,2,1,8,9};
    static String[] barray = new String[100000];
    public static boolean findnemo(String[] aarray) {
        boolean result = false;
        for (String ele : aarray) {
            if (ele.equals("pemo")) {
                result = true;
                break;
            }
            System.out.println(ele);
        }
        return result;
    }

    public static void bigOofnpower2(int[] aaray){
//        n power(2)
        for(int i =0;i<aaray.length;i++){
            for (int j = i ; j < aaray.length;j++){
                if(aaray[i]>aaray[j]){
                    int temp = aaray[j];
                    aaray[j] = aaray[i];
                    aaray[i] = temp;
                }
            }
        }
       System.out.println("Array print"+aaray);
        for (int ele : aaray) {
            System.out.println(ele);
        }
    }

    public static void main(String args[]) {
        System.out.println("Result "+findnemo(aarray));
        bigOofnpower2(aaray);
    }
}
