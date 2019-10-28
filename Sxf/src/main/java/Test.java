import java.util.Iterator;

public class Test {

    public static class MArray<T> implements Iterable<T>{
        private T[] Datas;
        private int Count;
        private final double G_S = 0.5;

        public MArray(){
            this(10);
        }

        public MArray(int size){
            this.init(size);
        }

        public void add(int index ,T data){
            if(index>Count){
                throw new ArrayIndexOutOfBoundsException("索引越界");
            }
            if(Count>=Datas.length) {
                this.growArray();
            }
            if(index==Count){
                Datas[Count++] = data;
            }else{
                System.arraycopy(Datas,index,Datas,index,Datas.length-index-1);
                Datas[index] = data;
                Count++;
            }
        }

        public void add(T data){
            this.add(Count,data);
        }

        public T remove(int index){
            T temp = Datas[index];
            System.arraycopy(Datas,index+1,Datas,index,Datas.length-index-1);
            Datas[--Count] = null;
            return temp;
        }

        public T get(int index){
            if(index>=Count){
                throw new ArrayIndexOutOfBoundsException("索引越界");
            }
            return Datas[index];
        }

        public void set(int index,T newData){
            if(index>=Count){
                throw new ArrayIndexOutOfBoundsException("索引越界");
            }
            this.Datas[index] = newData;

        }

        public void clean(){
            this.init(10);
        }

        public boolean isEmpty(){
            return this.Count == 0;
        }


        public int getSize(){
            return this.Count;
        }

        private void growArray(){
            int newLength = Datas.length+(int)(Datas.length*G_S)+1;
            T[] temps = (T[])new Object[newLength];
            System.arraycopy(Datas,0,temps,0,Datas.length);
            Datas = temps;
            Runtime.getRuntime().gc();
        }

        private void init(int size){
            Datas = (T[])new Object[size];
            Count = 0;
        }

        public String toString(){
            StringBuilder builder = new StringBuilder("[");
            for (int index = 0; index < this.Count; index++) {
                if (index==this.Count-1){
                    builder.append(Datas[index]+"]");
                }else {
                    builder.append(Datas[index] + ",");
                }
            }
            return builder.toString();
        }

        public boolean equalsMyArray(MArray<T> arrs){
            if(arrs == null){
                return false;
            }
            if(arrs.getSize()!=this.Count){
                return false;
            }
            for (int index = 0; index < this.Count; index++) {
                if(!this.Datas[index].equals(arrs.get(index))){
                    return false;
                }
            }
            return true;
        }

        public Iterator<T> iterator() {
            return new MyIter();
        }

        //内部类
        private class MyIter implements Iterator<T>{
            //计数器-->指针 游标
            private int cursor;
            private int lastRet = -1;

            //判断是否存在下一个
            @Override
            public boolean hasNext() {
                return cursor!=Count;
            }

            //返回游标当前位置，并把游标移到下一位置
            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                if(!hasNext()) {
                    try {
                        throw new IndexOutOfBoundsException();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                lastRet = cursor;
                return (T)Datas[cursor++];
            }
            //删除游标左面元素，执行完next后只能执行一次
            @Override
            public void remove() {
                if(lastRet<0) {
                    try {
                        throw new IndexOutOfBoundsException();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.arraycopy(Datas,lastRet+1,Datas,lastRet,Count-lastRet-1);
                cursor = lastRet;
                lastRet = -1;
                Datas[--Count] = null;
            }
        }

        public boolean contains(Object o) {
            return indexOf(o)>=0;
        }

        public int indexOf(Object o) {
            for(int i=0;i<Count;++i) {
                if(Datas[i].equals(o))
                    return i;
            }
            return -1;
        }

        public static void main(String[] args) {
            MArray<String> strs = new MArray<>(2);
            strs.add("12345");
            strs.add("22345");
            strs.add("32345");
            strs.add("42345");
            strs.add("52345");
            strs.add("62345");
            strs.add("72345");
            strs.add("82345");
            strs.add("92345");
            strs.add("02345");
            System.out.println(strs);
            strs.set(1,"ABCDE");
            System.out.println(strs);
            System.out.println(strs.get(1));
            System.out.println(strs.remove(0));
            System.out.println(strs);
        }

    }

}
