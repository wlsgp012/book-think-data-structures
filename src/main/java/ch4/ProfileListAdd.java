package ch4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.jfree.data.xy.XYSeries;
import sub.Profiler;
import sub.Profiler.Timeable;

public class ProfileListAdd {

  /**
   *
   */
  public static void main(String[] args) {
//		profileArrayListAddEnd();
//		profileArrayListAddBeginning();
//		profileLinkedListAddBeginning();
    profileLinkedListAddEnd();
  }

  /**
   * Characterize the run time of adding to the end of an ArrayList
   */
  public static void profileArrayListAddEnd() {
    Timeable timeable = new Timeable() {
      List<String> list;

      public void setup(int n) {
        list = new ArrayList<String>();
      }

      public void timeMe(int n) {
        for (int i = 0; i < n; i++) {
          list.add("a string");
        }
      }
    };
    int startN = 512000;
    int endMillis = 5000;
    runProfiler("ArrayList add end", timeable, startN, endMillis);
  }

  /**
   * Characterize the run time of adding to the beginning of an ArrayList
   */
  public static void profileArrayListAddBeginning() {
    Timeable timeable = new Timeable() {
      List<String> list;

      public void setup(int n) {
        list = new ArrayList<>();
      }

      public void timeMe(int n) {
        for (int i = 0; i < n; i++) {
          list.add(0, "a string");
        }
      }
    };
    int startN = 5000;
    int endMillis = 6000;
    runProfiler("ArrayList add beginning end", timeable, startN, endMillis);
  }

  /**
   * Characterize the run time of adding to the beginning of a LinkedList
   */
  public static void profileLinkedListAddBeginning() {
    Timeable timeable = new Timeable() {
      List<String> list;

      public void setup(int n) {
        list = new LinkedList<>();
      }

      public void timeMe(int n) {
        for (int i = 0; i < n; i++) {
          list.add(0, "a string");
        }
      }
    };
    int startN = 512000;
    int endMillis = 5000;
    runProfiler("LinkedList add beginning", timeable, startN, endMillis);
  }

  /**
   * Characterize the run time of adding to the end of a LinkedList
   */
  public static void profileLinkedListAddEnd() {
    Timeable timeable = new Timeable() {
      List<String> list;

      public void setup(int n) {
        list = new LinkedList<>();
      }

      public void timeMe(int n) {
        for (int i = 0; i < n; i++) {
          list.add(list.size(), "a string");
        }
      }
    };
    int startN = 1280000;
    int endMillis = 20000;
    runProfiler("LinkedList add end", timeable, startN, endMillis);
  }

  /**
   * Runs the profiles and displays results.
   */
  private static void runProfiler(String title, Timeable timeable, int startN, int endMillis) {
    Profiler profiler = new Profiler(title, timeable);
    XYSeries series = profiler.timingLoop(startN, endMillis);
    profiler.plotResults(series);
  }
}
