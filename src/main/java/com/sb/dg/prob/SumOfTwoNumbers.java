package com.sb.dg.prob;

import java.util.HashSet;
import java.util.Set;

/**
 * <H1>You've built an inflight entertainment system with on-demand movie streaming.</H1>
 * <p>
 * Users on longer flights like to start a second movie right when their first one ends, but they complain that the plane usually lands before they can see the ending. So you're building a feature for choosing two movies whose total runtimes will equal the exact flight length.
 * <p>
 * Write a method that takes an integer flightLength (in minutes) and an array of integers movieLengths (in minutes) and returns a boolean indicating whether there are two numbers in movieLengths whose sum equals flightLength.
 * <p>
 * When building your method:
 * <p>
 * Assume your users will watch exactly two movies
 * Don't make your users watch the same movie twice
 * Optimize for runtime over memory<p></p>
 * <a href="https://www.interviewcake.com/question/java/inflight-entertainment">Inflight Entertainment Interview Cake</a>
 * <p></p>
 * <b>Bonus</b>
 * <ul><li>  What if we wanted the movie lengths to sum to something close to the flight length (say, within 20 minutes)?
 * </li><li> What if we wanted to fill the flight length as nicely as possible with any number of movies (not just 2)?
 * </li><li> What if we knew that movieLengths was sorted? Could we save some space and/or time?
 * </li></ul>
 */
public class SumOfTwoNumbers {

    public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength) {

        Set<Integer> integerSet = new HashSet<>();
        for (int movieLength : movieLengths) {
            int diff = flightLength - movieLength;
            if (integerSet.contains(diff)) {
                return true;
            } else
                integerSet.add(movieLength);
        }
        return false;
    }
}
