public class SuperArray {

    private int[] nativeArray;
    private int size;

    SuperArray(){
        nativeArray = new int[100];
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public void removeElementByIndex(int index){
        size -= 1;
        int currentPosition = index;
        while(currentPosition < size){
            nativeArray[currentPosition] = nativeArray[currentPosition+1];
            currentPosition += 1;
        }

    }

    public void removeLastValue(){
        size = size-1;
    }

    public int getElementByIndex(int index){
        return nativeArray[index];
    }

    public void addItem(int item){
        if(size == nativeArray.length){
            int[] newNativeArray = new int[size*2];
            int contador = 0;
            while(contador < nativeArray.length){
                newNativeArray[contador] = nativeArray[contador];
                contador += 1;
            }
            this.nativeArray = newNativeArray;
        }

        nativeArray[size] = item;
        size = size + 1;
    }

}
