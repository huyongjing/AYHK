package org.jeecgframework.core.junit;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
/**
 * 单元测试 抽象基类 加载配置
 * @author  许国杰
 */

@Transactional
public class AbstractUnitTest {
	@Autowired
	protected WebApplicationContext wac;

}
