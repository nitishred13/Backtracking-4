import java.util.List;
//We break string into character groups and sort in curly braces individually 
//We use DFS to build all possible strings by picking one character from eah group
//When we finish all groups, we add the built string to the final result list

//Time Complexity:O(k^n)
//Space Complexity: O(n+k^n)
public class WordListBrace {
    List<String> result;
    public String[] expand(String s)
    {
        this.result = new ArrayList<>();
        List<List<Character>> groups = new ArrayList<>();
        int i=0;
        while(i<s.length())
        {
            List<Character> group = new ArrayList<>();
            if(s.charAt(i)=='{')
            {
                i++;
                while(s.charAt(i)!='}')
                {
                    if(s.charAt(i)!=',')
                    {
                        group.add(s.charAt(i));
                    }
                    i++;
                }
                i++;
            }
            else
            {
                group.add(s.charAt(i));
                i++;
            }
            Collections.sort(group);
            groups.add(group);
        }
        helper(groups,0,new StringBuilder());
        return result.toArray(new String[0]);
    } 
    
    private void helper(List<List<Character>> groups, int idx, StringBuilder path)
    {
        if(idx==groups.size())
        {
            result.add(path.toString());
            return;
        }
        List<Character> currGroup = groups.get(idx);
        for(int i=0;i<currGroup.size();i++)
        {
            int le = path.length();
            path.append(currGroup.get(i));
            helper(groups,idx+1,path);
            path.setLength(le);
        }
    }
}
