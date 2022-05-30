package EasyString;

public class LongPressedName {
    public static void main(String[] args) {
        String name = "alex", typed = "aaleex";
        System.out.println(isLongPressedName(name,typed));
    }

    public static boolean isLongPressedName(String name, String typed) {

        //if name is bigger than the typed
        if(name.length()>typed.length())
            return false;

        //take two pointers
        int i=0;
        int j=0;

        while(i< name.length() && j< typed.length())
        {
            //if element at i and j are equal move both pointer forward
            if(name.charAt(i) == typed.charAt(j))
            {
                i++;
                j++;
            }
            else if(i>0 && name.charAt(i-1) == typed.charAt(j))
            {
                j++;
            }else{
                return false;
            }
        }


        while(j<typed.length())
        {
            if(name.charAt(i-1) != typed.charAt(j))
                return false;
            j++;
        }

        return i<name.length() ? false: true;
    }
}
