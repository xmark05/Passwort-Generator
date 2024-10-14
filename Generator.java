import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Generator {
    private static final int INFORMATION_MESSAGE = 0;
    static Random randomNum = new Random();
    static Character[] finalPasswordArray = new Character[16];

    static void generate() {
       for (int i = 0; i  < 16; i++) {
        int characterType = randomNum.nextInt(4);

        if (characterType == 0) {
            finalPasswordArray[i] = (char)(randomNum.nextInt(10) + '0'); //Zahl
        }
        else if (characterType == 1) {
            finalPasswordArray[i] = (char)(randomNum.nextInt(26) + 'A'); //Großbuchstaben
        }
        else if (characterType == 2) {
            finalPasswordArray[i] = (char)(randomNum.nextInt(26) + 'a'); //Kleinbuchstaben
        }
        else{
            String specialCharacters = "!§$%&/=!?";
            int position = randomNum.nextInt(specialCharacters.length());
            finalPasswordArray[i] = specialCharacters.charAt(position);
        }
       }

       while (Arrays.stream(finalPasswordArray).noneMatch(Character::isDigit) || Arrays.stream(finalPasswordArray).noneMatch(Character::isLowerCase) || Arrays.stream(finalPasswordArray).noneMatch(Character::isUpperCase) || Arrays.stream(finalPasswordArray).allMatch(Character::isLetterOrDigit)) {
        for (int i = 0; i  < 16; i++) {
            int characterType = randomNum.nextInt(4);
    
            if (characterType == 0) {
                finalPasswordArray[i] = (char)(randomNum.nextInt(10) + '0'); //Zahl
            }
            else if (characterType == 1) {
                finalPasswordArray[i] = (char)(randomNum.nextInt(26) + 'A'); //Großbuchstaben
            }
            else if (characterType == 2) {
                finalPasswordArray[i] = (char)(randomNum.nextInt(26) + 'a'); //Kleinbuchstaben
            }
            else{
                String specialCharacters = "!§$%&/=!?";
                int position = randomNum.nextInt(specialCharacters.length());
                finalPasswordArray[i] = specialCharacters.charAt(position);
            }
           }
       }

       JOptionPane.showMessageDialog(null, Arrays.stream(finalPasswordArray).map(String::valueOf).collect(Collectors.joining()), "Your new password", INFORMATION_MESSAGE);
       System.exit(0);
    }

}
