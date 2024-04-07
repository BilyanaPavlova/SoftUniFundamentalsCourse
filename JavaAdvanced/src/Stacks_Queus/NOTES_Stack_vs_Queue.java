package Stacks_Queus;

import java.util.*;
import java.util.stream.Collectors;

public class NOTES_Stack_vs_Queue {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //stack.push() - arranges the element so that the last-in is first-out
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(12);
        stack.push(13);
        stack.push(14);

        System.out.println(stack.pop()); // 14 - index 0 - at the top(start) of the stack
        System.out.println(stack.pop()); // 13 - index 1 - bellow the 0 index
        System.out.println(stack.pop()); // 12 - index 2 - at the bottom (end) of the stack

        // 14 13 12  - fills from the left (from the top) (from the start) ->
        // 0  1  2   - always takes out from the top/left/zero index
        // start - end
        // top -   bottom

        //queue.offer() - arranges the element so that the first-in is first-out
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(12);
        queue.offer(13);
        queue.offer(14);

        System.out.println(queue.poll()); // 12 - index 0 - at the top(start) of the stack
        System.out.println(queue.poll()); // 13 - index 1 - bellow the 0 index
        System.out.println(queue.poll()); // 14 - index 2 - at the bottom (end) of the stack

        // 12 13 14  - fills from the left or from the bottom  <-
        // 0  1  2
        // start - end
        // top -   bottom
        // always takes from the top/left/zero index - queue.poll

        // винаги се взима от индекс 0 / от ляво
        // разликата е, че стака пълни отляво и избутва надясно
        //, а кюто пълни отдясно и избутва наляво

    /*Exception Handling:

add and remove throw exceptions (specifically IllegalStateException or NoSuchElementException) if the operation cannot be performed.
offer and poll return a boolean or null to indicate success or failure without throwing exceptions.

In general, if you are working with a Stack, it's recommended to use push and pop for clarity.
For a Queue, you can use offer
and poll for non-throwing behavior or add and remove if you want exceptions to be thrown on failure.*/

        PriorityQueue<Integer> queue1 = new PriorityQueue<>(Collections.reverseOrder());
        //poslednite stawat pyrwi - obrushta reda - komparator (srawnyawa 2 obekta)
        // primerno srawnqwa studenti po ocenka i wadi naj-wisokite ocenki pyrwi

        // Rule:
        // PriorityQueue -> higher priority elements are pushed to the beginning of the queue
        // lower priority are pushed to the end of the queue

        //четене от конзолата чрез стрийм и наливане на данните в един стек:
        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stack::push);

        // първия ред - пускаме стрийм и скенера ги пълни като стрингове във стрийм
        // втори ред - оревърщаме ги в интегери
        // всеки един го пушваме в стек

        //четене от конзолата, наливане в масив и после с фор цикъл ги пълним в стек/опашка
        int [] array = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt) //ползваме mapToInt, иначе ги мапва към Oject[]
                .toArray();
        Deque<Integer> q = new ArrayDeque<>();
        for (int el: array){
            q.offer(el);
        }

        //четене от конзолата и наливане в лист
        List<String> list = Arrays.stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        //и после с фор цикъл ги пълним в стек/опашка...

        // команди
        Collections.max(stack); // връща максимума от стека
        Collections.min(stack); // връща минимума от стека
      //  Collections.addAll(stack, toSOmeLIst);

        Collections.max(queue); // връща максимума от опашката
        Collections.min(queue); // връща минимума от опашката

         //четене на число от стак
        Integer.valueOf(stack.pop());
    }
}
