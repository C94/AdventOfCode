package com.chandler.aoc.year22;

import com.chandler.aoc.common.Day;

import static java.lang.Integer.parseInt;

public class Day4 extends Day {

    public static void main(String[] args) {
        new Day4().printParts();
    }

    private record Assignment(int elf1Start, int elf1End, int elf2Start, int elf2End) {
        public Assignment(String line) {
            this(
                parseInt(line.split(",")[0].split("-")[0]),
                parseInt(line.split(",")[0].split("-")[1]),
                parseInt(line.split(",")[1].split("-")[0]),
                parseInt(line.split(",")[1].split("-")[1])
            );
        }

        private boolean doesOverlapPart1() {
            return elf1Start <= elf2Start && elf1End >= elf2End || elf2Start <= elf1Start && elf2End >= elf1End;
        }

        private boolean doesOverlapPart2() {
            return (elf2Start >= elf1Start && elf2Start <= elf1End || elf2End >= elf1Start && elf2End <= elf1End)
                || (elf1Start >= elf2Start && elf1Start <= elf2End || elf1End >= elf2Start && elf1End <= elf2End);
        }
    }

    @Override
    protected Object part1() {
        return dayStream().map(Assignment::new)
                          .filter(Assignment::doesOverlapPart1)
                          .count();
    }

    @Override
    protected Object part2() {
        return dayStream().map(Assignment::new)
                          .filter(Assignment::doesOverlapPart2)
                          .count();
    }
}
