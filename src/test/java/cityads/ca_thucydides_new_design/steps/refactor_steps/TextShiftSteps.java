/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cityads.ca_thucydides_new_design.steps.refactor_steps;

import cityads.ca_thucydides_new_design.pages.refactor.TextShift;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 *
 * @author s.lugovskiy
 */
public class TextShiftSteps extends ScenarioSteps {

    public TextShift shift;

    @Step
    public void create_text_shift(String name,String subacc){
        shift.createTextShift(name, subacc);
    }

    @Step
    public String create_text_shift_and_check_code(String name, String subacc){
       String code = shift.createTextShiftAndGetCode(name, subacc);
       return code;

    }

    @Step
    public void get_text_shift_code_from_table_java_script(){
        shift.get_textshift_code_from_icon_table();
    }
    @Step
    public void get_text_shift_code_from_table_extensions(){
        shift.get_textshift_code_from_icon_table_and_choose_extensions();

    }

}
    

