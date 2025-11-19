public class PrefixReverse {
    public static void main(String []args){
        //given a string s, reverse the prefix ending at each index, eg abcd givren so a ba bca dcba
        String str="abcd";
        for(int i=0;i<str.length();i++){            
            String prefix = str.substring(0, i + 1);
            String suffix = str.substring(i + 1);
            String reversedPrefix = new StringBuilder(prefix).reverse().toString();
            System.out.println(reversedPrefix + suffix);
        }

    }
}

