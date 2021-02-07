package com.chinapost.devp.generate;

import com.chinapost.devp.generate.web.rest.*;
import com.chinapost.devp.generate.web.rest.team.ProjectTeamControllerTest;
import com.chinapost.devp.generate.web.rest.team.ProjectTeamMemberControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 合并测试类
 *
 * @author: cpit
 * @date: 2020/09/13
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        MetaProjectControllerTest.class,
        MetaEntityControllerTest.class,
        MetaFieldControllerTest.class,
        MetaIndexControllerTest.class,
        MetaConstControllerTest.class,
        MetaConstDetailControllerTest.class,
        MetaManyToManyControllerTest.class,
        MetaCascadeExtControllerTest.class,
        ProjectTeamControllerTest.class,
        ProjectTeamMemberControllerTest.class,
})
public class Main {


}
