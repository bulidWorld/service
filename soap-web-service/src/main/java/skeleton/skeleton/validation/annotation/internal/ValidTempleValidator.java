package skeleton.skeleton.validation.annotation.internal;

import skeleton.skeleton.validation.annotation.ValidTemple;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**validtor用来验证被注解的元素是否满足要求
 * Created by Administrator on 2017/7/15.
 */
public class ValidTempleValidator implements ConstraintValidator<ValidTemple, String> {
   public void initialize(ValidTemple constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      return true;
   }
}
