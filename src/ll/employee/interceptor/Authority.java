package ll.employee.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//��ʾ��ʲô���𱣴��ע��
@Retention(RetentionPolicy.RUNTIME)
//��ʾ��ע������ʲô�ط�
@Target({ElementType.METHOD})

public @interface Authority {
	String value();
	

}
