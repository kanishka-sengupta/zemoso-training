package coursera.SolvingProblemsWithSoftware.Week_2;

public class Test {
    public void findAbc(String input) {
        int index = input.indexOf("abc");
        while (true) {
            if (index == -1) {
                break;
            }
            if(index >= input.length() - 3)
                break;
            System.out.print("Index" + index);
            String found = input.substring(index+1, index+4);
            System.out.println(found);
            index = input.indexOf("abc", index+3);
            System.out.println("index after updating " + index);
        }
    }
    public void test() {
        //no code yet
        findAbc("abcabcabcabca");
        System.out.println();
        findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
    }

    public static void main(String[] args) {
        Test test=new Test();
        test.test();
    }
}
