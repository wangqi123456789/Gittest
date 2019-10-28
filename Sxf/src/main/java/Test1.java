public class Test1 {

    public static class MStack<T> {
        Test.MArray<T> al = new Test.MArray();
        //入口

        public void push(T data){
            al.add(data);
        }
        //出口

        public T pop(){
            return al.remove(0);
        }
        //大小

        public int size(){
            return al.getSize();
        }

        public static void main(String[] args) {
            MStack stack = new MStack();
            System.out.println(stack.size());
            stack.push("12345");
            stack.push("22345");
            stack.push("32345");
            stack.push("42345");
            stack.push("52345");
            System.out.println(stack.size());
            stack.push("62345");
            stack.push("72345");
            stack.push("82345");
            stack.push("92345");
            stack.push("02345");

            System.out.println(stack.size());
            System.out.println(stack.pop());
            System.out.println(stack.size());
            System.out.println(stack.pop());
            System.out.println(stack.size());
        }
    }

}
