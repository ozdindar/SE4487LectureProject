package chapter6.leetcodequestions;

import java.security.KeyStore;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamQuestions {

    // 977. Squares of a Sorted Array
    public static int[] sortedSquares(int[] nums) {
        return IntStream.of(nums)
                .map(x->x*x)
                .sorted().toArray();
    }

    // 448. Find All Numbers Disappeared in an Array
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = IntStream.of(nums)
                .boxed().collect(Collectors.toCollection(HashSet::new));

        return IntStream.range(1,nums.length+1)
                .filter(x-> !set.contains(x) ).boxed().toList();

    }

    // 2032. Two Out of Three
    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        IntStream sNums1 = IntStream.of(nums1).distinct();
        IntStream sNums2 = IntStream.of(nums2).distinct();
        IntStream sNums3 = IntStream.of(nums3).distinct();

        return IntStream.concat(sNums1, IntStream.concat(sNums2,sNums3)).
                boxed()
                .collect(Collectors.groupingBy(x->x,Collectors.summingInt(x->1)))
                .entrySet()
                .stream()
                .filter(e->e.getValue()>=2)
                .map(Map.Entry::getKey).toList();

    }

    // 350. Intersection of Two Arrays II
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = IntStream.of(nums1)
                .boxed()
                .collect(Collectors.groupingBy(x->x,Collectors.summingInt(x->1)));
        Map<Integer,Integer> map2 = IntStream.of(nums2)
                .boxed()
                .collect(Collectors.groupingBy(x->x,Collectors.summingInt(x->1)));

        map1.forEach((k,v)-> map2.computeIfAbsent(k,x->0));
        map2.forEach((k,v)-> map1.computeIfAbsent(k,x->0));
        map1.forEach((k,v)->map2.merge(k,v,Math::min));

        return map2.entrySet()
                .stream()
                .flatMapToInt(
                        (e)->{
                            return IntStream.generate(e::getKey)
                                    .limit(e.getValue());
                        })
                .toArray();


    }

    //819. Most Common Wor
    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> sBanned= Arrays.stream(banned).collect(Collectors.toCollection(HashSet::new));

        return Arrays.stream(paragraph.split("[.,;?'\\s]+"))
                .map(String::toLowerCase)
                .filter(x->!sBanned.contains(x))
                .collect(Collectors.groupingBy(x->x,Collectors.summingInt(x->1)))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry<String,Integer>::getValue)).get().getKey();

    }

    // 347. Top K Frequent Elements
    public static int[] topKFrequent(int[] nums, int k) {
        return IntStream.of(nums)
                .boxed()
                .collect(Collectors.groupingBy(x->x,Collectors.summingInt(x->1)))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry<Integer,Integer>::getValue).reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,1,2,2,3};
        int[] arr2 = {2,2,1,3,3,3};
        int[] arr3 = {3};

        String paragraph="Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned= {"hit"};

        System.out.println(mostCommonWord(paragraph,banned));
        System.out.println(Arrays.toString(topKFrequent(arr1,2)));
    }
}
