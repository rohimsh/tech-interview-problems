package tech.interview.problems.divideconquer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FindAllPossibleValuesForSum {
    public static void main(String[] args) {
        combinationSum(new int[]{1, 2, 3, 4, 1, 1, 1}, 4).forEach(System.out::println);
    }

    public static void backTrack(Set<List<Integer>> result, LinkedList<Integer> tmp, int index, int[] candidates, int target)
    {
        if(target == 0)
        {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = index; i < candidates.length;i++)
        {
            int remaining = target - candidates[i];
            if(remaining >= 0)
            {
                tmp.add(candidates[i]);
                backTrack(result, tmp, i, candidates, remaining);
                tmp.removeLast();
            }
        }
    }
    public static Set<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        LinkedList<Integer> temp = new LinkedList<>();
        backTrack(result, temp,0, candidates, target);
        return result;
    }
}
