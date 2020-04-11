package tree;

import team.mk.DataStructure.Tree.Tree;

import java.util.Random;

/**
 * @Auther: Saul
 * @Date: 11/4/20 21:03
 * @Description:
 */
public class DataGenerator {

    private int idNext = 1;

    enum Operation{
        INSERTION, DELETION, UPDATE, SEARCH
    }

    public Element genElement(){
        return new Element(idNext++);

    }

    /***
     * @Author Saul
     * @Description  TODO: \
     * @Date 21:44 11/4/20
     * @param count the number of elements
     * @return {@link {@link tree.DataGenerator.Element[]}}
     */
    public Element[] genElements(int count){
        Element[] elements = new Element[count];
        while (count-- > 0){
            elements[count] = genElement();
        }
        return elements;
    }

    /***
     * @Author Saul
     * @Description  TODO:
     * @Date 21:25 11/4/20
     * @param counts the number of operations that each type of operation need to be generated
     * @return {@link {@link Operation[]}}
     */
    public Operation[] genOperations(int[] counts){

        int total = 0;
        for (int value : counts) {
            total += value;
        }

        Random random = new Random();

        Operation[] operations = new Operation[total];
        int randomNumber;
        int count = 0;

        while (count < total){
            randomNumber = random.nextInt(total);
            if (randomNumber < counts[0]){
                operations[count++] = Operation.INSERTION;
            }else if (randomNumber < counts[0] + counts[1]){
                operations[count++] = Operation.DELETION;
            }else if(randomNumber < counts[0] + counts[1] + counts[2]){
                operations[count++] = Operation.UPDATE;
            }else {
                operations[count++] = Operation.SEARCH;
            }
        }
        return operations;
    }


    public static int keyGenerator(){
        Random random = new Random();
        return random.nextInt((int) Math.pow(10, 7) + 1);
    }

    public void testPerformanceOfTree(Tree<Element> tree, int[] counts) throws Exception {
        int total = 0;
        for (int count : counts) {
            total += count;
        }

        Element[] elements = genElements(total);
        Operation[] operations = genOperations(counts);
        int insertion = 0, deletion = 0, update = 0, search = 0;

        long startTime1 = System.currentTimeMillis();

        for (int i = 0; i < elements.length; i++){
            if (operations[i] == Operation.INSERTION){
                tree.insert(elements[i]);
                insertion++;
            }else if(operations[i] == Operation.DELETION){
                tree.remove(elements[i]);
                deletion++;
            }else if(operations[i] == Operation.UPDATE){
                tree.update(elements[i]);
                update++;
            }else {
                tree.contains(elements[i]);
                search++;
            }
        }
        long endTime1 = System.currentTimeMillis();
        long totalTime1 = endTime1 - startTime1;

        System.out.println("INSERTION --> " + insertion + ", DELETION --> " + deletion +
                ", UPDATE--> " + update + ", SEARCH --> " + search);
        System.out.println("total time = " + totalTime1 + " ms");
    }





    static class Element implements Comparable<Element> {
        private int id;
        private int key;

    public Element(int id){
            this.id = id;
            this.key = keyGenerator();
        }

    public Element(){
            this.key = keyGenerator();
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "id=" + id +
                    ", key=" + key +
                    '}';
        }

        public int compareTo(Element o) {
            return this.key - o.key;
        }
    }

}
