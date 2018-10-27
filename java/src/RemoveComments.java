import java.util.ArrayList;
import java.util.List;

/**
 * Creator : wangtaishan
 * Date : 2018/8/27
 * Title : 722. Remove Comments
 * Description :
 *
 *
 * Analysis :
 */

public class RemoveComments {
    public List<String> removeComments(String[] source) {
        List<String> list = new ArrayList<>();
        boolean open = false;
        StringBuilder sb = new StringBuilder();
        for(String string : source){
            if(open == false) sb = new StringBuilder();
            int i = 0;
            for(i = 0; i < string.length() - 1; i++){
                if(open == false){
                    //check inline comment
                    if(string.charAt(i) == '/'){
                        if(string.charAt(i + 1) == '/'){
                            i = string.length();
                            break;
                        }
                        else if(string.charAt(i + 1) == '*'){
                            open = true;
                            i++;
                            continue;
                        }
                    }
                    sb.append(string.charAt(i));
                }
                else{
                    if(string.charAt(i) == '*' && string.charAt(i + 1) == '/'){
                        open = false;
                        i++;
                    }
                }

            }
            if(open == false && i == string.length() - 1) sb.append(string.charAt(i));
            if(sb.length() != 0 && open == false) list.add(sb.toString());
        }
        return list;
    }
}
