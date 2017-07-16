package skeleton.skeleton.validation.annotation;

import skeleton.skeleton.validation.annotation.internal.ValidTempleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;

/**
 * 自定义注解的规范格式
 * @Pattern 为注解上的注解，可以添加已经定义的注解
 * @Constraint 为这个验证这个注解需要的类
 * groups,message,payload,都为必须的值，且有默认值为空
 * 内部注解List为分组的信息，必须，含有一个外部类的数组值
 *
 * Created by Administrator on 2017/7/15.
 */
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD
            ,ElementType.ANNOTATION_TYPE.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidTempleValidator.class)
@Pattern(regexp = "^GD[0-9]{9,12}END$", flags = Pattern.Flag.CASE_INSENSITIVE)
@ReportAsSingleViolation
public @interface ValidTemple{
    String message() default "not valid value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};



    @Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD
            ,ElementType.ANNOTATION_TYPE.CONSTRUCTOR})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    static @interface List{
        ValidTemple value();
    }
}
