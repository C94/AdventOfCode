package com.chandler.aoc.year2021;

import com.chandler.aoc.common.Day;

import java.util.List;

import static com.google.common.math.Quantiles.median;
import static com.google.common.math.Stats.meanOf;
import static java.lang.Math.abs;
import static java.lang.Math.floor;

@SuppressWarnings("UnstableApiUsage")
public class Day07 extends Day {

    public static void main(String[] args) {
        new Day07().run();
    }

    @Override
    public Object part1() {
        return getFuelCost(getCrabPositions());
    }

    @Override
    public Object part2() {
        return getFuelCostPartTwo(getCrabPositions());
    }

    private List<Integer> getCrabPositions() {
        return stream(",")
                .map(Integer::valueOf)
                .toList();
    }

    private Long getFuelCost(List<Integer> crabPositions) {
        var median = (long) median().compute(crabPositions);
        return crabPositions.stream()
                            .map(it -> abs(it - median))
                            .reduce(Long::sum)
                            .orElseThrow();
    }

    private Long getFuelCostPartTwo(List<Integer> crabPositions) {
        var avg = (long) floor(meanOf(crabPositions));
        return crabPositions.stream()
                            .map(it -> abs(it - avg))
                            .map(it -> (it * (it + 1)) / 2)
                            .reduce(Long::sum)
                            .orElseThrow();
    }
}
