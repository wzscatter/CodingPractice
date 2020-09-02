package LeetCode_Mid.DFS;
import java.util.ArrayList;
import java.util.List;
public class M_207_anycycle {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> course = new ArrayList<>(numCourses);
        int[] visited = new int[numCourses];
        for(int i = 0;i <prerequisites.length;i++){
            course.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i = 0;i<numCourses;i++) {
            if(!dfs(i,visited,course))return false;
        }
        return true;
    }
    private boolean dfs(int curCourse,int[] visited,List<List<Integer>> course) {
        if(visited[curCourse]==1) return false;
        if(visited[curCourse]==2) return true;
        visited[curCourse]=1;
        List<Integer> childern = course.get(curCourse);
        for(int i = 0;i<childern.size();i++){

            if(!dfs(childern.get(i),visited,course)) return false;
        }
        visited[curCourse] =2;
        return true;

    }
}
