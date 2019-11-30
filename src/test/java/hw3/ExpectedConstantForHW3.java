package hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface ExpectedConstantForHW3 {

 List<String> EXPECTED_HEADER_SECTIONS_TEXT = new ArrayList<>(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));

 List<String> EXPECTED_SERVICE_HEADER_MENU_ITEMS = new ArrayList<>(Arrays.asList("SUPPORT" , "DATES" , "SEARCH" , "COMPLEX TABLE" , "SIMPLE TABLE" ,
         "USER TABLE" , "TABLE WITH PAGES" , "DIFFERENT ELEMENTS" , "PERFORMANCE"));

 List<String> EXPECTED_SERVICE_LEFT_SECTION_MENU_ITEMS = new ArrayList<>(Arrays.asList("Support" , "Dates" , "Complex Table" , "Simple Table" , "Search" ,
         "User Table" , "Table with pages" , "Different elements" , "Performance"));


 String EXPECTED_FIRST_IMAGE_TEXT = "To include good practices\n" +
         "and ideas from successful\n" +
         "EPAM project";
 String EXPECTED_SECOND_IMAGE_TEXT = "To be flexible and\n" +
         "customizable";
 String EXPECTED_THIRD_IMAGE_TEXT = "To be multiplatform";
 String EXPECTED_FOURTH_IMAGE_TEXT = "Already have good base\n" +
         "(about 20 internal and\n" +
         "some external projects),\n" +
         "wish to get more…";

 List<String> EXPECTED_UNDER_IMAGES_TEXT = new ArrayList<>(Arrays.asList(EXPECTED_FIRST_IMAGE_TEXT, EXPECTED_SECOND_IMAGE_TEXT, EXPECTED_THIRD_IMAGE_TEXT , EXPECTED_FOURTH_IMAGE_TEXT));

 String EXPECTED_MAIN_HEADER = "EPAM FRAMEWORK WISHES…";
 String EXPECTED_MAIN_HEADER_TEXT = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO" +
         " EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
         "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA " +
         "COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
         "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";


}
